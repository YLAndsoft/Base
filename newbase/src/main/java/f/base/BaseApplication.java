package f.base;

import android.app.Application;
import org.xutils.x;
/**
 * Created by DN on 2018/5/28.
 */

public abstract class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);//关闭错误日志统计,默认开启
        x.Ext.setDebug(false); // 是否输出debug日志, BuildConfig.DEBUG开启debug会影响性能.
        //初始化数据库
        initDB();
    }

    /**
     * 初始化数据库
     */
    public abstract void initDB();

}
