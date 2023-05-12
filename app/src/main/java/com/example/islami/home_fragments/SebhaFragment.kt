package com.example.islami.home_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.islami.R

class SebhaFragment : Fragment() {

    lateinit var image:ImageView
    lateinit var phase:TextView
    lateinit var counterTv :TextView
    var counter:Int=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image= view.findViewById(R.id.body_sebha)
        phase= view.findViewById(R.id.phase_tv)
        counterTv= view.findViewById(R.id.counter_tv)
        counterTv.text="$counter"
        image.setOnClickListener {
            onSebhaClicled()
        }

    }

    private fun onSebhaClicled() {

         image.rotation = image.rotation+5
        counter++
        counterTv.text="$counter"


        if (counter==34){
            if (phase.text=="سبحان الله"){
                phase.text="الحمد لله"
                counter = 0
                counterTv.text="$counter"
            }
            else if(phase.text=="الحمد لله"){
                phase.text="الله اكبر"
                counter=0
                counterTv.text="$counter"
            }
            else if (phase.text=="الله اكبر"){
                phase.text="لا الله الا الله وحده لا شريك له,له الملك,وله الحمد,وهو على كل شى قدير"
                counter=0
                counterTv.text="$counter"
            }
            else if (phase.text=="لا الله الا الله وحده لا شريك له,له الملك,وله الحمد,وهو على كل شى قدير"){
                phase.text="سبحان الله"
                counter=0
                counterTv.text="$counter"
            }
        }
    }

}