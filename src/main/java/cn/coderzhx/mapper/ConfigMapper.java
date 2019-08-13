package cn.coderzhx.mapper;

import cn.coderzhx.entity.Config;
import cn.coderzhx.entity.Link;
import cn.coderzhx.entity.Menu;
import cn.coderzhx.pojo.MenuPojo;
import cn.coderzhx.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author zhx
 * @create 2019-07-27-21
 */
@Mapper
@Configuration
public interface ConfigMapper {

    //基本配置
    void editconfigsiteInfo(Config config);
    void editconfigseoInfo(Config config);
    void editconfigmeInfo(Config config);
    void editconfigpicInfo(Config config);
    //友情链接
    void addLink(Link link);
    void editStatus(Link link);
    void delLink(Integer id);
    int countLink(PageBean pageBean);
    List<Link> listLink(PageBean pageBean);
    void editLink(Link link);
    //前台菜单
    List<MenuPojo> listMenu();
    List<MenuPojo> listAdminMenu();
    void editMenu1(MenuPojo menuPojo);
    void editMenu2(MenuPojo menuPojo);

    void editStatus1(MenuPojo menuPojo);
    void editStatus2(MenuPojo menuPojo);

    void delMenu1(MenuPojo menuPojo);
    void delMenu2(MenuPojo menuPojo);

    void addMenu(Menu menu);

    //后台菜单
    void editAdminMenu1(MenuPojo menuPojo);
    void editAdminMenu2(MenuPojo menuPojo);

    void editAdminStatus1(MenuPojo menuPojo);
    void editAdminStatus2(MenuPojo menuPojo);

    void delAdminMenu1(MenuPojo menuPojo);
    void delAdminMenu2(MenuPojo menuPojo);

    void addAdminMenu(Menu menu);
}
