package cn.coderzhx.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author zhx
 * @create 2019-07-20-20
 */
@Component
public class Blog implements Serializable {
    private int id;
    private String summary;
    private String content;
    private String html_content;
    private String img_url;
    private String title;
    private String create_time;
    private String update_time;
    private int state;
    private int hits;
    private int category_id;
    private int likeit;
    private BlogCategory blogCategory;
    //用于业务
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLikeit() {
        return likeit;
    }

    public void setLikeit(int likeit) {
        this.likeit = likeit;
    }

    public BlogCategory getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(BlogCategory blogCategory) {
        this.blogCategory = blogCategory;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtml_content() {
        return html_content;
    }

    public void setHtml_content(String html_content) {
        this.html_content = html_content;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", html_content='" + html_content + '\'' +
                ", img_url='" + img_url + '\'' +
                ", title='" + title + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", state=" + state +
                ", hits=" + hits +
                ", category_id=" + category_id +
                ", likeit=" + likeit +
                ", blogCategory=" + blogCategory +
                ", name='" + name + '\'' +
                '}';
    }
}
