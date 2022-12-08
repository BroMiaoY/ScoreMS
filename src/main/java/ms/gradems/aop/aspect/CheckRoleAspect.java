package ms.gradems.aop.aspect;

import ms.gradems.aop.annotation.CheckRole;
import ms.gradems.config.TokenConfig;
import ms.gradems.enums.ResponseDataEnum;
import ms.gradems.enums.RoleEnum;
import ms.gradems.service.ex.AccessException;
import ms.gradems.token.TokenMsg;
import ms.gradems.util.TokenUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class CheckRoleAspect {

    private static final Logger log = LoggerFactory.getLogger(CheckRoleAspect.class);

    private TokenConfig tokenConfig;

    public CheckRoleAspect(TokenConfig tokenConfig){
        this.tokenConfig = tokenConfig;
        log.info("Auto Check Role Start");
    }

    @Before("@annotation(checkRole)")
    public void checkRole(CheckRole checkRole) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        TokenMsg tokenMsg = TokenUtil.getTokenMsg(request, tokenConfig.getTokenSecretKey());
        RoleEnum[] roleEnums = checkRole.value();
        RoleEnum userRole = RoleEnum.valueOf(tokenMsg.getRole());
        log.info("UserRole:{}",userRole.toString());

        for (RoleEnum roleEnum: roleEnums){
            if (userRole == roleEnum){
                return ;
            }
        }
        throw new AccessException(ResponseDataEnum.NO_ACCESS);
    }

}
