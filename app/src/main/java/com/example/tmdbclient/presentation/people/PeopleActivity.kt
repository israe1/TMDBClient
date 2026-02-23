package com.example.tmdbclient.presentation.people

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityPeopleBinding
import com.example.tmdbclient.presentation.di.core.Injector
import javax.inject.Inject

class PeopleActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: PeopleViewModelFactory
    private lateinit var peopleViewModel: PeopleViewModel
    private lateinit var adapter: PeopleAdapter
    lateinit var binding: ActivityPeopleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        (application as Injector).createPeopleSubComponent().inject(this)
        peopleViewModel = ViewModelProvider(this, factory)[PeopleViewModel::class.java]

        binding.toolbar.setNavigationOnClickListener { finish() }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.peopleList.layoutManager = LinearLayoutManager(this)
        adapter = PeopleAdapter()
        binding.peopleList.adapter = adapter
        displayPeople()
    }

    private fun displayPeople() {
        binding.progressBar.visibility = View.VISIBLE
        val liveData = peopleViewModel.getPeople()
        liveData.observe(this) {
            binding.progressBar.visibility = View.GONE
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateMovies() {
        binding.progressBar.visibility = View.VISIBLE
        val response = peopleViewModel.updatePeople()
        response.observe(this) {
            binding.progressBar.visibility = View.GONE
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }
}