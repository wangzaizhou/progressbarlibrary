package progressbar.com.progressbarlib;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import progressbar.com.progressbarlibrary.PgDialog;

public class MainActivity extends AppCompatActivity {
    private PgDialog pd;
    private int pro=0;
    private Context context;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1) {
                pd.setData(pro);
                if (pro>100) {
                    pd.dismiss();
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        pd=PgDialog.newInstance(context);







    }


    public void Run(View view){
        if (!pd.isShowing()){

            pd.show("正在下载中...");
        }
        pro=0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<102;i++){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    pro=i;
                    handler.sendEmptyMessage(1);

                }



            }
        }).start();
    }
}
