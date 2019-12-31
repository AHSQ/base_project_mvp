package com.hsq.base_project_mvp.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.hsq.base_project_mvp.R;
import com.hsq.base_project_mvp.model.bean.CodeResult;
import com.hsq.base_project_mvp.presenter.UserPresenter;
import com.hsq.base_project_mvp.view.UserView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<UserView, UserPresenter<UserView>> implements UserView {

    @BindView(R.id.test_btn)
    Button btn;
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btn.setOnClickListener((view) -> {
            Map<String, Object> params = new HashMap<>();
            myPresenter.getCode(params);
        });
    }

    @Override
    protected UserPresenter<UserView> createPresenter() {
        return new UserPresenter<>();
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showData(Object data) {
        CodeResult responseResult = (CodeResult) data;
        String code = responseResult.getBody().getCode();
        showToast("验证码：" + code);
        this.code = code;
    }

    @Override
    public void showFailure(String msg) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

    }
}
