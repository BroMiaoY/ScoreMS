package ms.gradems.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TokenConfig {

    @Value("${token.secretKey}")
    private String tokenSecretKey;

    public String getTokenSecretKey() {
        return tokenSecretKey;
    }
}
