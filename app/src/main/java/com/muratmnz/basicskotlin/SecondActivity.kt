package com.muratmnz.basicskotlin

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.muratmnz.basicskotlin.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //create binding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //get data from another activity with Intent
        var item: String = intent.getStringExtra("data").toString()
        binding.listItem.text = item

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

        //add text item inside Linearlayout with view binding.
        binding.btnAdd.setOnClickListener {
            val text = binding.editTextTextPersonName.text
            val itemText = TextView(this)
            itemText.setText(text)
            itemText.setLayoutParams(
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )

            binding.linearLayout.addView(itemText)

        }
    }

    //Back button
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}