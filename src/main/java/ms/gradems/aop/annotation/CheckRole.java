package ms.gradems.aop.annotation;

import ms.gradems.enums.RoleEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface  CheckRole {
    /**
     * 校验的角色
     */
    RoleEnum[] value() default {RoleEnum.admin,RoleEnum.teacher,RoleEnum.stu};


}
