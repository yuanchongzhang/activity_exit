package com.zhangyu.activityexit;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

public class MainActivity extends BaseActivity2{
    private boolean isExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
         ExitReceiver exit=new ExitReceiver();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        exit.onReceive(MainActivity.this,intent);
        return super.onKeyDown(keyCode, event);
    }
/*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //   Toast.makeText(this, "点击两次离开", Toast.LENGTH_SHORT).show();
            ToQuitTheApp();
            return false;

        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    //封装ToQuitTheApp方法
    private void ToQuitTheApp() {
        if (isExit) {

          finishAllActivity();

        } else {
            isExit = true;
            Toast.makeText(MainActivity.this, "再按一次退出APP", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0, 3000);// 3秒后发送消息
        }
    }

    //创建Handler对象，用来处理消息
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {//处理消息
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            isExit = false;
        }
    };*/
}
