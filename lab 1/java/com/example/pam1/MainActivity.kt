package com.example.pam1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent3 = intent
        val bye = intent3.getStringExtra("Text")
        val byeText = findViewById<TextView>(R.id.byeText)
        byeText.text = bye

        val username = findViewById<EditText>(R.id.edit_text)
        val saveBtn = findViewById<Button>(R.id.button)
        saveBtn.setOnClickListener {
            val name = username.text.toString()
            val intent = Intent(this@MainActivity, SecondActivity2::class.java)
            intent.putExtra("Name", name)
            startActivity(intent)
        }
    }
}