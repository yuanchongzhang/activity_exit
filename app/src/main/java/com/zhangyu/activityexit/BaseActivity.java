package com.zhangyu.activityexit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/10.
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// 添加Activity到堆栈
        AtyContainer.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
// 结束Activity&从栈中移除该Activity
        AtyContainer.getInstance().removeActivity(this);
    }
}

class AtyContainer {
    private AtyContainer() {
    }

    private static AtyContainer instance = new AtyContainer();
    private static List<Activity> activityStack = new ArrayList<Activity>();

    public static AtyContainer getInstance() {
        return instance;
    }

    public void addActivity(Activity aty) {
        activityStack.add(aty);
    }

    public void removeActivity(Activity aty) {
        activityStack.remove(aty);
    }

    /**
     * 结束所有Activity
     */
    public static void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        Log.d("调用finfshAllactivity", "-------------------");

        activityStack.clear();
    }
}
