package com.example.virginmoney_fragmentversion.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.virginmoney_fragmentversion.Model.PeopleItem
import com.example.virginmoney_fragmentversion.databinding.PeopleLayoutBinding

class PeopleAdapter: RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {
    inner class PeopleViewHolder(
        val binding: PeopleLayoutBinding
    ) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<PeopleItem>(){
        override fun areItemsTheSame(oldItem: PeopleItem, newItem: PeopleItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PeopleItem, newItem: PeopleItem): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    fun submitList(list: List<PeopleItem>) = differ.submitList(list)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        return PeopleViewHolder(PeopleLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val currPeople = differ.currentList[position]

        holder.binding.apply {
            firstname.text = currPeople.firstName
            lastname.text = currPeople.lastName
            Job.text = currPeople.jobtitle
            val image = currPeople.avatar
            Avatar.load(image){
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount() = differ.currentList.size
}