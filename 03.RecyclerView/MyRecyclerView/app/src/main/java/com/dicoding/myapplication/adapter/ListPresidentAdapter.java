package com.dicoding.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.myapplication.R;
import com.dicoding.myapplication.model.President;

import java.util.ArrayList;

/**
 * Created by sidiqpermana on 10/28/16.
 */

public class ListPresidentAdapter extends RecyclerView.Adapter<ListPresidentAdapter.CategoryViewHolder> {
    private Context context;

    private ArrayList<President> getListPresident() {
        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }

    private ArrayList<President> listPresident;


    public ListPresidentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_president, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListPresident().get(position).getName());
        holder.tvRemarks.setText(getListPresident().get(position).getRemarks());

        Glide.with(context)
                .load(getListPresident().get(position).getPhoto())
                .transition(new DrawableTransitionOptions().crossFade())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView) itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);
        }
    }
}
