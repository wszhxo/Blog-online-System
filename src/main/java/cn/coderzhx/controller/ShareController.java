package cn.coderzhx.controller;

import cn.coderzhx.entity.Share;
import cn.coderzhx.mapper.ShareMapper;
import cn.coderzhx.utils.LayuiJSON;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhx
 * @create 2019-07-27-20
 */
@RestController
public class ShareController {
@Resource
ShareMapper shareMapper;
    //列出
    @RequestMapping("/listResource")
    public String listResource(){
        List<Share> shares = shareMapper.listResource();
        return LayuiJSON.jsonStr("",0,shares);
    }

    //修改
    @PostMapping("/editShare")
    public String  editShare(Share share)  {
        shareMapper.editShare(share);
        return "success";
    }
    //添加
    @PostMapping("/addShare")
    public String  addShare(Share share){
        shareMapper.addShare(share);
        return "success";
    }
    //添加
    @PostMapping("/delShare/{id}")
    public String  delShare(@PathVariable("id") Integer id){
        shareMapper.delShare(id);
        return "success";
    }

}
