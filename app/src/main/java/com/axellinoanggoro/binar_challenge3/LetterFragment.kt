package com.axellinoanggoro.binar_challenge3

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.axellinoanggoro.binar_challenge3.databinding.FragmentLetterBinding

class LetterFragment : Fragment() {

    lateinit var binding: FragmentLetterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLetterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listLetterData = arrayListOf(
            ListLetter("A"),
            ListLetter("B"),
            ListLetter("C"),
            ListLetter("D"),
            ListLetter("E"),
            ListLetter("F"),
            ListLetter("G"),
            ListLetter("H"),
            ListLetter("I"),
            ListLetter("J"),
            ListLetter("K"),
            ListLetter("L"),
        )

        val letterAdapter = LetterAdapter(listLetterData)
        val lm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.rvLetter.layoutManager = lm
        binding.rvLetter.adapter = letterAdapter

        letterAdapter.onClick = {
            var bundle = Bundle()
            bundle.putString("data", it)
            findNavController().navigate(R.id.action_letterFragment_to_wordFragment, bundle)
        }
    }

}