package cn.coderzhx.controller;

import cn.coderzhx.entity.Config;
import cn.coderzhx.entity.Menu;
import cn.coderzhx.mapper.IndexMapper;
import cn.coderzhx.mapper.UserMapper;
import cn.coderzhx.service.ConfigService;
import cn.coderzhx.utils.IndexUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhx
 * @create 2019-07-27-20
 */
@Controller
public class ConfigController {
@Resource
UserMapper userMapper;
@Resource
IndexMapper indexMapper;
@Resource
ConfigService configService;
    //网站配置
    @RequestMapping("/config")
    public String config(Model model) throws Exception {
        Config configList = IndexUtils.configList;
        model.addAttribute("configList",configList);
        return "admin/config/base";
    }
    //前台菜单
    @RequestMapping("/listMenu")
    public   String menu(Model model) throws Exception {
        List<Menu> menuList = IndexUtils.menuList;
        model.addAttribute("menuList",menuList);
        return "  ";
    }
    //后台菜单
    @RequestMapping("/listAdminMenu")
    public   String adminMenu(Model model) throws Exception {
        List<Menu> menuList = IndexUtils.adminmenuList;
        model.addAttribute("menuList",menuList);
        return "admin/config/menu_admin";}
    //后台菜单
    @PostMapping("/config/edit/{method}")
    public @ResponseBody String editconfig(@PathVariable("method") String method,Config config) {
        System.out.println(method+config);
        configService.editconfig(config,method);
        return "success";
    }



}
