package com.example.demo.controller;

import com.example.demo.dto.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
@RestController
@RequestMapping(value = "user")
@Api(value = "UserController")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取所有用户信息", notes = "想知道就告诉你")
    @ApiResponse(code = 200, message = "成功")
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<User> getAll() {
        return userMapper.getAll1();
    }
    @ApiOperation(value = "根据用户名获取用户信息",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",required = true,dataType = "String",paramType = "query")
    })
    @ApiResponse(code=200,message = "成功")
    @RequestMapping(value = "byName", method = RequestMethod.GET)
    public User getByName(String username) {
        User user = userMapper.getByName(username);
        return user;
    }
    @ApiOperation(value = "获取所有用户的信息（含角色及权限）",notes = "")
//    @ApiResponse(code = 200,message = "成功",response = UserDTO.class)
    @RequestMapping(value = "allInfo",method = RequestMethod.GET)
    public List<UserDTO> getAllUserDetail(){
        List<UserDTO> allInfo = userService.getAllInfo();
        return allInfo;
    }

    @ApiOperation(value = "获取用户基本信息（不含角色、权限）",notes = "")
//    @ApiResponse(code = 200,message = "成功",response = UserDTO.class)
    @RequestMapping(value = "userBase",method = RequestMethod.GET)
    public List<UserDTO> getUser(){
        List<UserDTO> allUser = userService.getAllUser();
        return allUser;
    }
}
