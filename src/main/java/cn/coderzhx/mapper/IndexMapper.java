package cn.coderzhx.mapper;

import cn.coderzhx.entity.*;
import cn.coderzhx.pojo.Visit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author zhx
 * @create 2019-07-16-14
 */
@Mapper
@Configuration
public interface IndexMapper {
    List<Menu> listMenu();
    List<Menu> listAdminMenu();
    Config listConfig();
    List<Link> listLink();
    List<VisitCount> listVisit();
    //访问人数
    Visit listTotal();

    void addipCount(@Param("ipAddress") String ipAddress);
    void addNewVisit(VisitCount visitCount);

}
