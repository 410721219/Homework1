package com.example.homework1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.homework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.transferButton.setOnClickListener{
            convert(it)
        }
    }

    private fun convert(view: View){
        binding.apply{
            var ftemper: Double = (temperInput.text.toString().toDouble() - 32) * 5 / 9
            outputTemper.text = ftemper.toString()
        }
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.transferButton.windowToken, 0)
    }
}