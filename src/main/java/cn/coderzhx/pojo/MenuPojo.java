package cn.coderzhx.pojo;

import org.springframework.stereotype.Component;

/**
 * @author zhx
 * @create 2019-08-12-15
 */
@Component
public class MenuPojo {
    private int pid;//父菜单
    private int cid;//子菜单
    private String pname;//父菜单
    private String cname;//子菜单
    private String purl;//父菜单路径
    private String curl;//字菜单路径
    private int pstatus;//父菜单路径
    private int cstatus;//字菜单路径
    private int porderno;//父菜单路径
    private int corderno;//字菜单路径

    public int getPorderno() {
        return porderno;
    }

    public void setPorderno(int porderno) {
        this.porderno = porderno;
    }

    public int getCorderno() {
        return corderno;
    }

    public void setCorderno(int corderno) {
        this.corderno = corderno;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }

    public int getPstatus() {
        return pstatus;
    }

    public void setPstatus(int pstatus) {
        this.pstatus = pstatus;
    }

    public int getCstatus() {
        return cstatus;
    }

    public void setCstatus(int cstatus) {
        this.cstatus = cstatus;
    }

    @Override
    public String toString() {
        return "MenuPojo{" +
                "pid=" + pid +
                ", cid=" + cid +
                ", pname='" + pname + '\'' +
                ", cname='" + cname + '\'' +
                ", purl='" + purl + '\'' +
                ", curl='" + curl + '\'' +
                ", pstatus=" + pstatus +
                ", cstatus=" + cstatus +
                ", porderno=" + porderno +
                ", corderno=" + corderno +
                '}';
    }
}
