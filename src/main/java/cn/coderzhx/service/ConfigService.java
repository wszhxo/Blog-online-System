package cn.coderzhx.service;

import cn.coderzhx.entity.Config;
import cn.coderzhx.entity.Link;
import cn.coderzhx.entity.Menu;
import cn.coderzhx.pojo.MenuPojo;
import cn.coderzhx.pojo.PageBean;

import java.util.List;

/**
 * @author zhx
 * @create 2019-08-11-18
 */
public interface ConfigService {
    void editconfig(Config config,String name);

    void addLink(Link link);

    void editStatus(Link link);

    void delLink(Integer id);

    void batchdelLink(String id);

    PageBean<Link> listLink(PageBean pageBean);
    void editLink(Link link);
    List<MenuPojo> listMenu();
    List<MenuPojo> listAdminMenu();

    void editMenu1(MenuPojo menuPojo);
    void editMenu2(MenuPojo menuPojo);
    void editStatus1(MenuPojo menuPojo);
    void editStatus2(MenuPojo menuPojo);
    void delMenu1(MenuPojo menuPojo);
    void delMenu2(MenuPojo menuPojo);
    void addMenu(Menu menu);

    void addAdminMenu(Menu menu);
    void delAdminMenu2(MenuPojo menuPojo);
    void delAdminMenu1(MenuPojo menuPojo);
    void editAdminStatus2(MenuPojo menuPojo);
    void editAdminStatus1(MenuPojo menuPojo);
    void editAdminMenu2(MenuPojo menuPojo);
    void editAdminMenu1(MenuPojo menuPojo);
}
