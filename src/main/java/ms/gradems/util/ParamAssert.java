package ms.gradems.util;

import ms.gradems.enums.ResponseDataEnum;
import ms.gradems.service.ex.ParamException;


public class ParamAssert {


    public static void notNull(Object obj){
        notNull(obj, ResponseDataEnum.PARAM_WRONG);
    }

    public static void notNull(Object object, ResponseDataEnum responseDataEnum){
        if (object == null){
            throw new ParamException(responseDataEnum);
        }
    }

    public static void notNull(Object obj,String msg){
        if (obj == null){
            throw new ParamException(msg);
        }
    }

    public static void isNull(Object obj,ResponseDataEnum responseDataEnum){
        if (obj != null){
            throw new ParamException(responseDataEnum);
        }
    }

    public static void equals(Object one, Object two, ResponseDataEnum responseDataEnum){
        ParamAssert.notNull(one);
        ParamAssert.notNull(two);
        if (!one.equals(two)){
            throw new ParamException(responseDataEnum);
        }
    }

    public static void isTrue(Boolean result,ResponseDataEnum responseDataEnum){
        ParamAssert.notNull(result);
        if (!result){
            throw new ParamException(responseDataEnum);
        }
    }
}
