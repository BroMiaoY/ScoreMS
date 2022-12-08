package ms.gradems.service.ex;

import ms.gradems.enums.ResponseDataEnum;

public class TokenException extends BaseException {

    public TokenException() {
        super();
    }

    public TokenException(String message) {
        super(message);
    }

    public TokenException(ResponseDataEnum responseDataEnum) {
        super(responseDataEnum);
    }
}
