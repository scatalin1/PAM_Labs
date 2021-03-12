package com.example.pam1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)

        val intent  = intent
        val name = intent.getStringExtra("Name")
        val result = findViewById<TextView>(R.id.result)
        result.text = "Welcome, "+name

        val goodbye = findViewById<EditText>(R.id.end_text)
        val byeBtn = findViewById<Button>(R.id.button2)
        byeBtn.setOnClickListener {
            val bye = goodbye.text.toString()
            val intent2 = Intent(this@SecondActivity2, MainActivity::class.java)
            intent2.putExtra("Text", bye)
            startActivity(intent2)
        }

    }
}