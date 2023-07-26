package com.example.musicplayer_2

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

abstract class Swipe() :ItemTouchHelper.SimpleCallback(ItemTouchHelper.DOWN or ItemTouchHelper.UP, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {

        val fromPosition= viewHolder.adapterPosition
        val toPosition= target.adapterPosition
        onItemMove(fromPosition,toPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        onItemSwipeToDelete(viewHolder.adapterPosition)
    }
    abstract  fun onItemSwipeToDelete(position: Int)

    abstract  fun onItemMove(fromPosition: Int, toPosition: Int)
}