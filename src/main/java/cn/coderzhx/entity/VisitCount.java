package cn.coderzhx.entity;

import org.springframework.stereotype.Component;

/**
 * @author zhx
 * @create 2019-08-15-15
 */
@Component
public class VisitCount {
    private int id	;
    private String ip	;
    private String reqUrl	;
    private String reqtime	;
    private int reqcount	;
    private String browser;

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }

    public String getReqtime() {
        return reqtime;
    }

    public void setReqtime(String reqtime) {
        this.reqtime = reqtime;
    }

    public int getReqcount() {
        return reqcount;
    }

    public void setReqcount(int reqcount) {
        this.reqcount = reqcount;
    }
}
