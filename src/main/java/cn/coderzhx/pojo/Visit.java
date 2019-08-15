package cn.coderzhx.pojo;

import org.springframework.stereotype.Component;

/**
 * @author zhx
 * @create 2019-08-15-16
 */
@Component
public class Visit {
    private int countip;
    private int totalcount;

    public int getCountip() {
        return countip;
    }

    public void setCountip(int countip) {
        this.countip = countip;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }
}
