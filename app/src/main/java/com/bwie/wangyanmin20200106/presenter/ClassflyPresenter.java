package com.bwie.wangyanmin20200106.presenter;

import com.bwie.wangyanmin20200106.base.BasePresenter;
import com.bwie.wangyanmin20200106.contract.IClassflyContract;
import com.bwie.wangyanmin20200106.model.ClassflyModel;
import com.bwie.wangyanmin20200106.model.bean.ClassflyBean;
import com.bwie.wangyanmin20200106.model.bean.CommidflyBean;

/*
 *@auther:王彦敏
 *@Date: 2020/1/6
 *@Time:9:53
 *@Description:
 * */
public class ClassflyPresenter extends BasePresenter<IClassflyContract.IView> implements IClassflyContract.IPresenter {

    private ClassflyModel classflyModel;

    @Override
    protected void initModel() {
        classflyModel = new ClassflyModel();
    }

    @Override
    public void getClassflyData() {
        classflyModel.getClassflyData(new IClassflyContract.IModel.IClassflyCallback() {
            @Override
            public void onClassflySuccess(ClassflyBean classflyBean) {
                view.onClassflySuccess(classflyBean);
            }

            @Override
            public void onClassflyFailure(Throwable throwable) {
                view.onClassflyFailure(throwable);
            }

            @Override
            public void onCommidflySuccess(CommidflyBean commidflyBean) {
                view.onCommidflySuccess(commidflyBean);
            }

            @Override
            public void onCommidflyFailure(Throwable throwable) {
                view.onCommidflyFailure(throwable);
            }
        });
    }

    @Override
    public void getCommidflyData(String category) {
        classflyModel.getCommidflyData(category, new IClassflyContract.IModel.IClassflyCallback() {
            @Override
            public void onClassflySuccess(ClassflyBean classflyBean) {
                view.onClassflySuccess(classflyBean);
            }

            @Override
            public void onClassflyFailure(Throwable throwable) {
                view.onClassflyFailure(throwable);
            }

            @Override
            public void onCommidflySuccess(CommidflyBean commidflyBean) {
                view.onCommidflySuccess(commidflyBean);
            }

            @Override
            public void onCommidflyFailure(Throwable throwable) {
                view.onCommidflyFailure(throwable);
            }
        });
    }
}
