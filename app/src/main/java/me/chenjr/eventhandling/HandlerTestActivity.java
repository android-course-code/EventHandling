package me.chenjr.eventhandling;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class HandlerTestActivity extends AppCompatActivity {
    final int MAX_PROGRESS = 100;
    final int CHANGE_PROGRESS = 0x666;
    final int DISMISS_PROGRESS_DIALOG = 0x777;
    final int PROGRESS_GAP = 100;
    ProgressDialog pd;
    int progress = 0;
    /*用于接收消息的handler*/
    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            Log.d("{Progress}", "handleMessage: progress is "+progress);
            /*对收到的消息做判断*/
            switch (msg.what) {
                case CHANGE_PROGRESS:
                    pd.setProgress(progress);
                    break;
                case DISMISS_PROGRESS_DIALOG:
                    pd.dismiss();
                    break;
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);
        pd = new ProgressDialog(this);

    }

    /*执行任务按钮的回调方法*/
    public void clickHandler(View view) {
        /*设置标题*/
        pd.setTitle(getString(R.string.Handler_test_pd_title));
        /*设置信息*/
        pd.setMessage(getString(R.string.Handler_test_pd_message));
        /*设置最大进度*/
        pd.setMax(MAX_PROGRESS);
        /*设置可取消*/
        pd.setCancelable(true);
        /*设置未横向的进度条*/
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        /*设置为明确的进度条*/
        pd.setIndeterminate(false);
        progress = 0;

        pd.setProgress(progress);
        pd.show();
        /*新建线程用于执行任务, 并在每一小段完成之后发出消息通知handler更新进度*/
        new Thread() {
            @Override
            public void run() {
                while (progress < MAX_PROGRESS) {
                    doWork();
                    handler.sendEmptyMessage(CHANGE_PROGRESS);

                }
                /*任务执行完成, 发送关闭对话框的消息*/
                handler.sendEmptyMessage(DISMISS_PROGRESS_DIALOG);

            }
        }.start();

    }
    /*模拟耗时任务*/
    public int doWork() {
        try {
            Thread.sleep(PROGRESS_GAP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ++progress;
    }
}
