package com.axellinoanggoro.binar_challenge3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.axellinoanggoro.binar_challenge3.databinding.FragmentWordBinding


class WordFragment : Fragment() {
    lateinit var binding: FragmentWordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWordBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var getChar = arguments?.getString("data")

        if (getChar == "A"){
            var listWordData = arrayListOf(
                ListWord("Api"),
                ListWord("Air"),
                ListWord("Angin")
            )

            var wordAdapter = WordAdapter(listWordData)
            binding.rvWord.adapter = wordAdapter
            wordAdapter.onClick = {
                var bundle = Bundle()
                bundle.putString("data", it.word)
            }
        }

        val lmWord = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvWord.layoutManager = lmWord
    }


}