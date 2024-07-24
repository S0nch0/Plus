package com.example.plus

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val tvCount = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)

        Count.value = sharedPreferences.getInt("count", 0)
        tvCount.text = Count.value.toString()

        button.setOnClickListener {
            Count.value++
            tvCount.text = Count.value.toString()
            saveCount()
        }
    }

    private fun saveCount() {
        with(sharedPreferences.edit()) {
            putInt("count", Count.value)
            apply()
        }
    }
}