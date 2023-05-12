package com.example.islami.home_fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.Hadeth
import com.example.islami.ahadeth_details.AhadethDetailsActivity
import com.example.islami.databinding.FragmentAhadethBinding
import com.example.islami.home_fragments.adapters.AhadethTitlesRecyclerAdapter

class AhadethFragment : Fragment() {

     var ahadethTitlesRecyclerAdapter: AhadethTitlesRecyclerAdapter? = null
    lateinit var viewBinding: FragmentAhadethBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentAhadethBinding.inflate(inflater, container, false)
        return viewBinding.root
    }
    lateinit var adapter: AhadethTitlesRecyclerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readAhadethFile()
        adapter = AhadethTitlesRecyclerAdapter(allAhadeth)
        viewBinding.hadethRecyclerview.adapter = adapter
        ahadethTitlesRecyclerAdapter?.onItemClick = object : AhadethTitlesRecyclerAdapter.OnItemClick{
            override fun onHadethNameclick(hadeth: Hadeth, pos: Int) {
                val intent = Intent(requireActivity(), AhadethDetailsActivity::class.java)
                intent.putExtra("content","${hadeth}.txt")
                startActivity(intent)
            }
        }
    }
    val allAhadeth = mutableListOf<Hadeth>()
    fun readAhadethFile() {
        val fileContent = activity?.assets?.open("ahadeth .txt")?.bufferedReader().use {
            it?.readText()
        }
        if (fileContent == null) return
        val ahadethContent = fileContent.trim().split("#")
        ahadethContent.forEach {
            val title = it.trim().substringBefore('\n')
            val content = it.trim().substringAfter('\n')
            val hadeth = Hadeth(title, content)
            allAhadeth.add(hadeth)
        }
    }

}