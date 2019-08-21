package cn.coderzhx.controller;

import cn.coderzhx.entity.*;
import cn.coderzhx.mapper.BlogMapper;
import cn.coderzhx.mapper.IndexMapper;
import cn.coderzhx.mapper.ShareMapper;
import cn.coderzhx.pojo.PageBean;
import cn.coderzhx.pojo.Visit;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    IndexMapper indexMapper;
    @Resource
    ShareMapper shareMapper;
    @Resource
    private CommentService commentService;
    @Resource
    private IndexUtils indexUtils;
        //主页
    @RequestMapping("/")
    public String index( PageBean pageBean,Model model,HttpServletRequest request) throws Exception {
        String ipAddress = IpUtils.getIpAddr(request);
        //访问网站如果是同一个ip，如果数据库有,就让该ip访问次数+1，
        Map<String,VisitCount> map1=IndexUtils.map;
        if(map1.containsKey(ipAddress)){
            indexMapper.addipCount(ipAddress);
        }else{
           //此ip没有就创建新的Map，看情况统一添加
            VisitCount visitCount=new VisitCount();
            visitCount.setIp(ipAddress);
            visitCount.setReqcount(1);
            visitCount.setBrowser(IpUtils.getRequestBrowserInfo(request));
            IndexUtils.newvisitCount.add(visitCount);
            //由于此时我还没有刷新缓存，已经访问过的ip还没加入数据库有可能总是第一次
//            listVisit.add(visitCount);
            map1.put(ipAddress,visitCount);
        }
        Visit totalcount = IndexUtils.totalcount;
        PageBean blogList= blogService.listBlogs(pageBean);
         model.addAttribute("totalcount",totalcount);
         model.addAttribute("pageBean",blogList);
         model.addAttribute("listTags",blogService.listTags(0));
       showMenu(model);
        return "index";
    }
    //lunece搜索
    @RequestMapping("/search")
    public String search(@RequestParam("keyword") String keyword,
                        Model model) throws Exception {
        List<Blog> listBlogs= new BlogIndex().searchBlog(keyword);
        List<Blog> listBlogs2=new ArrayList<>();
        for (Blog listBlog : listBlogs) {
            Blog blog=new Blog();
            blog = blogService.findBlogById(listBlog.getId());
            blog.setTitle(listBlog.getTitle());
            blog.setSummary(listBlog.getSummary());
            listBlogs2.add(blog);
        }
        model.addAttribute("listBlogs2",listBlogs2);
       showMenu(model);
        return "searchindex";
    }

    //留言
    @RequestMapping("/message")
    public String message(Model model,PageBean pageBean2){
        PageBean commentList=commentService.listComment2(pageBean2);
        model.addAttribute("commentList",commentList);
        showMenu(model);
        return "message";
    }
    //资源分享
    @RequestMapping("/share")
    public String share(Model model){
        List<Share> list=shareMapper.listResource();
        model.addAttribute("listShare",list);
        showMenu(model);

        return "share";
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
        List<Blog> blogs = blogMapper.listTime();
        model.addAttribute("blogs",blogs);
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
        showMenu(model);
        return "time";
    }
    //刷新缓存
    @RequestMapping("/reflash")
    public @ResponseBody  String reflash(){
        indexUtils.refresh();
        return "success";
    }
    public static void showMenu(Model model){
         //调用菜单
        final List<Menu> menuList = IndexUtils.menuList;
        //调用配置
        final Config config=IndexUtils.configList;
        //友情链接
        final List<Link> listLink=IndexUtils.listLink;
        //点击排行5篇
        final List<Blog> listHitsBlog=IndexUtils.listHitsBlog;

         model.addAttribute("listHitsBlog",listHitsBlog);
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
