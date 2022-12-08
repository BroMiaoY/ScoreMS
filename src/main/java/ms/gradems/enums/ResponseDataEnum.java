package ms.gradems.enums;

import lombok.Getter;


@Getter
public enum ResponseDataEnum {
    SUCCESS(200,"SUCCESS"),
    PARAM_WRONG(1001,"错误的参数！"),
    WRONG_USER(1009,"用户名或密码错误"),

    NULL_TOKEN(1003,"token 不存在"),
    NO_ACCESS(1004,"无权访问！"),
    SYSTEM_ERROR(1005,"system error"),
    CODE_TIME_OUT(1006,"验证码已过期"),
    WRONG_CODE(1007,"验证码错误"),
    WRONG_PASSWORD(1008,"密码错误"),
    WRONG_RESERVE(1009,"当前时间不可预定"),
    WRONG_AUDIT(1010,"当前时间已被申请");
    private Integer code;
    private String msg;

    ResponseDataEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }


}
