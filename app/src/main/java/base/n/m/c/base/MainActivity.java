package base.n.m.c.base;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import f.base.BaseAppCompatActivity;
import f.base.BaseDialog;

public class MainActivity extends BaseAppCompatActivity {

    Button dialog1,dialog2,dialog3;
    private BaseDialog dialog;
    @Override
    public void initParms(Intent intent) {

    }
    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        dialog1 = (Button) findViewById(R.id.dialog1);
        dialog2 = (Button) findViewById(R.id.dialog2);
        dialog3 = (Button) findViewById(R.id.dialog3);
        dialog1.setOnClickListener(this);
        dialog2.setOnClickListener(this);
        dialog3.setOnClickListener(this);

    }

    @Override
    public void setListener() {

    }
    public void initListener() {

    }
    @Override
    public void initData(Context context) {

    }
    @Override
    public void widgetClick(View v) {
        switch (v.getId()){
            case R.id.dialog1:
                 dialog = new BaseDialog(this,"是否删除",false,new BaseDialog.OnDialogClickListener() {
                    @Override
                    public void onLeftClick() {
                        showToast("选择了否！");
                        dialog.dismiss();
                    }

                    @Override
                    public void onRigthClick(String content) {
                        showToast("选择了是！");
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.dialog2:
                dialog = new BaseDialog(this,BaseDialog.DIALOG_EDIT_STATE,"修改昵称","我想看看世界","否","是" ,false,new BaseDialog.OnDialogClickListener() {
                    @Override
                    public void onLeftClick() {
                        showToast("选择了否！");
                        dialog.dismiss();
                    }
                    @Override
                    public void onRigthClick(String content) {
                        showToast("选择了是！"+content);
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.dialog3:
                dialog = new BaseDialog(this,BaseDialog.DIALOG_CHECK_STATE,"","","取消","完成" ,false,new BaseDialog.OnDialogClickListener() {
                    @Override
                    public void onLeftClick() {
                        showToast("选择了取消！");
                        dialog.dismiss();
                    }
                    @Override
                    public void onRigthClick(String content) {
                        showToast("选择了完成！"+content);
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
        }
    }
}
