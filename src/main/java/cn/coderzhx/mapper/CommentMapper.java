package cn.coderzhx.mapper;

import cn.coderzhx.entity.Comment;
import cn.coderzhx.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author zhx
 * @create 2019-07-24-20
 */
@Mapper
@Configuration
public interface CommentMapper {
    List<Comment> listComment(PageBean pageBean);
    List<Comment> listComment2(PageBean pageBean);
    int countComment(PageBean pageBean);
    void addLike(Integer id);
    void addComment(Comment comment);
    void editStatus(Comment comment);
    void delComment(Integer id);
}
