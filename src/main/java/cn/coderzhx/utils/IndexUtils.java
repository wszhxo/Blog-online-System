package cn.coderzhx.utils;

import cn.coderzhx.entity.Config;
import cn.coderzhx.entity.Link;
import cn.coderzhx.entity.Menu;
import cn.coderzhx.mapper.IndexMapper;
import cn.coderzhx.service.BlogService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhx
 * @create 2019-07-17-21
 */
@Configuration
public class IndexUtils {
    @Resource
    private IndexMapper indexMapper;
    @Resource
    private BlogService blogService;
    public  static List<Menu> menuList;
    public  static List<Menu> adminmenuList;
    public static Config configList;
    public static List<Link> listLink;
    @PostConstruct
    public void init() {
        refresh();
    }
    public  void refresh(){
        menuList = indexMapper.listMenu();
        adminmenuList =indexMapper.listAdminMenu();
        configList=indexMapper.listConfig();
        //友情链接
        listLink=indexMapper.listLink();
    }


}
