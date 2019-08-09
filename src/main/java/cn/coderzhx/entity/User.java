package cn.coderzhx.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author zhx
 * @create 2019-07-27-19
 */
@Component
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String verCode;//验证码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerCode() {
        return verCode;
    }

    public void setVerCode(String verCode) {
        this.verCode = verCode;
    }
}
