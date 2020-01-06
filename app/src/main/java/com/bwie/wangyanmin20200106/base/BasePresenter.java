package com.bwie.wangyanmin20200106.base;

/*
 *@auther:王彦敏
 *@Date: 2020/1/6
 *@Time:9:14
 *@Description:
 * */
public abstract class BasePresenter<V> {
    protected V view;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void attach(V view){
        this.view=view;
    }

    public void detach(){
        view=null;
    }
}
