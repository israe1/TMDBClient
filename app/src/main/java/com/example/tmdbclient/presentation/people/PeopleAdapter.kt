package com.example.tmdbclient.presentation.people

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.people.People
import com.example.tmdbclient.databinding.ItemMovieBinding
import com.example.tmdbclient.databinding.ItemPeopleBinding

class PeopleAdapter(): RecyclerView.Adapter<PeopleViewHolder>() {
    private val peopleList = arrayListOf<People>()

    fun setList(people: List<People>) {
        peopleList.clear()
        peopleList.addAll(people)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PeopleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemPeopleBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_people,
            parent,
            false
        )
        return PeopleViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PeopleViewHolder,
        position: Int
    ) {
        holder.bind(peopleList[position])
    }

    override fun getItemCount() = peopleList.size
}

class PeopleViewHolder(val binding: ItemPeopleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(people: People) {
        binding.people = people
        val posterURL = "https://image.tmdb.org/t/p/w500" + people.profilePath
        Glide.with(binding.imagePoster.context)
            .load(posterURL)
            .transform(CenterCrop(), RoundedCorners(24))
            .placeholder(R.drawable.search_rounded_background)
            .into(binding.imagePoster)
    }
}