package com.hsq.base_project_mvp.model;

import android.util.Log;
import android.widget.Toast;

import com.hsq.base_project_mvp.MyApplication;
import com.hsq.base_project_mvp.model.bean.CodeResult;
import com.hsq.base_project_mvp.model.bean.RequestBody;
import com.hsq.base_project_mvp.net.HttpCallback;
import com.hsq.base_project_mvp.net.RequestApi;
import com.hsq.base_project_mvp.net.RetrofitAPIManager;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserModelImpl implements IUserModel {
    @Override
    public void getCode(Map<String, Object> params, final HttpCallback<CodeResult> httpCallback) {
//        RequestApi api = RetrofitAPIManager.provideClientApi();
//        RequestBody requestBody = new RequestBody()
//                .setBody(params)
//                .setReqHead(new RequestBody.ReqHeadBean().setFunctionId("90001")
//                );
//        Observable<CodeResult> observable = api.getCode(requestBody);
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<CodeResult>() {
//
//                    // 发送请求后调用该复写方法（无论请求成功与否）
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        // 初始化工作
//                    }
//
//                    @Override
//                    public void onNext(CodeResult result) {
//                        httpCallback.onSuccess(result);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        httpCallback.onComplete();
//                        Log.d("TAG", "请求成功");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        httpCallback.onError();
//                        Toast.makeText(MyApplication.getContext(), "网络异常", Toast.LENGTH_SHORT).show();
//                        Log.d("TAG", "请求失败");
//                    }
//                });
        CodeResult result = new CodeResult();
        CodeResult.BodyBean bodyBean = new CodeResult.BodyBean();
        bodyBean.setCode(String.valueOf(System.currentTimeMillis()));
        result.setBody(bodyBean);
        httpCallback.onSuccess(result);
    }

}
