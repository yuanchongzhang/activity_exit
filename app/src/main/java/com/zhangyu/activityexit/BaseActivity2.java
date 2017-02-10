package com.zhangyu.activityexit;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/2/10.
 */

public class BaseActivity2 extends Activity {

    private static final String EXITACTION = "action.exit";
    private ExitReceiver exitReceiver = new ExitReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter filter = new IntentFilter();
        filter.addAction(EXITACTION);
        registerReceiver(exitReceiver, filter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(exitReceiver);
    }
    public class ExitReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "广播方式离开", Toast.LENGTH_SHORT).show();
            BaseActivity2.this.finish();
        }
    }

}

