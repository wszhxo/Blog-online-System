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
        int size=commentMapper.countComment(pageBean);
        PageBean pageBean2=new PageBean(pageBean.getCurrentPage(),size,pageBean.getPageSize());
        pageBean.setIndex(pageBean2.getIndex());
        pageBean.setTotalCount(pageBean2.getTotalCount());
        pageBean.setTotalPage(pageBean2.getTotalPage());
        pageBean.setList(commentMapper.listComment(pageBean));
        return pageBean;
    }
    @Override
    public PageBean listComment2(PageBean pageBean) {
        int size=commentMapper.countComment(pageBean);
        PageBean pageBean2=new PageBean(pageBean.getCurrentPage(),size,pageBean.getPageSize());
        pageBean.setIndex(pageBean2.getIndex());
        pageBean.setTotalCount(pageBean2.getTotalCount());
        pageBean.setTotalPage(pageBean2.getTotalPage());
        pageBean.setCurrentPage(pageBean2.getCurrentPage());
        pageBean.setList(commentMapper.listComment2(pageBean));
        return pageBean;
    }


    @Override
    public void addLike(Integer id) {
        commentMapper.addLike(id);
    }

    @Override
    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    @Override
    public void editStatus(Comment comment) {
        commentMapper.editStatus(comment);
    }

    @Override
    public void delComment(Integer id) {
        commentMapper.delComment(id);

    }

    @Override
    public void batchdelComment(String id) {
        String[] arr=id.split(",");
        for (int i = 0; i < arr.length; i++) {
            commentMapper.delComment(Integer.parseInt(arr[i]));
        }
    }
}
