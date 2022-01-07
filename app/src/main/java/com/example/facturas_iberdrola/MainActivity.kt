package com.example.facturas_iberdrola

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import org.florescu.android.rangeseekbar.RangeSeekBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrowIcon = findViewById<ImageView>(R.id.arrow_icon)
        val filterIcon = findViewById<ImageView>(R.id.filter_icon)
        val toolbarTitle = findViewById<TextView>(R.id.toolbar_title)



        filterIcon.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
        }



    }
}