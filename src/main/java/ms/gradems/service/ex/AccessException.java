package ms.gradems.service.ex;

import ms.gradems.enums.ResponseDataEnum;

/**
 * 权限异常
 */
public class AccessException extends BaseException{

    public AccessException(){
        super();
    }

    public AccessException(String message) {
        super(message);
    }

    public AccessException(ResponseDataEnum responseDataEnum){
        super(responseDataEnum);
    }

}
