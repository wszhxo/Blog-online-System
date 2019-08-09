package cn.coderzhx.mapper;

import cn.coderzhx.entity.Config;
import cn.coderzhx.entity.Link;
import cn.coderzhx.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
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
}
