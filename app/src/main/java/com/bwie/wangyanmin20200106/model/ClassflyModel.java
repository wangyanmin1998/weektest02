package com.bwie.wangyanmin20200106.model;

import com.bwie.wangyanmin20200106.contract.IClassflyContract;
import com.bwie.wangyanmin20200106.model.bean.ClassflyBean;
import com.bwie.wangyanmin20200106.model.bean.CommidflyBean;
import com.bwie.wangyanmin20200106.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 *@auther:王彦敏
 *@Date: 2020/1/6
 *@Time:9:46
 *@Description:
 * */
public class ClassflyModel implements IClassflyContract.IModel {
    @Override
    public void getClassflyData(IClassflyCallback iClassflyCallback) {
        NetUtil.getInstance().getApi().getClassflyData()
                //子线程联网
                .subscribeOn(Schedulers.io())
                //主线程更新
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClassflyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ClassflyBean classflyBean) {
                        iClassflyCallback.onClassflySuccess(classflyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iClassflyCallback.onClassflyFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getCommidflyData(String category, IClassflyCallback iClassflyCallback) {
        NetUtil.getInstance().getApi().getCommidflyData(category)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommidflyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommidflyBean commidflyBean) {
                        iClassflyCallback.onCommidflySuccess(commidflyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iClassflyCallback.onCommidflyFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
