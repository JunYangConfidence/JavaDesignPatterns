package com.example.messagehandler;

import android.content.pm.LauncherApps;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ThreadLocal<Boolean> m_threadLocal = new ThreadLocal<Boolean>();
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private TextView tv_name;
    private Handler m_handler;
    private Handler m_threadHandler;
    private Handler handlercallback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logcat("onCreate");
        final Looper mainLooper = getMainLooper();
        logcat("mainLooper = "+mainLooper);
        m_threadLocal.set(true);
        logcat("m_threadLocal = "+m_threadLocal.get());

        tv_name = (TextView) findViewById(R.id.tv_Name);

        btn_1 = (Button) findViewById(R.id.btn_01);
        btn_2 = (Button) findViewById(R.id.btn_02);
        btn_3 = (Button) findViewById(R.id.btn_03);


        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);

        m_handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                logcat("what = "+msg.what);
                switch (msg.what){
                    case 1:
                        tv_name.setText("更新UI界面");
                        break;
                    default:
                }
            }
        };

    }

    @Override
    protected void onResume() {
        super.onResume();
        logcat("onResume");
//        PackageManager packageManager = getPackageManager();
//        List<PackageInfo> infos = packageManager.getInstalledPackages(0);
//        int size = infos.size();
//        logcat("size = "+size);
//        for (int i = 0; i < size; i++) {
//            PackageInfo packageInfo = infos.get(i);
//            String name = (String) packageManager.getApplicationLabel(packageInfo.applicationInfo);
//            logcat("name = "+name);
//        }

    }

    private void logcat(String msg){
        Log.d("test",msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_01:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        m_handler.sendEmptyMessage(1);
                    }
                }).start();
                break;
            case R.id.btn_02:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        m_threadLocal.set(false);
                        logcat("th1 m_threadLocal = "+m_threadLocal.get());
                        Looper.prepare();
                        logcat("mylooper = "+Looper.myLooper());
                        handlercallback = new Handler(new Handler.Callback() {
                            @Override
                            public boolean handleMessage(Message msg) {
                                logcat("handlercall back");
                                switch (msg.what){
                                    case 5:
                                        logcat("call back ");
                                        break;
                                    default:
                                }
                                return false;
                            }
                        });
                        m_threadHandler = new Handler(Looper.myLooper()){
                            @Override
                            public void handleMessage(Message msg) {
                                super.handleMessage(msg);
                                logcat("msg what = "+msg.what);
                                switch (msg.what){
                                    case 2:
                                        logcat("哈哈哈，我也是looper线程了");
                                        break;
                                    default:
                                }
                            }
                        };
                        Looper.loop();

                    }
                }).start();
                break;
            case R.id.btn_03:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        logcat("th2 m_threadLocal = "+m_threadLocal.get());
                        m_threadHandler.sendEmptyMessage(2);
                        handlercallback.sendEmptyMessage(5);
                    }
                }).start();
                break;
        }

    }
}
