package ms.gradems.token;


public class TokenBuilder {
    private TokenMsg msg;

    private String secretKey;
    /**
     * token 有效时间 5h
     */
    private int millisecond = 5 * 60 * 1000 * 60;

    private String jwtIssuer = "Artwork";
    private String jwtAud = "user";

    public TokenBuilder(TokenMsg msg, String secretKey) {
        this.msg = msg;
        this.secretKey = secretKey;
    }
    public TokenBuilder(TokenMsg msg, String secretKey, int millisecond) {
        this.msg = msg;
        this.secretKey = secretKey;
        this.millisecond = millisecond;
    }

    public TokenBuilder(TokenMsg msg, String secretKey, int millisecond, String jwtIssuer, String jwtAud) {
        this.msg = msg;
        this.secretKey = secretKey;
        this.millisecond = millisecond;
        this.jwtIssuer = jwtIssuer;
        this.jwtAud = jwtAud;
    }

    public TokenMsg getMsg() {
        return msg;
    }

    public void setMsg(TokenMsg msg) {
        this.msg = msg;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public int getMillisecond() {
        return millisecond;
    }

    public void setMillisecond(int millisecond) {
        this.millisecond = millisecond;
    }

    public String getJwtIssuer() {
        return jwtIssuer;
    }

    public void setJwtIssuer(String jwtIssuer) {
        this.jwtIssuer = jwtIssuer;
    }

    public String getJwtAud() {
        return jwtAud;
    }

    public void setJwtAud(String jwtAud) {
        this.jwtAud = jwtAud;
    }
}
