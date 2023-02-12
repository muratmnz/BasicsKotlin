package com.muratmnz.basicskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import com.muratmnz.basicskotlin.databinding.ActivitySecondBinding
import com.muratmnz.basicskotlin.databinding.ActivityThirdBinding
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.webView.webViewClient = WebViewClient()

        binding.webView.loadUrl("https://developer.android.com/docs")

        var settings: WebSettings = binding.webView.settings
        settings.javaScriptEnabled = true
        settings.setSupportZoom(true)

    }
}