package com.example.recyclerviewdemo_523.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo_523.Activity.FoodActivity_523;
import com.example.recyclerviewdemo_523.Activity.MainActivity;
import com.example.recyclerviewdemo_523.Bean.Food_523wfq;
import com.example.recyclerviewdemo_523.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Food_523wfq> list;
    private Context context;
    public  MyAdapter(Context context,List<Food_523wfq> list)
    {
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
       return new ViewHolder(v);
    }

    @Override//重写，给各个item填充数据
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,final int position) {
        Food_523wfq demoBean=list.get(position);
        if (demoBean==null) return;
        ViewHolder viewHolder=(ViewHolder) holder;
        viewHolder.imageView.setImageResource(demoBean.getImgid());
        viewHolder.tvtitle.setText(demoBean.getTitle());
        viewHolder.tvdescript.setText(demoBean.getDescription());
        viewHolder.tvtime.setText(demoBean.getTime());
        //条目中按钮监听事件
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
        //条目点击监听事件
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strid=String.valueOf(list.get(position).getTitle());
                Toast.makeText(context,strid,Toast.LENGTH_SHORT)
                        .show();

                Intent intent=new Intent(context,FoodActivity_523.class);

                context.startActivity(intent);
            }
        });
    }

    @Override//重写 ，确定条目个数
    public int getItemCount() {
        if (list!=null)
            return list.size();
        else
            return 0;
    }
    //自定义，viewHolder子类，容纳item视图
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvtitle,tvdescript,tvtime;
        Button button;
        public  ViewHolder(View itemView){
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            tvtitle=itemView.findViewById(R.id.textView);
            tvdescript=itemView.findViewById(R.id.textView2);
            tvtime=itemView.findViewById(R.id.textView3);
            button=itemView.findViewById(R.id.button);
        }
    }
}
