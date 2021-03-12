package com.cat.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.cat.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val purses = ArrayList<String>()
        purses.add("main 4059L")
        purses.add("card 9584L")
        purses.add("card1 6049L")
        println(purses)

        binding.purses.layoutManager = LinearLayoutManager(this)
        binding.purses.adapter = AdapterPurses(purses)
    }

    fun add_button(v: View){
        val newIntent = Intent(this, MainActivity2::class.java)
        startActivity(newIntent)
    }
}