package cn.coderzhx.controller;

import cn.coderzhx.entity.Comment;
import cn.coderzhx.service.CommentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println(comment.toString());
        commentservice.addComment(comment);
        return "success";
    }

}
