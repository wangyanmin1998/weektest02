package com.bwie.wangyanmin20200106.view.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.bwie.wangyanmin20200106.R;
import com.bwie.wangyanmin20200106.base.BaseActivity;
import com.bwie.wangyanmin20200106.contract.IClassflyContract;
import com.bwie.wangyanmin20200106.model.bean.ClassflyBean;
import com.bwie.wangyanmin20200106.model.bean.CommidflyBean;
import com.bwie.wangyanmin20200106.presenter.ClassflyPresenter;
import com.bwie.wangyanmin20200106.util.NetUtil;
import com.bwie.wangyanmin20200106.view.adapter.ClassflyAdapter;
import com.bwie.wangyanmin20200106.view.adapter.CommidflyAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<ClassflyPresenter> implements IClassflyContract.IView {

    @BindView(R.id.recy_classfly)
    RecyclerView recyClassfly;
    @BindView(R.id.recy_commidfly)
    RecyclerView recyCommidfly;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected ClassflyPresenter providePresenter() {
        return new ClassflyPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        
        if (NetUtil.hasNet(this)){
            mPresenter.getClassflyData();
            mPresenter.getCommidflyData("生活");
        }else {
            Toast.makeText(this, "没有网络", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onClassflySuccess(ClassflyBean classflyBean) {
        List<String> category = classflyBean.getCategory();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyClassfly.setLayoutManager(linearLayoutManager);
        ClassflyAdapter classflyAdapter = new ClassflyAdapter(category);
        recyClassfly.setAdapter(classflyAdapter);
        classflyAdapter.setOnTagClickListner(new ClassflyAdapter.onTagClickListner() {
            @Override
            public void onTagClick(int position) {
                EventBus.getDefault().post(category.get(position));
            }
        });

        String name = category.get(0);
        mPresenter.getCommidflyData(name);

    }

    @Override
    public void onClassflyFailure(Throwable throwable) {

    }

    @Override
    public void onCommidflySuccess(CommidflyBean commidflyBean) {
        List<CommidflyBean.DataBean> data = commidflyBean.getData();

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyCommidfly.setLayoutManager(gridLayoutManager);
        CommidflyAdapter commidflyAdapter = new CommidflyAdapter(data);
        recyCommidfly.setAdapter(commidflyAdapter);

    }

    @Override
    public void onCommidflyFailure(Throwable throwable) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void getCategory(String category){
        mPresenter.getCommidflyData(category);
    }
}
