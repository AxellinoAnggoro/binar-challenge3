package com.axellinoanggoro.binar_challenge3

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class WordAdapter ( var listWord : ArrayList<ListWord>) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    var onClick : ((ListWord) -> Unit)? = null

    class WordViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        var word = view.findViewById<Button>(R.id.wordBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordAdapter.WordViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordAdapter.WordViewHolder, position: Int) {
        val searchWord = listWord[position].word
        holder.word.text = searchWord
        holder.word.setOnClickListener {
            val move = Intent(Intent.ACTION_VIEW)
            move.data = Uri.parse("https://www.google.com/search?q=$searchWord")
            it.context.startActivity(move)
        }
    }

    override fun getItemCount(): Int {
        return listWord.size
    }
}