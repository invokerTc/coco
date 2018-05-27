package com.example.demo.mapper;

import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserRolePermissionVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
public interface UserMapper {
    @Select("SELECT user_id,user_name as name,user_password as password FROM tb_user")
    List<User> getAll1();
    @Select("select user_id,user_name as name,user_password as password from tb_user where user_name=#{username}")
    User getByName(@Param("username") String name);
    @Select("select u.id as userId,u.user_name,u.user_tel,r.id as roleId,r.role_name,p.id as permissionId,p.perssion_name as permissionName from tb_user u join tb_role r join tb_user_role_relation urr join tb_permission p join tb_role_permission rp"
            + " on u.id=urr.user_id and urr.role_id=r.id and r.id=rp.role_id and rp.permission_id=p.id")
    public List<UserRolePermissionVO> getAll();

    @Select("select id as userId,user_name,sex,age from tb_user")
    public List<UserDTO> getAllUser();

    @Select("select id as roleId,role_name from tb_role")
    public List<RoleDTO> getAllRole();
}
