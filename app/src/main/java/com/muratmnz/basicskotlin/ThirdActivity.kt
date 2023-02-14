package com.muratmnz.basicskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.muratmnz.basicskotlin.databinding.ActivitySecondBinding
import com.muratmnz.basicskotlin.databinding.ActivityThirdBinding
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    lateinit var binding: ActivityThirdBinding

    //Mutable list - changeble list.
    val pageList: MutableList<String> = mutableListOf("1", "2", "3", "4")
    private lateinit var category: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.webView.webViewClient = WebViewClient()

        binding.webView.loadUrl("https://developer.android.com/docs")

        binding.btnBack.setOnClickListener {
            val intentThird = Intent(this,SecondActivity::class.java)
            startActivity(intentThird)
            finish()
        }


        var settings: WebSettings = binding.webView.settings
        settings.javaScriptEnabled = true
        settings.setSupportZoom(true)

        category = binding.spCategory

        //adapter connect with list
        val adapter =
            ArrayAdapter(this@ThirdActivity, android.R.layout.simple_spinner_item, pageList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        category.adapter = adapter

    }
}