package com.cat.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cat.myapplication.api.*
import com.cat.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private val purses = ArrayList<Model>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdapterPurses

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupViewModel()

        binding.purses.layoutManager = LinearLayoutManager(this)
        adapter = AdapterPurses(purses)
        binding.purses.adapter = adapter
        setupObservers()
    }

    fun add_button(v: View){
        val newIntent = Intent(this, MainActivity2::class.java)
        startActivity(newIntent)
    }
    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel.getPayments().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { payments -> retrieveList(payments) }
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

    private fun retrieveList(payments: List<Model>) {
        adapter.apply {
            purses.addAll(payments)
            adapter.notifyDataSetChanged()
        }
    }
}