package com.bwie.wangyanmin20200106.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.wangyanmin20200106.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther:王彦敏
 *@Date: 2020/1/6
 *@Time:10:04
 *@Description:
 * */
public class ClassflyAdapter extends RecyclerView.Adapter<ClassflyAdapter.MyViewHolder> {
    private List<String> list;

    public ClassflyAdapter(List<String> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.classfly_item, parent, false);

        return new MyViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = list.get(position);
        holder.tv.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTagClickListner.onTagClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnTagClickListner(ClassflyAdapter.onTagClickListner onTagClickListner) {
        this.onTagClickListner = onTagClickListner;
    }

    onTagClickListner onTagClickListner;
    public interface onTagClickListner{
        void onTagClick(int position);
    }

}
