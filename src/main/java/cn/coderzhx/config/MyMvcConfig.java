package cn.coderzhx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zhx
 * @create 2019-07-29-15
 */
@Configuration
public class MyMvcConfig  extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //到登录界面
        registry.addViewController("/admin").setViewName("admin/login");
        //后台主页
        registry.addViewController("/admin/welcome").setViewName("admin/welcome");
        //文章列表
        registry.addViewController("/admin/blog").setViewName("admin/blog/list");
        //文章标签
        registry.addViewController("/admin/tags").setViewName("admin/blog/tags");
        //文章分类
        registry.addViewController("/admin/category").setViewName("admin/blog/category");
        //留言
        registry.addViewController("/admin/comment").setViewName("admin/message/comment");
        //友情链接
        registry.addViewController("/admin/link").setViewName("admin/config/link");
        //前台菜单
        registry.addViewController("/admin/menu").setViewName("admin/config/menu");
        //友情后台菜单
        registry.addViewController("/admin/menu_admin").setViewName("admin/config/menu_admin");
        //网站基本配置
        registry.addViewController("/admin/base").setViewName("admin/config/base");
        //添加标签
        registry.addViewController("/admin/addTag").setViewName("admin/blog/addTag");
        //添加标签
        registry.addViewController("/admin/addCategory").setViewName("admin/blog/addCategory");
    }
}
