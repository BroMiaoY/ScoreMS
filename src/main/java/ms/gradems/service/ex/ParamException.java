package ms.gradems.service.ex;

import ms.gradems.enums.ResponseDataEnum;

//参数错误异常
public class ParamException extends BaseException{

    public ParamException(){
        super();
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(ResponseDataEnum responseDataEnum){
        super(responseDataEnum);
    }


}
