package com.example.islami.home_fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.Hadeth
import com.example.islami.R

class AhadethTitlesRecyclerAdapter (val items:List<Hadeth>) :RecyclerView.Adapter<AhadethTitlesRecyclerAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val hadethTv= itemView.findViewById<TextView>(R.id.item_ahadeth_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ahadeth_title,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.hadethTv.text = items[position].title
        holder.itemView.setOnClickListener {
            onItemClick?.onHadethNameclick(items[position],position)

        }

    }

    var onItemClick:OnItemClick?=null
    interface OnItemClick {
        fun onHadethNameclick(hadeth: Hadeth, pos:Int)


    }


}