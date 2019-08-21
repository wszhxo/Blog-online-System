package cn.coderzhx.controller;

import cn.coderzhx.entity.Comment;
import cn.coderzhx.pojo.PageBean;
import cn.coderzhx.service.CommentService;
import cn.coderzhx.utils.LayuiJSON;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhx
 * @create 2019-07-25-14
 */
@RequestMapping("/comment")
@RestController
public class CommentController {
    @Resource
    CommentService commentservice;
    //评论点赞
    @PostMapping("/{id}")
    public String addLike(@PathVariable("id") Integer id){
        commentservice.addLike(id);
        return "success";
    }
    //添加评论
    @PostMapping("/add")
    public String addComment(Comment comment){
        commentservice.addComment(comment);
        return "success";
    }
    //评论状态修改
    @PostMapping("/editStatus")
    public String editStatus(Comment comment){
        commentservice.editStatus(comment);
        return "success";
    }
    //删除评论
    @PostMapping("/delComment/{id}")
    public String delComment(@PathVariable("id") Integer id){
        commentservice.delComment(id);
        return "success";
    }
    //批量删除评论
    @PostMapping("/batchdelComment/{id}")
    public String batchdelComment(@PathVariable("id") String id){
        commentservice.batchdelComment(id);
        return "success";
    }
    //后台列出文章
    @RequestMapping("/listComment")
    public String  listBlog(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "limit", defaultValue = "7") Integer limit,
                            PageBean pageBean){
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(limit);
        PageBean<Comment> list = commentservice.listComment(pageBean);
        return LayuiJSON.jsonStr("",list.getTotalCount(),list.getList());
    }
}
