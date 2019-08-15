package cn.coderzhx.utils;

import cn.coderzhx.entity.Blog;
import cn.coderzhx.pojo.LucenePath;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.StringReader;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhx
 * @create 2019-07-20-20
     * #博客索引类
     * @author Administrator
     */
    public class BlogIndex {

        private Directory dir;
         LucenePath path ;


        /**
         *  # 获取IndexWriter实例    返回写索引实例
         *
         * windows和Linux路径不一样
         * @throws Exception
         */
        private IndexWriter getWriter()throws Exception{
            //2 索引目录类,指定索引在硬盘中的位置
            dir= FSDirectory.open(Paths.get(path.getPath()));
            //3 创建分词器对象 这里是中文分词器,还有IK分词器
            SmartChineseAnalyzer analyzer=new SmartChineseAnalyzer();
            //4 索引写出工具的配置对象 来设置其相关配置
            IndexWriterConfig iwc=new IndexWriterConfig(analyzer);
            //5 创建索引的写出工具类。参数：索引的目录和配置信息
            //我们最终是实例化这个东西。 IndexWriter 写索引实例
            IndexWriter writer=new IndexWriter(dir, iwc);
            return writer;
        }


        /**
         * #添加博客索引
         * @param blog
         * @throws Exception
         */
        public void addIndex(Blog blog)throws Exception{
            IndexWriter writer=getWriter();
            Document doc=new Document();
            doc.add(new StringField("id",String.valueOf(blog.getId()), Field.Store.YES));
            doc.add(new TextField("title",blog.getTitle(),Field.Store.YES));
            doc.add(new TextField("summary",blog.getSummary(),Field.Store.YES));
            //6 把文档交给IndexWriter
            writer.addDocument(doc);
            //7 提交
            writer.commit();
            //8 关闭
            writer.close();
        }

        /**
         * #更新博客索引
         */
        public void updateIndex(Blog blog)throws Exception{
            IndexWriter writer=getWriter();
            Document doc=new Document();
            doc.add(new StringField("id",String.valueOf(blog.getId()),Field.Store.YES));
            doc.add(new TextField("title",blog.getTitle(),Field.Store.YES));
            doc.add(new TextField("summary",blog.getSummary(),Field.Store.YES));
            writer.updateDocument(new Term("id",String.valueOf(blog.getId())), doc);
            writer.close();
        }


        /**
         * 删除指定博客的索引
         * @param blogId,String RootPath
         * @throws Exception
         */
        public void deleteIndex(String blogId)throws Exception{
            IndexWriter writer=getWriter();
            writer.deleteDocuments(new Term("id",blogId));
            writer.forceMergeDeletes(); // 强制删除
            writer.commit();
            writer.close();
        }

        /**
         *# 查询博客信息
         * @param q
         * @return
         * @throws Exception
         */
        public List<Blog> searchBlog(String q)throws Exception{
            dir=FSDirectory.open(Paths.get(path.getPath()));
            //索引读取工具
            IndexReader reader= DirectoryReader.open(dir);
            //索引搜索工具
            IndexSearcher is=new IndexSearcher(reader);
            BooleanQuery.Builder booleanQuery=new BooleanQuery.Builder();

            // 创建查询解析器,两个参数：默认要查询的字段的名称，中文分词器
            SmartChineseAnalyzer analyzer=new SmartChineseAnalyzer();
            QueryParser parser=new QueryParser("title", analyzer);
            //创建查询对象
            Query query=parser.parse(q);

            QueryParser parser2=new QueryParser("summary", analyzer);
            Query query2=parser2.parse(q);

            booleanQuery.add(query, BooleanClause.Occur.SHOULD);
            booleanQuery.add(query2, BooleanClause.Occur.SHOULD);
            // 搜索数据,两个参数：查询条件对象要查询的最大结果条数
            // 返回的结果是 按照匹配度排名得分前N名的文档信息（包含查询到的总条数信息、所有符合条件的文档的编号信息）。
            TopDocs hits=is.search(booleanQuery.build(), 100);
            // 获取总条数
            System.out.println("本次搜索共找到" + hits.totalHits + "条数据");
            //把得分高的片段摘要出来
            QueryScorer scorer=new QueryScorer(booleanQuery.build());
            Fragmenter fragmenter=new SimpleSpanFragmenter(scorer);
            //把得分高的片段摘要出来

            //格式化前缀和后缀
            SimpleHTMLFormatter simpleHTMLFormatter=new SimpleHTMLFormatter("<b><font color='#ff7500'>", "</font></b>");
            //格式化前缀和后缀

            Highlighter highlighter=new Highlighter(simpleHTMLFormatter, scorer);
            highlighter.setTextFragmenter(fragmenter);

            // 获取得分文档对象（ScoreDoc）数组.SocreDoc中包含：文档的编号、文档的得分
            List<Blog> blogList=new LinkedList<Blog>();
            for(ScoreDoc scoreDoc:hits.scoreDocs){
                // 根据编号去找文档
                Document doc=is.doc(scoreDoc.doc);

                Blog blog=new Blog();
                blog.setId(Integer.parseInt(doc.get("id")));
                String title=doc.get("title");
                if(title!=null){
                    TokenStream tokenStream=analyzer.tokenStream("title", new StringReader(title));
                    String hTitle=highlighter.getBestFragment(tokenStream, title);

                    if(StringUtil.isEmpty(hTitle)){
                        blog.setTitle(title);
                    }else{
                        blog.setTitle(hTitle);
                    }
                }
                //过虑掉html中的<标签>

                String summary=doc.get("summary");//这个content取得是  notag的content  索引中的
                //把<>转义成   &lt; <    &gt; >
//                summary = summary.replace("<", "&lt;");
//                summary =  summary.replace(">", "&gt;");
                //String content= doc.get("content");
                if(summary!=null){
                    TokenStream tokenStream=analyzer.tokenStream("summary", new StringReader(summary));
                    String hSummary=highlighter.getBestFragment(tokenStream, summary);

                    if(StringUtil.isEmpty(hSummary)){
                        if(summary.length()<=200){
                            blog.setSummary(summary);
                        }else{
                            blog.setSummary(summary.substring(0, 200));
                        }
                    }else{
                        blog.setSummary(hSummary);
                    }
                }
                blogList.add(blog);
            }
            return blogList;
        }

    }
