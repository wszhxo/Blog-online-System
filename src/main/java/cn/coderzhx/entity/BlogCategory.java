package cn.coderzhx.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author zhx
 * @create 2019-07-22-17
 */
@Component
public class BlogCategory implements Serializable {
    private int   id	;
    private String name	;
    private String create_time	;
    private String update_time	;
    private int order_no	;
    private String url	;
    private int count	;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BlogCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", order_no=" + order_no +
                ", url='" + url + '\'' +
                ", count=" + count +
                '}';
    }
}
