package com.bwie.wangyanmin20200106.contract;

import com.bwie.wangyanmin20200106.model.bean.ClassflyBean;
import com.bwie.wangyanmin20200106.model.bean.CommidflyBean;

/*
 *@auther:王彦敏
 *@Date: 2020/1/6
 *@Time:9:20
 *@Description:
 * */
public interface IClassflyContract {
    interface IView{
        void onClassflySuccess(ClassflyBean classflyBean);
        void onClassflyFailure(Throwable throwable);

        void onCommidflySuccess(CommidflyBean commidflyBean);
        void onCommidflyFailure(Throwable throwable);
    }
    interface IPresenter{
        void getClassflyData();
        void getCommidflyData(String category);
    }

    interface IModel{
        void getClassflyData(IClassflyCallback iClassflyCallback);
        void getCommidflyData(String category,IClassflyCallback iClassflyCallback);
        interface IClassflyCallback{
            void onClassflySuccess(ClassflyBean classflyBean);
            void onClassflyFailure(Throwable throwable);

            void onCommidflySuccess(CommidflyBean commidflyBean);
            void onCommidflyFailure(Throwable throwable);
        }

    }

}
