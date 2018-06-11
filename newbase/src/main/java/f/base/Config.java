package f.base;

/**
 * Created by DN on 2018/6/11.
 */

public class Config {
    public static  boolean isShowToast = true;
    public static  boolean isShowLog = true;

    private Config() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 是否关闭打印的日志
     * true :打开，false:关闭
     */
    public static void openLog(boolean isLog){
        isShowLog = isLog;
    }
    /**
     * 是否关闭吐司
     * true :打开，false:关闭
     */
    public static void openToast(boolean isToast){
        isShowToast = isToast;
    }
}
