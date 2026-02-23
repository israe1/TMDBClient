package com.example.tmdbclient.presentation.tvShow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.tvShow.TvShow
import com.example.tmdbclient.databinding.ItemTvShowBinding

class TvShowAdapter(): RecyclerView.Adapter<TvShowViewHolder>() {
    private val tvShowList = arrayListOf<TvShow>()

    fun setList(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemTvShowBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_tv_show,
            parent,
            false
        )
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TvShowViewHolder,
        position: Int
    ) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount() = tvShowList.size
}

class TvShowViewHolder(val binding: ItemTvShowBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(tvShow: TvShow) {
        binding.tvShow = tvShow
        val posterURL = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
        Glide.with(binding.imagePoster.context)
            .load(posterURL)
            .transform(CenterCrop(), RoundedCorners(24))
            .placeholder(R.drawable.search_rounded_background)
            .into(binding.imagePoster)
    }
}