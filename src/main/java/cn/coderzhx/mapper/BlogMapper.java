package cn.coderzhx.mapper;

import cn.coderzhx.entity.Blog;
import cn.coderzhx.entity.BlogCategory;
import cn.coderzhx.entity.Tags;
import cn.coderzhx.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author zhx
 * @create 2019-07-16-14
 */
@Mapper
@Configuration
public interface BlogMapper {
    List<Blog> listBlogs(PageBean pageBean);
    List<Blog> listBlogsByCategory(PageBean pageBean);
    List<Blog> listBlogsByTags(PageBean pageBean);
    List<Blog> listBlogsAdmin(PageBean pageBean);
    int countBlog(PageBean pageBean);
    Blog findBlogById(int id);
    void addLike(Integer id);
    void addHits(int id);
    Blog findBeforeBlog(Integer id);
    Blog findAfterBlog(Integer id);
    int addBlog(Blog blog);
    List<BlogCategory> listCategory();
    List<Tags> listTags(@Param("id") Integer id);
    void delBlog(@Param("id") Integer id);
    void editBlog(Blog blog);
    void addTags(Tags tags);
    void addTags2(Tags tags);
    void setTagUrl(@Param("tagName") String tagName,@Param("id") int id);
    void delTags(Tags tags);
    void addCategory(BlogCategory blogCategory);
    void setUrl(@Param("id") int id);
    void delCategory(@Param("id") int id);
    void editCategory(BlogCategory blogCategory);
    int countBlogCategoty(@Param("category_id") int category_id);


//5篇点击最高的
    List<Blog> listHitsBlog();
//时间轴
    List<Blog> listTime();
    List<Blog> listBlogsByCategory2(@Param("categoryId") Integer categoryId);
}
