package ms.gradems.service.ex;

import ms.gradems.enums.ResponseDataEnum;


public class BaseException extends RuntimeException{

    protected ResponseDataEnum responseDataEnum;
    public BaseException(){
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(ResponseDataEnum responseDataEnum){
        super(responseDataEnum.getMsg());
        this.responseDataEnum = responseDataEnum;
    }

    public ResponseDataEnum getResponseDataEnum() {
        return responseDataEnum;
    }
}
