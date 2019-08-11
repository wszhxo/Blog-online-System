package cn.coderzhx.mapper;

import cn.coderzhx.entity.Config;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhx
 * @create 2019-07-27-21
 */
@Mapper
@Configuration
public interface ConfigMapper {
    void editconfigsiteInfo(Config config);
    void editconfigseoInfo(Config config);
    void editconfigmeInfo(Config config);
    void editconfigpicInfo(Config config);
}
