package cn.coderzhx.service;

import cn.coderzhx.entity.Comment;
import cn.coderzhx.pojo.PageBean;

/**
 * @author zhx
 * @create 2019-07-24-23
 */
public interface CommentService {
    PageBean listComment(PageBean pageBean2);
    int countComment();
    void addLike(Integer id);

    void addComment(Comment comment);
}
