package com.example.tmdbclient.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityHomeBinding
import com.example.tmdbclient.presentation.movie.MovieActivity
import com.example.tmdbclient.presentation.people.PeopleActivity
import com.example.tmdbclient.presentation.tvShow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply {
            itemMovies.root.setOnClickListener { openCategoryActivity(MovieActivity()) }
            itemTvShow.root.setOnClickListener { openCategoryActivity(TvShowActivity()) }
            itemPeople.root.setOnClickListener { openCategoryActivity(PeopleActivity()) }
        }
    }

    private fun openCategoryActivity(activity: Activity) {
        startActivity(Intent(this, activity::class.java))
    }
}