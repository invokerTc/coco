package com.example.demo;

import com.example.demo.dto.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CocoApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        List<User> users = userMapper.getAll1();
        System.out.println(users);
        for (User user:users) {
            System.out.println(user.getName()+"==="+user.getPassword());
        }
    }
    @Test
    public void testCase(){
        User user = userMapper.getByName("lili");
        System.out.println(user);
    }
    @Test
    public void testCase1(){
        List<UserDTO> allInfo = userService.getAllInfo();
        for (UserDTO user:allInfo){
            System.out.println(user.getUserId()+"==="+user.getUserName()+"==="+user.getUserTel());
        }
    }
}
