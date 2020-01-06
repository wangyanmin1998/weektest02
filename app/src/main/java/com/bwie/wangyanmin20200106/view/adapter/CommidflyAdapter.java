package com.bwie.wangyanmin20200106.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.wangyanmin20200106.R;
import com.bwie.wangyanmin20200106.model.bean.CommidflyBean;
import com.bwie.wangyanmin20200106.util.NetUtil;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther:王彦敏
 *@Date: 2020/1/6
 *@Time:10:19
 *@Description:
 * */
public class CommidflyAdapter extends RecyclerView.Adapter<CommidflyAdapter.MyViewHolder> {

    private List<CommidflyBean.DataBean> list;
    private CommidflyBean.DataBean dataBean;

    public CommidflyAdapter(List<CommidflyBean.DataBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.commidfly_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        dataBean = list.get(position);
        holder.tvName.setText(dataBean.getGoods_english_name());
        holder.tvBase.setText(dataBean.getGoods_name());
        holder.tvPrice.setText(dataBean.getCurrency_price()+"");
        NetUtil.getInstance().getPhoto(dataBean.getGoods_thumb(),holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_base)
        TextView tvBase;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
