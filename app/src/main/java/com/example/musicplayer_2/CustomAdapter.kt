package com.example.musicplayer_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer_2.databinding.ItemListBinding

class CustomAdapter(val array: ArrayList<Track>): RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(track: Track) {
            binding.trackAutor.text = track.autor
            binding.trackName.text = track.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
       return array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(array[position])
    }

}