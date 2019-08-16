package cn.coderzhx.mapper;

import cn.coderzhx.entity.Share;
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
public interface ShareMapper {
    List<Share> listResource();
    void addShare(Share share);
    void delShare(@Param("id") Integer id);
    void editShare(Share share);
}
