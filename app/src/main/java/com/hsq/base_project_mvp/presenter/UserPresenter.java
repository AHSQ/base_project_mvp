package com.hsq.base_project_mvp.presenter;

import com.hsq.base_project_mvp.model.IUserModel;
import com.hsq.base_project_mvp.model.UserModelImpl;
import com.hsq.base_project_mvp.model.bean.CodeResult;
import com.hsq.base_project_mvp.net.HttpCallback;
import com.hsq.base_project_mvp.view.UserView;

import java.util.Map;

/**
 * <pre>
 *     author : hsq
 *     e-mail : 905319761@qq.com
 *     time   : 2019/04/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class UserPresenter<T extends UserView> extends BasePresenter<T>  {
    private IUserModel userModel =new UserModelImpl();
    public UserPresenter() {}

    public void getCode(Map<String, Object> params){
        if (!isViewAttached()){
            return;
        }
        mView.get().showLoading();
        if (userModel!=null){
            userModel.getCode(params,new HttpCallback<CodeResult>() {
                @Override
                public void onSuccess(CodeResult data) {
                    if (isViewAttached()){
                        mView.get().showData(data);
                    }
                }

                @Override
                public void onFailure(String msg) {
                    if (isViewAttached()){
                        mView.get().showFailure(msg);
                    }
                }

                @Override
                public void onError() {
                    if (isViewAttached()){
                        mView.get().showError();
                    }
                }

                @Override
                public void onComplete() {
                    if (isViewAttached()){
                        mView.get().hideLoading();
                    }
                }
            });
        }
    }
}
