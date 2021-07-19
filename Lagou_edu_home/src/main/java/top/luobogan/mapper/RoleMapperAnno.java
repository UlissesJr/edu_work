package top.luobogan.mapper;

import org.apache.ibatis.annotations.Select;
import top.luobogan.pojo.Role;
import java.util.List;

public interface RoleMapperAnno {

    @Select("SELECT * FROM sys_role r INNER JOIN sys_user_role ur ON r.id = ur.roleid WHERE ur.userid = #{uid}")
    public List<Role> finbdByUid(Integer uid);

}
