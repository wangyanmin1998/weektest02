package com.bwie.wangyanmin20200106.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

/*
 *@auther:王彦敏
 *@Date: 2020/1/6
 *@Time:9:16
 *@Description:
 * */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mPresenter=providePresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initView();
        initData();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }

    protected abstract int layoutId();

    protected abstract P providePresenter();

    protected abstract void initView();

    protected abstract void initData();
}
