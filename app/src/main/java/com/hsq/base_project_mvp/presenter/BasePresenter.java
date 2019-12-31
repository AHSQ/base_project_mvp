package com.hsq.base_project_mvp.presenter;

import java.lang.ref.WeakReference;

public class BasePresenter<T> {

    protected WeakReference<T> mView;
    //进行绑定
    public void attachView(T view) {
        mView = new WeakReference<T>(view);
    }
    //进行解绑
    public void detachView(){
        mView.clear();
    }
    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached(){
        return mView.get() != null;
    }

}
