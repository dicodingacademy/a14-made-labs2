package com.dicoding.picodiploma.myrecyclerview.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.myrecyclerview.R;
import com.dicoding.picodiploma.myrecyclerview.model.Hero;

import java.util.ArrayList;

/**
 * Created by sidiqpermana on 10/29/16.
 */

public class GridHeroAdapter extends RecyclerView.Adapter<GridHeroAdapter.GridViewHolder> {
    private final ArrayList<Hero> listHero;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    public GridHeroAdapter(ArrayList<Hero> list) {
        this.listHero = list;
    }

    @NonNull
    @Override
    public GridHeroAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_hero, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridHeroAdapter.GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listHero.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listHero.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgPhoto;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Hero data);
    }
}
