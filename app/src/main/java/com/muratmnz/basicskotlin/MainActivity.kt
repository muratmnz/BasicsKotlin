package com.muratmnz.basicskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()

        //initialize btnNext with view
        btnNext = findViewById(R.id.btnNext)

        //navigate between activities
        btnNext.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val data = "Hello world"
            // passing data to activity
            intent.putExtra("data", data)
            startActivity(intent)
        }

    }
}