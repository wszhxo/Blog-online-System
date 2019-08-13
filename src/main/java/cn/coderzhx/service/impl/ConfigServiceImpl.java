package cn.coderzhx.service.impl;

import cn.coderzhx.entity.Config;
import cn.coderzhx.entity.Link;
import cn.coderzhx.entity.Menu;
import cn.coderzhx.mapper.ConfigMapper;
import cn.coderzhx.pojo.MenuPojo;
import cn.coderzhx.pojo.PageBean;
import cn.coderzhx.service.ConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhx
 * @create 2019-08-11-18
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    @Resource
    ConfigMapper configMapper;
    @Override
    public void editconfig(Config config,String name) {
        if (name.equals("siteInfo")){
            configMapper.editconfigsiteInfo(config);
        }else if (name.equals("seoInfo")){
            configMapper.editconfigseoInfo(config);
        }else if (name.equals("meInfo")){
            configMapper.editconfigmeInfo(config);
        }else if (name.equals("picInfo")){
        configMapper.editconfigpicInfo(config);
        }
    }

    @Override
    public void addLink(Link link) {
        configMapper.addLink(link);
    }

    @Override
    public void editStatus(Link link) {
        configMapper.editStatus(link);
    }

    @Override
    public void delLink(Integer id) {
        configMapper.delLink(id);
    }

    @Override
    public void batchdelLink(String id) {
        String[] arr=id.split(",");
        for (int i = 0; i < arr.length; i++) {
            configMapper.delLink(Integer.parseInt(arr[i]));
        }
    }

    @Override
    public PageBean<Link> listLink(PageBean pageBean) {
        int size=configMapper.countLink(pageBean);
        PageBean pageBean2=new PageBean(pageBean.getCurrentPage(),size,pageBean.getPageSize());
        pageBean.setIndex(pageBean2.getIndex());
        pageBean.setTotalCount(pageBean2.getTotalCount());
        pageBean.setTotalPage(pageBean2.getTotalPage());
        pageBean.setList(configMapper.listLink(pageBean));
        return pageBean;
    }

    @Override
    public void editLink(Link link) {
        configMapper.editLink(link);
    }

    @Override
    public List<MenuPojo> listMenu() {
        List<MenuPojo> menuPojos = configMapper.listMenu();
        selectMenu(menuPojos);
        return menuPojos;
    }
    public void selectMenu(List<MenuPojo> menuPojos){
        for (int i = 0; i <menuPojos.size() ; i++) {
            for (int j = 0; j <menuPojos.size() ; j++) {
                if (menuPojos.get(i).getCid()==menuPojos.get(j).getPid()){
                    menuPojos.remove(j);
                }
            }
        }
}
    @Override
    public List<MenuPojo> listAdminMenu() {
        List<MenuPojo> menuPojos = configMapper.listAdminMenu();
        selectMenu(menuPojos);
        return menuPojos;
    }

    @Override
    public void editMenu1(MenuPojo menuPojo) {
        configMapper.editMenu1(menuPojo);
    }
    @Override
    public void editMenu2(MenuPojo menuPojo) {
        configMapper.editMenu2(menuPojo);
    }

    @Override
    public void editStatus1(MenuPojo menuPojo) {
        configMapper.editStatus1(menuPojo);

    }

    @Override
    public void editStatus2(MenuPojo menuPojo) {
        configMapper.editStatus2(menuPojo);
    }

    @Override
    public void delMenu1(MenuPojo menuPojo) {
        configMapper.delMenu1(menuPojo);
    }

    @Override
    public void delMenu2(MenuPojo menuPojo) {
        configMapper.delMenu2(menuPojo);
    }

    @Override
    public void addMenu(Menu menu) {
        configMapper.addMenu(menu);
    }



    @Override
    public void editAdminMenu1(MenuPojo menuPojo) {
        configMapper.editAdminMenu1(menuPojo);
    }
    @Override
    public void editAdminMenu2(MenuPojo menuPojo) {
        configMapper.editAdminMenu2(menuPojo);
    }

    @Override
    public void editAdminStatus1(MenuPojo menuPojo) {
        configMapper.editAdminStatus1(menuPojo);

    }

    @Override
    public void editAdminStatus2(MenuPojo menuPojo) {
        configMapper.editAdminStatus2(menuPojo);
    }

    @Override
    public void delAdminMenu1(MenuPojo menuPojo) {
        configMapper.delAdminMenu1(menuPojo);
    }

    @Override
    public void delAdminMenu2(MenuPojo menuPojo) {
        configMapper.delAdminMenu2(menuPojo);
    }

    @Override
    public void addAdminMenu(Menu menu) {
        configMapper.addAdminMenu(menu);
    }

}
