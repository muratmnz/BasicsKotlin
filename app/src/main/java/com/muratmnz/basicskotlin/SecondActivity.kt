package com.muratmnz.basicskotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.muratmnz.basicskotlin.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //create binding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //navigate  between activities with View binding
        binding.btnNextPage.setOnClickListener {
            val intentSecond = Intent(this, ThirdActivity::class.java)
            startActivity(intentSecond)
        }

        binding.btnPrevPage.setOnClickListener {
            val intentPrev = Intent(this, MainActivity::class.java)
            startActivity(intentPrev)
        }

        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

    }

    //Back button
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}