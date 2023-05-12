package com.example.islami.sura_details

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.R
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.streams.toList

class SuraDetailsActivity : AppCompatActivity() {
    var suraContent =""
    lateinit var suraNametextView:TextView
    lateinit var suraContenttextView:TextView
    lateinit var backArrow: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        val suraName = intent.getStringExtra("sura_name")
        val fileName = intent.getStringExtra("file_name")
        suraNametextView=findViewById(R.id.sura_nameTv)
        suraContenttextView=findViewById(R.id.suraContent)
        backArrow = findViewById(R.id.backArrowSura)
        backArrow.setOnClickListener {
            finish()
        }
        suraContenttextView.movementMethod=ScrollingMovementMethod()
        suraNametextView.text=suraName
        readSuraFile(fileName?:"")
        suraContenttextView.text=suraContent

    }
    fun readSuraFile(fileName: String) {
        val reader = BufferedReader(
            InputStreamReader(assets.open(fileName))
        )
        val lines = reader.lines().toList()
        for (i in 0.. lines.size-1){
            val line =lines.get(i)
            suraContent += line+"(${i+1})"
        }


    }
}