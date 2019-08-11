package cn.coderzhx.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author zhx
 * @create 2019-07-19-14
 */
@Component
public class Config implements Serializable {
    private int id;
    private String name;
    private String icon;
    private String username;
    private String description;
    private String html_desc;
    private String qq;
    private String wechat;
    private String wechatgzh;
    private String beian;
    private String wechat_icon;
    private String weixinpay;
    private String Alipay;
    private String keyword;
    private String summary;
    private String title;
    private String create_time;
    private String job;
    private String github;
    private String banquan;
    private String tongji;

    public String getBanquan() {
        return banquan;
    }

    public void setBanquan(String banquan) {
        this.banquan = banquan;
    }

    public String getTongji() {
        return tongji;
    }

    public void setTongji(String tongji) {
        this.tongji = tongji;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHtml_desc() {
        return html_desc;
    }

    public void setHtml_desc(String html_desc) {
        this.html_desc = html_desc;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getWechatgzh() {
        return wechatgzh;
    }

    public void setWechatgzh(String wechatgzh) {
        this.wechatgzh = wechatgzh;
    }

    public String getBeian() {
        return beian;
    }

    public void setBeian(String beian) {
        this.beian = beian;
    }

    public String getWechat_icon() {
        return wechat_icon;
    }

    public void setWechat_icon(String wechat_icon) {
        this.wechat_icon = wechat_icon;
    }

    public String getWeixinpay() {
        return weixinpay;
    }

    public void setWeixinpay(String weixinpay) {
        this.weixinpay = weixinpay;
    }

    public String getAlipay() {
        return Alipay;
    }

    public void setAlipay(String alipay) {
        Alipay = alipay;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", html_desc='" + html_desc + '\'' +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", wechatgzh='" + wechatgzh + '\'' +
                ", beian='" + beian + '\'' +
                ", wechat_icon='" + wechat_icon + '\'' +
                ", weixinpay='" + weixinpay + '\'' +
                ", Alipay='" + Alipay + '\'' +
                ", keyword='" + keyword + '\'' +
                ", summary='" + summary + '\'' +
                ", title='" + title + '\'' +
                ", create_time='" + create_time + '\'' +
                ", job='" + job + '\'' +
                ", github='" + github + '\'' +
                ", banquan='" + banquan + '\'' +
                ", tongji='" + tongji + '\'' +
                '}';
    }
}
