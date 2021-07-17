package top.luobogan.pojo;

/**
 * Created by LuoboGan
 * Date:2021/7/11
 */
public class Role {

    private Integer id;
    private String rolename;
    private String roleDesc;

    public Role() {
    }

    public Role(Integer id, String rolename, String roleDesc) {
        this.id = id;
        this.rolename = rolename;
        this.roleDesc = roleDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
