package cn.coderzhx.entity;

import org.springframework.stereotype.Component;

/**
 * @author zhx
 * @create 2019-08-15-20
 */
@Component
public class Share {
    private int id;
    private String img	;
    private String title	;
    private String resource	;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "Share{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", resource='" + resource + '\'' +
                '}';
    }
}
