package com.example.counterapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        checkPositiveValue(0)
    }

    fun addValue(view: View?){
        val valueView = findViewById<TextView>(R.id.valueText)
        val newValue = valueView.text.toString().toInt() + 1
        valueView.text = newValue.toString()
        checkPositiveValue(newValue)
    }

    fun subValue(view: View?){
        val valueView = findViewById<TextView>(R.id.valueText)
        val newValue = valueView.text.toString().toInt() - 1
        valueView.text = newValue.toString()
        checkPositiveValue(newValue)
    }

    fun checkPositiveValue(value : Int){
        val subButton = findViewById<Button>(R.id.subBtn);
        subButton.isEnabled = (value > 0)
        subButton.isClickable = (value > 0)
    }
}