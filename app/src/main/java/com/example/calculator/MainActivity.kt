package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, SecondPage::class.java)

        val bundle = Bundle()

        val plusButton = findViewById<Button>(R.id.plusButton)
        plusButton.setOnClickListener {
            if (checkForNumbers()) {
                intent.putExtra("data", add(bundle))
                startActivity(intent)
                finish()
            }
        }

        val minusButton = findViewById<Button>(R.id.minusButton)
        minusButton.setOnClickListener {
            if (checkForNumbers()) {

                intent.putExtra("data", minus(bundle))
                startActivity(intent)
                finish()
            }
        }

        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        multiplyButton.setOnClickListener {

            if (checkForNumbers()) {

                intent.putExtra("data", multiply(bundle))
                startActivity(intent)
                finish()
            }

        }

        val divideButton = findViewById<Button>(R.id.divideButton)
        divideButton.setOnClickListener {
            if (checkForNumbers()) {

                intent.putExtra("data", divide(bundle))
                startActivity(intent)
                finish()
            }

        }

    }

    private fun add(bundle: Bundle): Bundle {
        val numbers = getNumbers(bundle)
        val num1 = numbers.getInt("num1")
        val num2 = numbers.getInt("num2")
        numbers.putChar("action", '+')
        val result = num1 + num2
        numbers.putString("result", result.toString())
        return numbers
    }

    private fun minus(bundle: Bundle): Bundle {
        val numbers = getNumbers(bundle)
        val num1 = numbers.getInt("num1")
        val num2 = numbers.getInt("num2")
        numbers.putChar("action", '-')
        val result = num1 - num2
        numbers.putString("result", result.toString())
        return numbers
    }

    private fun multiply(bundle: Bundle): Bundle {
        val numbers = getNumbers(bundle)
        val num1 = numbers.getInt("num1")
        val num2 = numbers.getInt("num2")
        numbers.putChar("action", '*')
        val result = num1 * num2
        numbers.putString("result", result.toString())
        return numbers
    }

    private fun divide(bundle: Bundle): Bundle {
        val numbers = getNumbers(bundle)
        val num1 = numbers.getInt("num1")
        val num2 = numbers.getInt("num2")
        numbers.putChar("action", '/')
        val result = num1 / num2.toFloat()
        numbers.putString("result", result.toString())
        return numbers
    }

    fun getNumbers(bundle: Bundle): Bundle {
        val number1 = findViewById<TextView>(R.id.number1).text
        val number2 = findViewById<TextView>(R.id.number2).text
        if (number1.isEmpty() || number2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            exitProcess(500)
        } else {
            bundle.putInt("num1", number1.toString().toInt())
            bundle.putInt("num2", number2.toString().toInt())
            return bundle
        }

    }

    fun checkForNumbers(): Boolean {
        val number1 = findViewById<TextView>(R.id.number1).text
        val number2 = findViewById<TextView>(R.id.number2).text
        return if (number1.isEmpty() || number2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            false
        } else true
    }


}


