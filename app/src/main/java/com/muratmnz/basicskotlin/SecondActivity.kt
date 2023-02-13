package com.muratmnz.basicskotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.muratmnz.basicskotlin.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    lateinit var toggle: ActionBarDrawerToggle

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
        //apply binding with function
        binding.apply {
            toggle = ActionBarDrawerToggle(
                this@SecondActivity,
                drawerLayout,
                R.string.open,
                R.string.close
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            //navigation drawer includes menu items.
            binding.navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.firstItem -> {
                        Toast.makeText(
                            this@SecondActivity,
                            "First Item Clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    R.id.secondtItem -> {
                        Toast.makeText(
                            this@SecondActivity,
                            "Second Item Clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    R.id.thirdItem -> {
                        Toast.makeText(
                            this@SecondActivity,
                            "third Item Clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                true
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            true
        }
        return super.onOptionsItemSelected(item)
    }

//    //Back button
//    override fun onSupportNavigateUp(): Boolean {
//        onBackPressed()
//        return true
//    }
}