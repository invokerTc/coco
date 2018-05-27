package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/13 0013.
 */
public class RoleDTO {

    private Integer roleId;

    private String roleName;

    private List<PermissionDTO> permissionDTOList=new ArrayList<>();

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<PermissionDTO> getPermissionDTOList() {
        return permissionDTOList;
    }

    public void setPermissionDTOList(List<PermissionDTO> permissionDTOList) {
        this.permissionDTOList = permissionDTOList;
    }
}
