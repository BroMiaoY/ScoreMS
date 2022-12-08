package ms.gradems.service.ex;

/**用户工号或学号被占用的异常*/
public class UserNumDuplicatedException extends ServiceException{

    // alt + insert ---- override methods...
    public UserNumDuplicatedException() {
        super();
    }

    public UserNumDuplicatedException(String message) {
        super(message);
    }

    public UserNumDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNumDuplicatedException(Throwable cause) {
        super(cause);
    }

    protected UserNumDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}