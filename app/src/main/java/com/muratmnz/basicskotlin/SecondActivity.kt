package com.muratmnz.basicskotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    lateinit var btnNextPage: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //initialize btnNext with view
        btnNextPage = findViewById(R.id.btnNextPage)

        //navigate between activities
        btnNextPage.setOnClickListener {
            val intentSecond = Intent(this, ThirdActivity::class.java)
            startActivity(intentSecond)
            finish()
        }

    }
}