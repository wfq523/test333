package com.example.recyclerviewdemo_523wfq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<DemoBean> list;
    //自定义 构造方法
    public MyAdapter(Context context)
    {
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
    }
    //自定义 设置数据
    public void setList(List<DemoBean> list)
    {
        this.list=list;
        notifyDataSetChanged();

    }
    //自定义 ViewHolder 子类
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvtitle,tvdescript,tvtime;
        Button button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            tvtitle=itemView.findViewById(R.id.textView);
            tvdescript=itemView.findViewById(R.id.textView2);
            tvtime=itemView.findViewById(R.id.textView3);
            button=itemView.findViewById(R.id.button);

        }
    }

    //重写,给每个 item 生成一个 view
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final DemoBean demoBean=list.get(position);
        if (demoBean==null)
            return;
        ViewHolder viewHolder=(ViewHolder)holder;
        viewHolder.imageView.setImageResource(demoBean.getImgid());
        viewHolder.tvtitle.setText(demoBean.getTitle());
        viewHolder.tvdescript.setText(demoBean.getDescription());
        viewHolder.tvtime.setText(demoBean.getTime());
        //条目中按钮的点击事件
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
        //整个条目的点击事件
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=String.valueOf(demoBean.getId());
                Toast.makeText(context, "点击的条目id="+string, Toast.LENGTH_SHORT).show();
            }
        });
    }


    //重写 确定条目个数
    @Override
    public int getItemCount() {
        if(list!=null)
            return list.size();
        else
            return 0;
    }
}
