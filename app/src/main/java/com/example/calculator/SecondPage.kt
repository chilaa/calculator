package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.math.log
import kotlin.reflect.typeOf

class SecondPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        val bundle:Bundle? = intent.getBundleExtra("data")
        val text = findViewById<TextView>(R.id.result_text)
        val num1 = bundle?.getInt("num1")
        val num2 = bundle?.getInt("num2")
        val action = bundle?.getChar("action")
        val result = bundle?.getString("result")
        val string = "$num1 $action $num2 = $result"
        text.text = string


    }
}