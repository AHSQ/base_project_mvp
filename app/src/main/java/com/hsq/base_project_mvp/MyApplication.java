package com.hsq.base_project_mvp;

import android.app.Application;
import android.content.Context;

/**
 * <pre>
 *     author : hsq
 *     e-mail : 905319761@qq.com
 *     time   : 2019/04/03
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static Context getContext() {
        return mContext;
    }
}
