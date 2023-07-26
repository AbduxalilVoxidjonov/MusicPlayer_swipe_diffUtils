package com.example.musicplayer_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayer_2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Collections

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mutableList = ArrayList<Track>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listAdd()
        val customAdapter = CustomAdapter(mutableList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.apply {
            adapter = customAdapter

        }

        val touchSwipe =ItemTouchHelper(object: Swipe(){
            override fun onItemSwipeToDelete(position: Int) {
                val removedTitle = mutableList.removeAt(position)
                customAdapter.notifyItemRemoved(position)
                Snackbar.make(
                    this@MainActivity,
                    binding.recyclerView,
                    "$removedTitle is going to be removed",
                    Snackbar.LENGTH_SHORT
                )
                    .setAction("Tiklash") {
                        mutableList.add(position, removedTitle)
                        customAdapter.notifyItemInserted(position)
                    }.show()
            }
            override fun onItemMove(fromPosition: Int, toPosition: Int) {
                Collections.swap(mutableList,fromPosition,toPosition)
                customAdapter.notifyItemMoved(fromPosition,toPosition)
            }
        })


        touchSwipe.attachToRecyclerView(binding.recyclerView)
    }
    fun listAdd(){
        mutableList.add(Track("Eminem","Godzilla"))
        mutableList.add(Track("Eminem","Godzilla"))
        mutableList.add(Track("Eminem","Godzilla"))
        mutableList.add(Track("Eminem","Godzilla"))
        mutableList.add(Track("Eminem","Godzilla"))
        mutableList.add(Track("Eminem","Godzilla"))
        mutableList.add(Track("Eminem","Godzilla"))
        mutableList.add(Track("Eminem","Godzilla"))
        mutableList.add(Track("Eminem","Godzilla"))
    }
}