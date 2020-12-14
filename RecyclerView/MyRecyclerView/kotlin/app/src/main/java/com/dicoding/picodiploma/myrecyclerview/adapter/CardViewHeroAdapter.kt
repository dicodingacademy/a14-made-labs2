package com.dicoding.picodiploma.myrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.myrecyclerview.databinding.ItemCardviewHeroBinding
import com.dicoding.picodiploma.myrecyclerview.model.Hero
import java.util.*

/**
 * Created by sidiqpermana on 10/29/16.
 */

class CardViewHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardViewViewHolder {
        val binding = ItemCardviewHeroBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return CardViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size

    inner class CardViewViewHolder(private val binding: ItemCardviewHeroBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            with(binding) {
                Glide.with(itemView.context)
                        .load(hero.photo)
                        .apply(RequestOptions().override(350, 550))
                        .into(imgItemPhoto)

                tvItemName.text = hero.name
                tvItemDescription.text = hero.description

                btnSetFavorite.setOnClickListener { Toast.makeText(itemView.context, "Favorite ${hero.name}", Toast.LENGTH_SHORT).show() }

                btnSetShare.setOnClickListener { Toast.makeText(itemView.context, "Share ${hero.name}", Toast.LENGTH_SHORT).show() }

                itemView.setOnClickListener { Toast.makeText(itemView.context, "Kamu memilih ${hero.name}", Toast.LENGTH_SHORT).show() }
            }
        }
    }
}
