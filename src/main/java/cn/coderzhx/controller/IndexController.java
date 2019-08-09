package cn.coderzhx.controller;

import cn.coderzhx.entity.Blog;
import cn.coderzhx.entity.Config;
import cn.coderzhx.entity.Link;
import cn.coderzhx.entity.Menu;
import cn.coderzhx.mapper.BlogMapper;
import cn.coderzhx.pojo.PageBean;
import cn.coderzhx.service.BlogService;
import cn.coderzhx.service.CommentService;
import cn.coderzhx.utils.BlogIndex;
import cn.coderzhx.utils.IndexUtils;
import cn.coderzhx.utils.IpUtils;
import cn.coderzhx.utils.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhx
 * @create 2019-07-16-14
 */
@Controller
public class IndexController {
    @Resource
    BlogService blogService;
    @Resource
    BlogMapper blogMapper;
    @Resource
    private CommentService commentService;
        //主页
    @RequestMapping("/")
    public String index( PageBean pageBean,Model model,HttpServletRequest request) throws Exception {
        String ipAddress = IpUtils.getIpAddr(request);
        System.out.println(ipAddress);
        System.out.println(IpUtils.getRequestBrowserInfo(request));
         PageBean blogList= blogService.listBlogs(pageBean);
         model.addAttribute("pageBean",blogList);
         model.addAttribute("listTags",blogService.listTags(0));
       showMenu(model);
        return "index";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("keyword") String keyword,
                        Model model) throws Exception {
        List<Blog> listBlogs= new BlogIndex().searchBlog(keyword);
        List<Blog> listBlogs2=new ArrayList<>();
        for (Blog listBlog : listBlogs) {
            listBlog = blogService.findBlogById(listBlog.getId());
            listBlogs2.add(listBlog);
        }
        model.addAttribute("listBlogs2",listBlogs2);
       showMenu(model);
        return "searchindex";
    }

    //关于我
    @RequestMapping("/message")
    public String message(Model model){
        //列出15个评论
        PageBean pageBean2=new PageBean(0,commentService.countComment(),15);
        PageBean commentList=commentService.listComment(pageBean2);
        model.addAttribute("commentList",commentList);
        showMenu(model);
        return "message";
    }
    //关于我
    @RequestMapping("/aboutme")
    public String aboutme(Model model){

        showMenu(model);
        return "aboutme";
    }
    //时间轴
    @RequestMapping("/time")
    public String time(Model model){
        showMenu(model);
        return "time";
    }
    //标签
    @RequestMapping("/blog/tags/{tag}")
    public String blogtags(@PathVariable("tag") String tag, Model model){
        PageBean pageBean=new PageBean();
        pageBean.setTags(tag);
        List<Blog> blogs = blogMapper.listBlogsByTags(pageBean);
        model.addAttribute("blogs",blogs);
        System.out.println(blogs);
        showMenu(model);
        return "time";
    }
    //进入分类
    @RequestMapping("/blog/category/{id}")
    public String blogcategory(@PathVariable("id") int id, Model model){
        PageBean pageBean=new PageBean();
        pageBean.setCategory(id);
        List<Blog> blogs = blogMapper.listBlogsByCategory(pageBean);
        model.addAttribute("blogs",blogs);
        System.out.println(blogs);
        showMenu(model);
        return "time";
    }
    //刷新缓存
    @RequestMapping("/reflash")
    public String reflash(Model model){
        new IndexUtils().init();
        showMenu(model);
        return "index";
    }
    public static void showMenu(Model model){
         //调用菜单
        final List<Menu> menuList = IndexUtils.menuList;
        //调用配置
        final Config config=IndexUtils.configList;
        //友情链接
        final List<Link> listLink=IndexUtils.listLink;
        //关于我
         final Blog aboutmeMd=IndexUtils.aboutmeMd;

         model.addAttribute("aboutmeMd",aboutmeMd);
         model.addAttribute("listMenu",menuList);
         model.addAttribute("config",config);
         model.addAttribute("listLink",listLink);
    }


    //验证码
    @RequestMapping("/authImage")
    public String yanzm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        //生成图片
        int w = 130, h = 38;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
        return null;
    }
}
