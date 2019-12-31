package com.hsq.base_project_mvp.model;


import com.hsq.base_project_mvp.model.bean.CodeResult;
import com.hsq.base_project_mvp.net.HttpCallback;

import java.util.Map;

public interface IUserModel {
    void getCode(Map<String, Object> params, HttpCallback<CodeResult> httpCallback);
}
