package com.example.virginmoney_fragmentversion.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney_fragmentversion.Model.RoomsItem
import com.example.virginmoney_fragmentversion.databinding.RoomLayoutBinding

class RoomAdapter: RecyclerView.Adapter<RoomAdapter.RoomViewHolder>(){
    inner class RoomViewHolder(
        val binding: RoomLayoutBinding
    ):
        RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<RoomsItem>(){
        override fun areItemsTheSame(oldItem: RoomsItem, newItem: RoomsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RoomsItem, newItem: RoomsItem): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this,diffCallBack)

    fun submitList(list: List<RoomsItem>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        return RoomViewHolder(
            RoomLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ))
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val currRoom = differ.currentList[position]

        holder.binding.apply {
            textView4.text = currRoom.id
            textView5.text = currRoom.isOccupied.toString()
            textView6.text = currRoom.maxOccupancy.toString()
        }
    }
    override fun getItemCount() = differ.currentList.size
}