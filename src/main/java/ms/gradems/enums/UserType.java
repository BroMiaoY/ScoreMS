package ms.gradems.enums;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * 用户类型枚举
 */
public enum UserType {
    ADMIN("0", "管理员"),
    TEACHER("1", "教师"),
    STU("2", "学生"),
    ;
    private String code;
    private String desc;
    private static Map<String, UserType> codeMap = Maps.newHashMap();

    public static final List<String> SUPPER_ADMIN_USER_TYPE = Lists.newArrayList(ADMIN.getCode());

    public static final List<String> ALL_ADMIN_USER_TYPE = Lists.newArrayList(ADMIN.getCode());

    public static final List<String> CAN_UPLOAD_TYPE = Lists.newArrayList(TEACHER.getCode(),
            STU.getCode());

    static {
        for (UserType userType : UserType.values()) {
            codeMap.put(userType.getCode(), userType);
        }
    }

    UserType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserType toEnum(String code) {
        return codeMap.get(code);
    }
}
