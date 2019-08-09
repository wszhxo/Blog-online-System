package cn.coderzhx.controller;

import cn.coderzhx.entity.Menu;
import cn.coderzhx.entity.User;
import cn.coderzhx.mapper.IndexMapper;
import cn.coderzhx.mapper.UserMapper;
import cn.coderzhx.utils.CryptographyUtil;
import cn.coderzhx.utils.IndexUtils;
import cn.coderzhx.utils.LayuiJSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zhx
 * @create 2019-07-27-20
 */
@Controller
public class AdminController {
@Resource
UserMapper userMapper;
@Resource
IndexMapper indexMapper;
    //后台主页
    @RequestMapping("/admin/admin")
    public String index2(Model model) throws Exception {
        List<Menu> adminMenu = IndexUtils.adminmenuList;
        model.addAttribute("adminMenu",adminMenu);
        return "admin/index2";
    }

    //登录ajax请求
    @RequestMapping("/login")
    public @ResponseBody String login(User user, HttpSession session){
        //验证码验证
        if (!user.getVerCode().equals(session.getAttribute("verCode")))
            return LayuiJSON.jsonStr(false,"验证码错误！");
        //获取 subject
        Subject subject= SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), CryptographyUtil.md5(user.getPassword(), "java"));
        try {
            subject.login(token);
            User user2 = userMapper.findByName(user.getUsername());
            //把当前用户信息存到session中
            SecurityUtils.getSubject().getSession().setAttribute("currentUser", user2);
            return LayuiJSON.jsonStr(true,"登陆成功！");
        } catch (UnknownAccountException e) {
            return LayuiJSON.jsonStr(false,"用户名不存在！");
        }catch (IncorrectCredentialsException e) {
            return LayuiJSON.jsonStr(false,"密码错误！");
        }
    }
    //退出登录
    @RequestMapping("/loginout")
    public String loginout() throws Exception {
        SecurityUtils.getSubject().logout(); //shiro的退出
        return "admin/login";
    }

}
