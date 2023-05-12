package com.example.islami.home_fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.R

class SuraNameAdapter (val items:List<String>): RecyclerView.Adapter<SuraNameAdapter.ViewHolder>(){


    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val suraNameTv= itemView.findViewById<TextView>(R.id.item_sura_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.suraNameTv.text = items[position]
        holder.itemView.setOnClickListener {

            onItemClick?.onSuraNameclick(items[position],position)

        }
    }
    var onItemClick:OnItemClick?=null
    interface OnItemClick {
        fun onSuraNameclick(sura:String, pos:Int)

    }

}