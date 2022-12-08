package ms.gradems.enums;

import ms.gradems.service.ex.ParamException;

public enum RoleEnum {

    admin(0,"admin"),
    teacher(1,"teacher"),
    stu(2,"stu");

    private Integer roleId;
    private String roleName;

    RoleEnum(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public static RoleEnum valueOf(int code) {
        switch(code) {
            case 0:
                return admin;
            case 1:
                return teacher;
            case 2:
                return stu;
            default:
                throw new ParamException("argument out of range");
        }
    }

}
