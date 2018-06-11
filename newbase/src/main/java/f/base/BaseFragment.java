package f.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by DN on 2017/7/22.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener{
    protected View mContextView = null;
    protected Context mContext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        try{
            mContextView = inflater.inflate(bindLayout(), null, false);//绑定布局
        }catch (Exception ex){
            showToast("绑定布局异常");
            ex.printStackTrace();
            return null;
        }
        initView();//初始化控件
        initData_();//加载数据
        return mContextView;
    }


    /**
     * [绑定布局]
     *
     * @return
     */
    public abstract int bindLayout();

    /**
     * [初始化控件]
     *
     */

    private void initData_() {
        initData();
    }

    /**
     * 控件的初始化
     */
    protected abstract void initView();

    /**
     * 数据显示
     */
    protected abstract void initData();

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mContext = activity;
    }

    /** View点击 **/
    public abstract void widgetClick(View v);

    @Override
    public void onClick(View v) {
        widgetClick(v);
    }

    /**
     * [吐出Toast]
     * @param msg
     */
    protected void showToast(String msg){
        if(Config.isShowToast){
            if(null!=getActivity()){
                Toast.makeText(getActivity(),msg, Toast.LENGTH_SHORT).show();
            }

        }
    }

    /**
     * [打印日志]
     * @param msg
     */
    public static final String TAG1 = "BaseFragment";
    protected void showLog(String msg){
        if(Config.isShowLog){
            Log.i(TAG1,msg);
        }
    }

}
