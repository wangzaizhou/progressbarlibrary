package progressbar.com.progressbarlibrary;

/**
 * Created by wangzaizhou on 2016/12/10.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.Window;


public class PgDialog {
    private static PgDialog pgDialog=new PgDialog();
    private static AlertDialog progressDialog;
    private static Context context;
    private static ProgressBarView progressBar;

    private PgDialog() {

    }

    public static  PgDialog newInstance(Context mcontext) {
        context=mcontext;



        return pgDialog;
    }


    public void setData(int num){
        if (progressBar!=null)
            progressBar.setdata(num);

    }


    public void show(String title){
        progressDialog = new AlertDialog.Builder(context).create();
        progressDialog.show();
        Window window = progressDialog.getWindow();
        window.setContentView(R.layout.itemprogress);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setOnCancelListener(new OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {

            }
        });
        progressBar = (ProgressBarView) window
                .findViewById(R.id.progressitem);
        progressBar.settitle(title);

    }

    public void dismiss(){
        if (progressDialog!=null)
        progressDialog.dismiss();
    }


    public boolean isShowing(){
        if (progressDialog==null){
            return false;
        }else{
            return progressDialog.isShowing();
        }

    }
}
