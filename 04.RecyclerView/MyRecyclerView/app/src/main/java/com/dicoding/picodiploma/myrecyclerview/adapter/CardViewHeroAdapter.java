package com.dicoding.picodiploma.myrecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.myrecyclerview.R;
import com.dicoding.picodiploma.myrecyclerview.listener.CustomOnItemClickListener;
import com.dicoding.picodiploma.myrecyclerview.model.Hero;

import java.util.ArrayList;

/**
 * Created by sidiqpermana on 10/29/16.
 */

public class CardViewHeroAdapter extends RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder> {
    private ArrayList<Hero> listHero;
    private Context context;

    public CardViewHeroAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Hero> getListHero() {
        return listHero;
    }

    public void setListHero(ArrayList<Hero> listHero) {
        this.listHero = listHero;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_heroes, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int position) {

        Hero hero = getListHero().get(position);

        Glide.with(context)
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvName.setText(hero.getName());
        holder.tvFrom.setText(hero.getFrom());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Ini item favorite ku" + getListHero().get(position).getName(), Toast.LENGTH_SHORT).show();
//            }
//        });

        holder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite " + getListHero().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share " + getListHero().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListHero().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom;
        Button btnFavorite, btnShare;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}
