package com.anthony.redis.template;

import java.io.Serializable;

/**
 * <p>Description: </p>
 *
 * @author Anthony
 * @date 2020-04-22 3:59 PM
 */
public class User implements Serializable {

    private static final long serialVersionUID = -8289770787953160443L;

    public User(Integer userId, String userName, String password, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
    }

    private Integer userId;
    private String userName;
    private String password;
    private String phone;


    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "com.anthony.redis.template.User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
