package cn.coderzhx.controller;

import cn.coderzhx.entity.Blog;
import cn.coderzhx.entity.BlogCategory;
import cn.coderzhx.entity.Tags;
import cn.coderzhx.mapper.BlogMapper;
import cn.coderzhx.pojo.PageBean;
import cn.coderzhx.service.BlogService;
import cn.coderzhx.utils.BlogIndex;
import cn.coderzhx.utils.LayuiJSON;
import cn.coderzhx.utils.QiniuUpload;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Calendar;
import java.util.List;

/**
 * @author zhx
 * @create 2019-07-30-20
 */

@RestController
@RequestMapping("/admin")
public class AdminBlogController {

    @Resource
    BlogService blogService;
    @Resource
    private BlogMapper blogMapper;
    private BlogIndex blogIndex=new BlogIndex();
    //文章中的上传图片
    @RequestMapping("/uploadImg")
    public String  uploadImg(HttpServletRequest request, @RequestParam(value = "editormd-image-file", required = false) MultipartFile file){
        try {
            //获得web项目的全路径
            String rootPath = request.getSession().getServletContext().getRealPath("/resource/upload/");
            //Calendar.getInstance()是获取一个Calendar对象并可以进行时间的计算，时区的指定
            Calendar date = Calendar.getInstance();
            //获得日期路径,MONTH个值的初始值是0，因此我们要用它来表示正确的月份时就需要加1。
            File dateFile = new File(date.get(Calendar.YEAR)+"/"+(date.get(Calendar.MONTH)+1)+"/"+(date.get(Calendar.DATE)));
            //获得文件最初的路径
            String originalFile = file.getOriginalFilename();
            //得到完整路径名
            File newFile = new File(rootPath+File.separator+dateFile+File.separator+originalFile);

            /*文件不存在就创建*/
            if(!newFile.getParentFile().exists()){
                newFile.getParentFile().mkdirs();
            }
            file.transferTo(newFile);
//            System.out.println("/resource/upload/"+date.get(Calendar.YEAR)+"/"+(date.get(Calendar.MONTH)+1)+"/"+date.get(Calendar.DATE)+"/"+file.getOriginalFilename());
            String url="/resource/upload/"+date.get(Calendar.YEAR)+"/"+(date.get(Calendar.MONTH)+1)+"/"+date.get(Calendar.DATE)+"/"+file.getOriginalFilename();
            return LayuiJSON.jsonImg(1,"上传成功",url);

        } catch (Exception e) {
            return LayuiJSON.jsonImg(0,"上传失败","");

        }
    }
    //获取七牛云token,用于封面上传
    @RequestMapping("/uploadqiniu")
    public String  uploadImg(){
        return QiniuUpload.getUpToken();
    }

    //后台列出文章
    @RequestMapping("/listBlog")
    public String  listBlog(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "limit", defaultValue = "7") Integer limit,
                            PageBean pageBean){
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(limit);
        PageBean<Blog> list = blogService.listBlogsAdmin(pageBean);
        //由于layui中table.render中field缘故
        for (Blog blog : list.getList()) {
            blog.setName(blog.getBlogCategory().getName());
        }

        return LayuiJSON.jsonStr("",list.getTotalCount(),list.getList());
    }
    //添加文章
    @GetMapping("/addBlog")
    public String  listBlog(@RequestParam(value = "tags") String[] tags,Blog blog) throws Exception {
        //获取id用于标签添加，只要getId就好了
        blogService.addBlog(blog);
        //添加文章索引
        blogIndex.addIndex(blog);
        if (tags!=null)blogService.addTags( blog.getId(),tags);
        return "success";
    }

    //获取分类下拉框
    @GetMapping("/getCategory")
    public String  getCategory(){
        List<BlogCategory> blogCategory = blogService.listCategory();
        return LayuiJSON.jsonStr("",0,blogCategory);
    }

    //删除文章
    @GetMapping("/delBlog/{id}")
    public String  delBlog(@PathVariable("id") Integer id) throws Exception {
        blogService.delBlog(id);
        //删除索引
        blogIndex.deleteIndex(String.valueOf(id));
        return "success";
    }
    //批量删除文章
    @GetMapping("/batchdelBLog")
    public String  batchdelBLog(String id) throws Exception {
        String[] arr=id.split(",");
        blogService.batchdelBLog(arr);
        for (int i = 0; i <arr.length ; i++) {
            blogIndex.deleteIndex(String.valueOf(id));
        }
        return "success";
    }
    //修改文章
    @GetMapping("/editBlog")
    public String  editBlog(Blog blog) throws Exception {
        blogService.editBlog(blog);
        blogIndex.updateIndex(blog);
        return "success";
    }
    //添加标签
    @GetMapping("/addTags")
    public String  addTag(Integer id,String tags){
        String[] s={tags};
        blogService.addTags(id,s);
        return "success";
    }
    //列出标签
    @GetMapping("/listTags/{id}")
    public String  listTags(@PathVariable("id")int id){
        List<Tags> tags = blogService.listTags(id);
        return LayuiJSON.jsonStr("",tags.size(),tags);
    }
    //展示标签
    @GetMapping("/findTags2/{id}")
    public String  findTags2(@PathVariable("id")int id){
        List<Tags> tags = blogService.listTags(id);
        String str="";
        for (int i = 0; i <tags.size() ; i++) {
            str=tags.get(i).getTag_name()+",";
        }
        return str;
    }
    //删除某个文章的标签
    @GetMapping("/delTags")
    public String  delTags(Tags tags){
        blogService.delTags(tags);
        return "success";
    }
    //添加文章分类
    @GetMapping("/addCategorys")
    public String  addCategory(BlogCategory blogCategory){
        blogService.addCategory(blogCategory);
        return "success";
    }
    //删除文章分类
    @GetMapping("/delCategorys/{id}")
    public String  delCategory(@PathVariable("id") int id){
        blogService.delCategory(id);
        return "success";
    }

    //编辑文章分类
    @GetMapping("/editCategorys")
    public String  editCategorys(BlogCategory blogCategory) {
        blogService.editCategory(blogCategory);
        return "success";
    }
    //列出分类
    @RequestMapping ("/listCategory")
    public @ResponseBody  String listCategory(){
        List<BlogCategory> blogCategory=blogService.listCategory();
        return LayuiJSON.jsonStr("",blogCategory.size(),blogCategory);
    }
}
