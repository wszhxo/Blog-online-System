package cn.coderzhx.service.impl;

import cn.coderzhx.entity.Blog;
import cn.coderzhx.entity.BlogCategory;
import cn.coderzhx.entity.Tags;
import cn.coderzhx.mapper.BlogMapper;
import cn.coderzhx.pojo.PageBean;
import cn.coderzhx.service.BlogService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhx
 * @create 2019-07-16-14
 */
@Service
class BlogServiceImpl implements BlogService {
    @Resource
    BlogMapper blogMapper;

    @Override
    public PageBean listBlogs(PageBean pageBean) {
        int size=blogMapper.countBlog(pageBean);
        PageBean pageBean2=new PageBean(pageBean.getCurrentPage(),size,pageBean.getPageSize());
        pageBean.setIndex(pageBean2.getIndex());
        pageBean.setTotalCount(pageBean2.getTotalCount());
        pageBean.setTotalPage(pageBean2.getTotalPage());
        pageBean.setCurrentPage(pageBean2.getCurrentPage());
        pageBean.setList(blogMapper.listBlogs(pageBean));
        return pageBean;
    }
    @Override
    public PageBean listBlogsAdmin(PageBean pageBean) {
        int size=blogMapper.countBlog(pageBean);
        PageBean pageBean2=new PageBean(pageBean.getCurrentPage(),size,pageBean.getPageSize());
        pageBean.setIndex(pageBean2.getIndex());
        pageBean.setTotalCount(pageBean2.getTotalCount());
        pageBean.setTotalPage(pageBean2.getTotalPage());
        pageBean.setList(blogMapper.listBlogsAdmin(pageBean));
        return pageBean;
    }

    @Override
    @Cacheable(cacheNames = "findBlogById")
    public Blog findBlogById(int id) {
        System.out.println("缓存测试");
        return  blogMapper.findBlogById(id);
    }

    @Override
    public void addHits(int id) {
        blogMapper.addHits(id);
    }
    @Override
    public void addLike(Integer id) {
        blogMapper.addLike(id);
    }

    @Override
    public Blog findBeforeBlog(Integer id) {
        Blog beforeBlog = blogMapper.findBeforeBlog(id);
        if (beforeBlog==null){
            beforeBlog=new Blog();
            beforeBlog.setTitle("没有上一篇了！");
        }
        return beforeBlog;
    }

    @Override
    public Blog findAfterBlog(Integer id) {
         Blog afterBlog = blogMapper.findAfterBlog(id);
        if (afterBlog==null){
            afterBlog=new Blog();
            afterBlog.setTitle("没有下一篇了！");
        }
        return afterBlog;
    }

    @Override
    public int addBlog(Blog blog) {
        return blogMapper.addBlog(blog);
    }


    @Override
    public List<BlogCategory> listCategory() {

        List<BlogCategory> blogCategories = blogMapper.listCategory();
        //把该标签的文章数量
        for (BlogCategory blogCategory : blogCategories) {
            blogCategory.setCount(blogMapper.countBlogCategoty(blogCategory.getId()));
        }
        return blogCategories;
    }

    @Override
    public List<Tags> listTags(int id) {
        return blogMapper.listTags(id);
    }

    @Override
    @CacheEvict(cacheNames = "findBlogById", key = "#id")
    public void delBlog(Integer id) {
        blogMapper.delBlog(id);
        Tags tags = new Tags();
        tags.setBlog_id(id);
        //删除标签
        blogMapper.delTags(tags);

    }

    @Override
    @CachePut(cacheNames = "findBlogById", key = "#blog.id")
    public void editBlog(Blog blog) {
        blogMapper.editBlog(blog);
    }

    @Override
    public void addTags(int id, String[] tags) {
        for (int i = 0; i <tags.length ; i++) {
            Tags tags1=new Tags();
            tags1.setTag_name(tags[i]);
            if (id!=0) {
                tags1.setBlog_id(id);blogMapper.addTags(tags1);
            }else{
                blogMapper.addTags2(tags1);
            }
            blogMapper.setTagUrl(tags[i],tags1.getId());
        }

    }
    @Override
    public void   batchdelBLog(String[] id) {
        for (int i = 0; i <id.length ; i++) {
            blogMapper.delBlog(Integer.parseInt(id[i]));
            Tags tags = new Tags();
            tags.setBlog_id(Integer.parseInt(id[i]));
            blogMapper.delTags(tags);
        }
    }
    @Override
    public void delTags(Tags tags) {
        blogMapper.delTags(tags);
    }
    @Override
    public void addCategory(BlogCategory blogCategory) {
        blogMapper.addCategory(blogCategory);
        blogMapper.setUrl(blogCategory.getId());
    }
    @Override
    public void delCategory(int id) {
        blogMapper.delCategory(id);
    }

    @Override
    public void editCategory(BlogCategory blogCategory) {
        blogMapper.editCategory(blogCategory);
    }

}
