package com.example.demo.service;

import com.example.demo.dto.PermissionDTO;
import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserRolePermissionVO;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/5/13 0013.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> getAllInfo() {
        List<UserRolePermissionVO> userRolePermissionVOs = userMapper.getAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        HashMap<Integer, UserDTO> userDTOHashMap = new HashMap<>();
        HashMap<String, RoleDTO> roleDTOHashMap = new HashMap<>();
        HashMap<String, PermissionDTO> permissionDTOHashMap = new HashMap<>();
        for (UserRolePermissionVO urpVO : userRolePermissionVOs) {
            Integer userId = urpVO.getUserId();
            Integer roleId = urpVO.getRoleId();
            Integer permissionId = urpVO.getPermissionId();
            String urId = userId + "-" + roleId;
            String urpId = urId + "-" + permissionId;
            //抽取vo结果，集成用户属性
            UserDTO userDTO = userDTOHashMap.get(userId);
            if (userDTO == null) {
                userDTO = new UserDTO();
                userDTO.setUserId(userId);
                String userName = urpVO.getUserName();
                String userTel = urpVO.getUserTel();
                userDTO.setUserName(userName);
                userDTO.setUserTel(userTel);
                userDTOHashMap.put(userId, userDTO);
                userDTOList.add(userDTO);
            }
            //抽取vo结果，集成角色属性
            RoleDTO roleDTO = roleDTOHashMap.get(urId);
            if (roleDTO == null) {
                roleDTO = new RoleDTO();
                String roleName = urpVO.getRoleName();
                roleDTO.setRoleId(roleId);
                roleDTO.setRoleName(roleName);
                roleDTOHashMap.put(urId, roleDTO);
                //将角色装入用户
                List<RoleDTO> roleDTOList = userDTO.getRoleDTOList();
                roleDTOList.add(roleDTO);
            }
            PermissionDTO permissionDTO = permissionDTOHashMap.get(urpId);
            if (permissionDTO == null) {
                permissionDTO = new PermissionDTO();
                String permissinoName = urpVO.getPermissionName();
                permissionDTO.setPermissionId(permissionId);
                permissionDTO.setPermissionName(permissinoName);
                permissionDTOHashMap.put(urpId, permissionDTO);
                //将权限装入角色
                List<PermissionDTO> permissionDTOList = roleDTO.getPermissionDTOList();
                permissionDTOList.add(permissionDTO);
            }
        }
        return userDTOList;
    }

    public List<UserDTO> getAllUser() {
        List<UserDTO> userDTOList = userMapper.getAllUser();
        return userDTOList;
    }
}
