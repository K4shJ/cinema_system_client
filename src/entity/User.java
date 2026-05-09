package entity;

import java.io.Serializable;

/**
 * 用户
 */
public class User implements Serializable {
    private String username;

    private String password;

    private String securityCode;

    private boolean manager;
    //状态1-正常，0-冻结
    private int state = 1;

    public User(String username, String pwd, String securityCode) {
        this.username = username;
        this.password = pwd;
        this.securityCode = securityCode;
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

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        String identity = (manager ? "管理员" : "普通用户");
        String s = state == 1 ? "正常" : "被冻结";
        return username + "\t" + identity + "\t" + s;
    }
}
