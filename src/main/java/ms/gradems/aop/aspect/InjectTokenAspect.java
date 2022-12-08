package ms.gradems.aop.aspect;

import ms.gradems.aop.annotation.InjectToken;
import ms.gradems.config.TokenConfig;
import ms.gradems.token.TokenMsg;
import ms.gradems.util.TokenUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class InjectTokenAspect {

    private static final Logger log = LoggerFactory.getLogger(InjectTokenAspect.class);

    private TokenConfig tokenConfig;

    public InjectTokenAspect(TokenConfig tokenConfig){
        this.tokenConfig = tokenConfig;
        log.info("Auto Inject token");
    }

    @Around("@annotation(injectToken)")
    public Object injectToken(ProceedingJoinPoint joinPoint, InjectToken injectToken) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Class[] classes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        for (int i=0; i<classes.length; i++){
            if (classes[i].equals(TokenMsg.class)){
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                TokenMsg tokenMsg = TokenUtil.getTokenMsg(request, tokenConfig.getTokenSecretKey());
                args[i] = tokenMsg;
                break;
            }
        }
        return joinPoint.proceed(args);
    }
}


























