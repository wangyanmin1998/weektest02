package com.bwie.wangyanmin20200106.model;

import com.bwie.wangyanmin20200106.model.bean.ClassflyBean;
import com.bwie.wangyanmin20200106.model.bean.CommidflyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 *@auther:王彦敏
 *@Date: 2020/1/6
 *@Time:9:26
 *@Description:
 * */
public interface Api {
    @GET("baweiapi/category")
    Observable<ClassflyBean>  getClassflyData();
    @GET("baweiapi/shopByCategory")
    Observable<CommidflyBean> getCommidflyData(@Query("category") String category);
}
