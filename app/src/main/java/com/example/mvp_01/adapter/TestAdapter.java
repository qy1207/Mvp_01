package com.example.mvp_01.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.data.InfoBean;
import com.example.mvp_01.R;

import java.util.List;


public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    private List<InfoBean.DatasBean> datas;
    private Context mContext;

    public TestAdapter(List<InfoBean.DatasBean> datas, Context mContext) {
        this.datas = datas;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.test_adapter_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InfoBean.DatasBean bean = datas.get(position);
        holder.title.setText(bean.getTitle());
        holder.desc.setText(bean.getAuthor());
        Glide.with(mContext).load(bean.getThumbnail()).into(holder.leftImage);

    }

    @Override
    public int getItemCount() {
      return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView leftImage;
        TextView title;
        TextView desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leftImage = itemView.findViewById(R.id.left_image);
            title = itemView.findViewById(R.id.title_content);
            desc = itemView.findViewById(R.id.desc_content);
        }
    }
}
