package com.example.islami.ahadeth_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import com.example.islami.R
import com.example.islami.home_fragments.AhadethFragment
import java.io.BufferedReader
import java.io.InputStreamReader

class AhadethDetailsActivity : AppCompatActivity() {
    lateinit var ahadethFragment: AhadethFragment
    var hadethContent = ""
    lateinit var hadethNametextView: TextView
    lateinit var hadethContenttextView: TextView
    lateinit var backArrow: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ahadeth_details)
        val contentN = intent.getStringExtra("content")
        hadethNametextView = findViewById(R.id.hadeth_nameTv)
        hadethContenttextView = findViewById(R.id.hadeth_content)
        backArrow = findViewById(R.id.backArrowHadeth)
        backArrow.setOnClickListener {
            finish()
        }
        hadethContenttextView.movementMethod = ScrollingMovementMethod()
        hadethContenttextView.text=contentN
    }

}