package cn.coderzhx.mapper;

import cn.coderzhx.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhx
 * @create 2019-07-27-21
 */
@Mapper
@Configuration
public interface UserMapper {
    User findByName(String name);
}
