package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/13 0013.
 */
public class UserDTO {

    private Integer userId;

    private String userName;

    private String sex;

    private String userTel;

    private Integer age;

    private List<RoleDTO> roleDTOList=new ArrayList<>();

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<RoleDTO> getRoleDTOList() {
        return roleDTOList;
    }

    public void setRoleDTOList(List<RoleDTO> roleDTOList) {
        this.roleDTOList = roleDTOList;
    }
}
