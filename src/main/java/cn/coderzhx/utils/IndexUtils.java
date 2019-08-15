package cn.coderzhx.utils;

import cn.coderzhx.entity.*;
import cn.coderzhx.mapper.BlogMapper;
import cn.coderzhx.mapper.IndexMapper;
import cn.coderzhx.pojo.Visit;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.LinkedList;
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
    private BlogMapper blogMapper;
    public  static List<Menu> menuList;
    public  static List<Menu> adminmenuList;
    public static Config configList;
    public static List<Link> listLink;
    public static List<Blog> listHitsBlog;
    //服务器开启时数据库中网站的的访问统计
    public static  List<VisitCount> visitCountMap;
    //新增的ip以及访问次数
    public static List<VisitCount> newvisitCount=new LinkedList<>();
    //网站的访问人数以及总次数
    public static Visit totalcount;


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
        listHitsBlog=blogMapper.listHitsBlog();
        visitCountMap=indexMapper.listVisit();
        totalcount=indexMapper.listTotal();
        if (newvisitCount.size()>0) {
            for (int i = 0; i < newvisitCount.size(); i++) {
                indexMapper.addNewVisit(newvisitCount.get(i));
            }
        }
    }



}
