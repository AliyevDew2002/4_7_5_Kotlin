package com.example.a4_7_5_kotlin

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.a4_7_5_kotlin.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view:View=binding.root
        setContentView(view)
        initViews()
    }

    fun initViews() {
        binding.btHome.setOnClickListener(View.OnClickListener {
            val text: String = binding.etHome.getText().toString()
            val spannable = SpannableString(text)
            val pattern = Pattern.compile("#\\w+")
            val matcher = pattern.matcher(spannable)
            while (matcher.find()) {
                val start = matcher.start()
                val end = matcher.end()
                spannable.setSpan(
                    ForegroundColorSpan(Color.GREEN),
                    start,
                    end,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            binding.tvClone.setText(spannable)
        })
    }

}