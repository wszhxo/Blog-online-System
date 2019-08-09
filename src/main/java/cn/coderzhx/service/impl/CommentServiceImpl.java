package cn.coderzhx.service.impl;

import cn.coderzhx.entity.Comment;
import cn.coderzhx.mapper.CommentMapper;
import cn.coderzhx.pojo.PageBean;
import cn.coderzhx.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhx
 * @create 2019-07-24-23
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentMapper commentMapper;
    @Override
    public PageBean listComment(PageBean pageBean) {
//        int size=countComment();
        PageBean pageBean2=new PageBean(pageBean.getCurrentPage(),pageBean.getTotalCount(),pageBean.getPageSize());
        pageBean.setList(commentMapper.listComment(pageBean2));
        return pageBean;
    }

    @Override
    public int countComment() {
        return commentMapper.countComment();
    }

    @Override
    public void addLike(Integer id) {
        commentMapper.addLike(id);
    }

    @Override
    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }
}
