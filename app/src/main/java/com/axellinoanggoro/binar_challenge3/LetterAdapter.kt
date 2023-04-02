package com.axellinoanggoro.binar_challenge3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter (var listLetter: ArrayList<ListLetter>)  : RecyclerView.Adapter<LetterAdapter.ViewHolder>(){

    var onClick : ((ListLetter) -> Unit)? = null

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        var letter = view.findViewById<Button>(R.id.letterBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_letter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: LetterAdapter.ViewHolder, position: Int) {
        holder.letter.text = listLetter[position].letter.toString()
        holder.letter.setOnClickListener {
            onClick?.invoke(listLetter[position])
        }
    }

    override fun getItemCount(): Int {
        return listLetter.size
    }
}