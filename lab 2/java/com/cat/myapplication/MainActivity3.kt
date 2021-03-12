package com.cat.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cat.myapplication.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val notes = ArrayList<Note>()
        notes.add(Note(5960, "income", "main", "salary"))
        notes.add(Note(5960, "transfer", "main", ""))
        notes.add(Note(5960, "spending", "main", "salary"))
        notes.add(Note(5960, "income", "main", "salary"))
        notes.add(Note(5960, "transfer", "main", ""))
        notes.add(Note(5960, "spending", "main", "salary"))
        notes.add(Note(5960, "income", "main", "salary"))
        notes.add(Note(5960, "transfer", "main", ""))
        notes.add(Note(5960, "spending", "main", "salary"))
        notes.add(Note(5960, "income", "main", "salary"))
        notes.add(Note(5960, "transfer", "main", ""))
        notes.add(Note(5960, "spending", "main", "salary"))
        notes.add(Note(5960, "income", "main", "salary"))
        notes.add(Note(5960, "transfer", "main", ""))
        notes.add(Note(5960, "spending", "main", "salary"))
        notes.add(Note(5960, "income", "main", "salary"))
        notes.add(Note(5960, "transfer", "main", ""))
        notes.add(Note(5960, "spending", "main", "salary"))
        notes.add(Note(5960, "income", "main", "salary"))
        notes.add(Note(5960, "transfer", "main", ""))
        notes.add(Note(5960, "spending", "main", "salary"))
        notes.add(Note(5960, "income", "main", "salary"))
        notes.add(Note(5960, "transfer", "main", ""))
        notes.add(Note(5960, "spending", "main", "salary"))
        notes.add(Note(5960, "income", "main", "salary"))
        notes.add(Note(5960, "transfer", "main", ""))
        notes.add(Note(5960, "spending", "main", "salary"))
        notes.add(Note(5960, "income", "main", "salary"))
        notes.add(Note(5960, "transfer", "main", ""))
        notes.add(Note(5960, "spending", "main", "salary"))

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = AdapterNotes(notes)
        binding.back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
