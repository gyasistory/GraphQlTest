package com.gyasistory.androids.graphqltest.features.character.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gyasistory.androids.graphqltest.FeedResultsQuery
import com.gyasistory.androids.graphqltest.databinding.ItemCharacterBinding

class CharacterListAdapter : RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder>() {
    var characters: List<FeedResultsQuery.Result> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class CharacterViewHolder(val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.binding.character = characters[position]
    }

    override fun getItemCount() = characters.size
}