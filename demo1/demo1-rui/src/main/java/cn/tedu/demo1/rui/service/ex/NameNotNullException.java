package cn.tedu.demo1.rui.service.ex;

/**
 * 账号 已存在
 */
public class NameNotNullException extends ServiceException {
    public NameNotNullException() {
    }

    public NameNotNullException(String message) {
        super(message);
    }

    public NameNotNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameNotNullException(Throwable cause) {
        super(cause);
    }

    public NameNotNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
