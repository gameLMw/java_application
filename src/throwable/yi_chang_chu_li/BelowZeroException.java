package throwable.yi_chang_chu_li;

/*
 * 自定义异常
 * 1. 要继承Exception或者RuntimeException
 * 2. 提供几个构造方法
 * 3. 提供一个全局常量，声名为：static final long serialVersionUID =     ;
 * */

public class BelowZeroException extends Exception {
    static final long serialVersionUID = -3387516999948L;

    public BelowZeroException() {
    }

    public BelowZeroException(String name) {
        super(name);
    }

    public BelowZeroException(String message, Throwable cause) {
        super(message, cause);
    }
}
