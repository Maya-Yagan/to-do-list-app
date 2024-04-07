package com.maya2002yagan.homework2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maya2002yagan.homework2.databinding.ListItemBinding

class ToDoAdapter(private val list : MutableList<Item>): RecyclerView.Adapter<ToDoAdapter.MyListViewHolder>() {
    inner class MyListViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(adapterList: Item){
            binding.tvTitle.text = adapterList.title
            binding.tvDescription.text = adapterList.description
            binding.btnDelete.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    list.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoAdapter.MyListViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyListViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ToDoAdapter.MyListViewHolder, position: Int) {
        holder.bind(list[position])
    }
}