package ms.gradems.util;

import io.jsonwebtoken.*;
import ms.gradems.enums.ResponseDataEnum;
import ms.gradems.service.ex.TokenException;
import ms.gradems.token.TokenBuilder;
import ms.gradems.token.TokenMsg;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TokenUtil {

    public static final String TOKEN_HEADER = "token";

    private static final String ID = "id";

    private static final String ROLE = "role";

    private static final String USER_REAL_NAME = "user_real_name";

    //生成 token
    public static String token(Map<String, Object> claims, String secretKey, int millisecond, String jwtIssuer, String jwtAud) {
        //获取当前的时间
        Calendar calendar = Calendar.getInstance();
        //获取系统当前时间
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        //失效的时间
        calendar.add(Calendar.MILLISECOND, millisecond);
        //拿到预定过期时间的日期
        Date endTime = calendar.getTime();
        JwtBuilder builder = Jwts.builder()
                //签名算法
                .signWith(SignatureAlgorithm.HS256, secretKey)
                //签发时间
                .setIssuedAt(new Date())
                //playLoad
                .setClaims(claims)
                //到期时间
                .setExpiration(endTime)
                //签发者
                .setIssuer(jwtIssuer)
                //接收者
                .setAudience(jwtAud);
        return builder.compact();
    }

    // 解析 token
    public static Claims parse(String jwt, String secretKey) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();
        } catch (ExpiredJwtException e) {
            throw new TokenException("token过期");
        } catch (JwtException e) {
            throw new TokenException("JWT验证错误");
        } catch (IllegalArgumentException e) {
            throw new TokenException("Token为空");
        }
        return claims;
    }



    //获取一个token
    public static String buildToken(TokenBuilder tb) {
        TokenMsg tokenMsg = tb.getMsg();
        Map<String, Object> map = new HashMap<>(3);
        map.put(ID, tokenMsg.getId());
        map.put(ROLE, tokenMsg.getRole());
        map.put(USER_REAL_NAME, tokenMsg.getNum());
        String token = token(map,tb.getSecretKey(), tb.getMillisecond(), tb.getJwtIssuer(),tb.getJwtAud());
        return token;
    }


    //从 token 中获取字段
    public static Object tokenValueOf(String jwt, String secretKey, String key) {
        Claims claims = parse(jwt, secretKey);
        return claims.get(key);
    }

    //从http请求的Header中获取token
    public static String getToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_HEADER);
        ParamAssert.notNull(token, ResponseDataEnum.NULL_TOKEN);
        return token;
    }

    //从Token中获取token信息
    public static TokenMsg getTokenMsg(String token, String secretKey) {
        TokenMsg tokenMsg = new TokenMsg();
        tokenMsg.setId((Integer) tokenValueOf(token, secretKey, ID));
        tokenMsg.setRole((String) tokenValueOf(token, secretKey, ROLE));
        tokenMsg.setNum((String) tokenValueOf(token, secretKey,USER_REAL_NAME));
        return tokenMsg;
    }

    public static TokenMsg getTokenMsg(HttpServletRequest request, String secretKey){
        String token = getToken(request);
        TokenMsg tokenMsg = getTokenMsg(token,secretKey);
        return tokenMsg;
    }

}
