package top.luobogan.mapper;

import top.luobogan.pojo.Role;

import java.util.List;

public interface RoleMapper {

    /*
        根据用户id查询角色
     */
    public List<Role> findRoleById(Integer uid);


}
