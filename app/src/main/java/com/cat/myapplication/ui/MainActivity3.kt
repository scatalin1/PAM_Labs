package com.cat.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cat.myapplication.api.*
import com.cat.myapplication.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private val notesList = ArrayList<Note>()
    private lateinit var binding: ActivityMain3Binding
    private lateinit var adapter: AdapterNotes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val name = intent.getStringExtra("name")
        setupViewModel()
        binding.recycler.layoutManager = LinearLayoutManager(this)
        adapter = AdapterNotes(notesList)
        binding.recycler.adapter = adapter
        setupObservers()
        binding.back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel.getNotes().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { notes -> retrieveList(notes) }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
    }

    private fun retrieveList(notes: List<Note>) {
        adapter.apply {
            notesList.addAll(notes)
            adapter.notifyDataSetChanged()
        }
    }
}
