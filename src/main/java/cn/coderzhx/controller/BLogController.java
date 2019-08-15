package cn.coderzhx.controller;

import cn.coderzhx.entity.Blog;
import cn.coderzhx.entity.BlogCategory;
import cn.coderzhx.entity.Tags;
import cn.coderzhx.service.BlogService;
import cn.coderzhx.utils.BlogIndex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhx
 * @create 2019-07-22-20
 */
@RequestMapping("/blog")
@Controller
public class BLogController {
    @Resource
    BlogService blogService;
    private BlogIndex blogIndex=new BlogIndex();
    //点击标题,或者图片 进入文章详情页
    @GetMapping("/{id}")
    public String findBlogById(@PathVariable("id") Integer id,Model model) throws Exception {
        final Blog blogById = blogService.findBlogById(id);
        //上一篇下一篇文
        final Blog beforeBlog=blogService.findBeforeBlog(id);
        final Blog afterBlog=blogService.findAfterBlog(id);
        //列出标签
        List<Tags> tags = blogService.listTags(id);
        //添加点击量
        blogService.addHits(id);
        model.addAttribute("blogById",blogById);
        model.addAttribute("listTags",tags);
        model.addAttribute("beforeBlog",beforeBlog);
        model.addAttribute("afterBlog",afterBlog);
//        List<Blog> listBlogs= blogIndex.searchBlog(pageBean.getWord());
        // 添加索引
        // blogIndex.addIndex();
        IndexController.showMenu(model);
        return "info";

    }
    //跳转到文章分类页面
    @GetMapping("/toPageeditCategorys")
    public String  toPageeditCategory(BlogCategory blogCategory, Model model) {
        model.addAttribute("blogCategory",blogCategory);
        return "admin/blog/addCategory";
    }

    @RequestMapping ("/{id}")
    public @ResponseBody  String dianzan(@PathVariable("id") Integer id){
        //点赞
        blogService.addLike(id);
        return "success";
    }

    //回显标签和分类
    @GetMapping("/listcatAndTag")
    public String  toaddBlog( Model model){
        List<BlogCategory> blogCategory = blogService.listCategory();
        List<Tags> tags = blogService.listTags(0);
        model.addAttribute("blogCategory",blogCategory);
        model.addAttribute("tags",tags);
        return "admin/blog/full";
    }
    //回显分类
    @GetMapping("/toeditBlog/{id}")
    public String  toeditBlog( Model model,@PathVariable("id") Integer id){
        List<BlogCategory> blogCategory = blogService.listCategory();
        Blog blog=blogService.findBlogById(id);
        model.addAttribute("blogCategory",blogCategory);
        model.addAttribute("blog",blog);
        return "admin/blog/full";
    }
}
