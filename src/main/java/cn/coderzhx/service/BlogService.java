package cn.coderzhx.service;

import cn.coderzhx.entity.Blog;
import cn.coderzhx.entity.BlogCategory;
import cn.coderzhx.entity.Tags;
import cn.coderzhx.pojo.PageBean;

import java.util.List;

/**
 * @author zhx
 * @create 2019-07-22-20
 */
public interface BlogService {
    PageBean listBlogs(PageBean pageBean);
    PageBean listBlogsAdmin(PageBean pageBean);
    Blog findBlogById(int id);
    void addLike(Integer id);
    Blog findBeforeBlog(Integer id);
    Blog findAfterBlog(Integer id);
    int addBlog(Blog blog);
    void addHits(int id);
    List<BlogCategory> listCategory();
    List<Tags> listTags(int id);
    void delBlog(Integer id);
    void editBlog(Blog blog);
    void addTags(int id, String[] tags);
    void batchdelBLog(String[] id);
    void delTags(Tags tags);
    void addCategory(BlogCategory blogCategory);
    void delCategory(int id);
    void editCategory(BlogCategory blogCategory);
}
