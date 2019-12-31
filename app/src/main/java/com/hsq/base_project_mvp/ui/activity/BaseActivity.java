package com.hsq.base_project_mvp.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hsq.base_project_mvp.presenter.BasePresenter;
import com.hsq.base_project_mvp.utils.AppManager;


public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {
    public T myPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        myPresenter = createPresenter();
        if (myPresenter != null){
            myPresenter.attachView((V)this);
        }
    }

    protected abstract T createPresenter();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
        if (myPresenter != null) {
            myPresenter.detachView();
        }
    }
}
