package cn.coderzhx.controller;

import cn.coderzhx.entity.Config;
import cn.coderzhx.entity.Link;
import cn.coderzhx.entity.Menu;
import cn.coderzhx.pojo.MenuPojo;
import cn.coderzhx.pojo.PageBean;
import cn.coderzhx.service.ConfigService;
import cn.coderzhx.utils.IndexUtils;
import cn.coderzhx.utils.LayuiJSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhx
 * @create 2019-07-27-20
 */
@Controller
@RequestMapping("/config")
public class ConfigController {
@Resource
ConfigService configService;
    //网站配置
    @RequestMapping("/")
    public String config(Model model) throws Exception {
        Config configList = IndexUtils.configList;
        model.addAttribute("configList",configList);
        return "admin/config/base";
    }
    //前台菜单
    @RequestMapping("/listMenu")
    public  @ResponseBody  String menu() {
        List<MenuPojo> menuList = configService.listMenu();
        return LayuiJSON.jsonStr("",0,menuList);
    }
    //后台菜单
    @RequestMapping("/listAdminMenu")
    public  @ResponseBody  String adminMenu(Model model)  {
        List<MenuPojo> menuList = configService.listAdminMenu();
        return LayuiJSON.jsonStr("",0,menuList);
    }
    //网站配置
    @PostMapping("/edit/{method}")
    public @ResponseBody String editconfig(@PathVariable("method") String method,Config config) {
        configService.editconfig(config,method);
        return "success";
    }


    //友情链接
    //添加友链
    @PostMapping("/addLink")
    public  @ResponseBody String addLink(Link link){
        configService.addLink(link);
        return "success";
    }
    //友链状态修改
    @PostMapping("/editIsuse")
    public  @ResponseBody String editStatus(Link link){
        configService.editStatus(link);
        return "success";
    }
    //友链状态修改
    @GetMapping("/toeditLink")
    public  String toeditLink(Link link,Model model){
        model.addAttribute("editLink",link);
        return "admin/config/addLink";
    }
    //友链状态修改
    @PostMapping("/editLink")
    public  @ResponseBody String editLink(Link link){
        configService.editLink(link);
        return "success";
    }
    //删除评论
    @PostMapping("/delLink/{id}")
    public @ResponseBody  String delLink(@PathVariable("id") Integer id){
        configService.delLink(id);
        return "success";
    }

    //批量删除评论
    @PostMapping("/batchdelLink/{id}")
    public @ResponseBody  String batchdelLink(@PathVariable("id") String id){
        configService.batchdelLink(id);
        return "success";
    }
    //后台列出友链
    @RequestMapping("/listLink")
    public @ResponseBody String  listLink(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "limit", defaultValue = "7") Integer limit,
                            PageBean pageBean){
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(limit);
        PageBean<Link> list = configService.listLink(pageBean);
        return LayuiJSON.jsonStr("",list.getTotalCount(),list.getList());
    }

    //前台菜单

    //编辑菜单
    @PostMapping("/editMenu1")
    public @ResponseBody  String editMenu1(MenuPojo menuPojo){
        configService.editMenu1(menuPojo);
        return "success";
    }
    //编辑菜单
    @PostMapping("/editMenu2")
    public @ResponseBody  String editMenu2(MenuPojo menuPojo){
        configService.editMenu2(menuPojo);
        return "success";
    }
    //修改父标签使用状态
    @PostMapping("/editStatus1")
    public @ResponseBody  String editStatus1(MenuPojo menuPojo){
        configService.editStatus1(menuPojo);
        return "success";
    }
    //修改子标签使用状态
    @PostMapping("/editStatus2")
    public @ResponseBody  String editStatus2(MenuPojo menuPojo){
        configService.editStatus2(menuPojo);
        return "success";
    }
    //删除根菜单
    @PostMapping("/delMenu1")
    public @ResponseBody  String delMenu1(MenuPojo menuPojo){
        configService.delMenu1(menuPojo);
        return "success";

    }
    //删除子菜单
    @PostMapping("/delMenu2")
    public @ResponseBody  String delMenu2(MenuPojo menuPojo){
        configService.delMenu2(menuPojo);
        return "success";
    }
    //菜单
    @PostMapping("/addMenu")
    public @ResponseBody  String addMenu(Menu menu){
        configService.addMenu(menu);
        return "success";
    }


    //后台菜单

    //编辑菜单
    @PostMapping("/editAdminMenu1")
    public @ResponseBody  String editAdminMenu1(MenuPojo menuPojo){
        configService.editAdminMenu1(menuPojo);
        return "success";
    }
    //编辑菜单
    @PostMapping("/editAdminMenu2")
    public @ResponseBody  String editAdminMenu2(MenuPojo menuPojo){
        configService.editAdminMenu2(menuPojo);
        return "success";
    }
    //修改父标签使用状态
    @PostMapping("/editAdminStatus1")
    public @ResponseBody  String editAdminStatus1(MenuPojo menuPojo){
        configService.editAdminStatus1(menuPojo);
        return "success";
    }
    //修改子标签使用状态
    @PostMapping("/editAdminStatus2")
    public @ResponseBody  String editAdminStatus2(MenuPojo menuPojo){
        configService.editAdminStatus2(menuPojo);
        return "success";
    }
    //删除根菜单
    @PostMapping("/delAdminMenu1")
    public @ResponseBody  String delAdminMenu1(MenuPojo menuPojo){
        configService.delAdminMenu1(menuPojo);
        return "success";

    }
    //删除子菜单
    @PostMapping("/delAdminMenu2")
    public @ResponseBody  String delAdminMenu2(MenuPojo menuPojo){
        configService.delAdminMenu2(menuPojo);
        return "success";
    }
    //菜单
    @PostMapping("/addAdminMenu")
    public @ResponseBody  String addAdminMenu(Menu menu){
        configService.addAdminMenu(menu);
        return "success";
    }


}
