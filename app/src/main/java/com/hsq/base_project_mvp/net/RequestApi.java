package com.hsq.base_project_mvp.net;


import com.hsq.base_project_mvp.model.bean.CodeResult;
import com.hsq.base_project_mvp.model.bean.RequestBody;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by hsq on 2018/1/10.
 */

public interface RequestApi {
    @POST("openService/direct")
    Observable<CodeResult> getCode(@Body RequestBody requestBody);
}
