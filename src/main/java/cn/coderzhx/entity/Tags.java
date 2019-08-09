package cn.coderzhx.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author zhx
 * @create 2019-08-05-16
 */
@Component
public class Tags implements Serializable {
    private  int id;
    private  int blog_id;
    private  String tag_name;
    private  int num;
    private  String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

}
