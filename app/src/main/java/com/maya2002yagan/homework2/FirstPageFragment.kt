package com.maya2002yagan.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.maya2002yagan.homework2.databinding.FragmentFirstPageBinding

class FirstPageFragment : Fragment() {
    private lateinit var binding : FragmentFirstPageBinding
    private lateinit var myAdapter : ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val myList = mutableListOf<Item>()
        binding.btnAdd.setOnClickListener {
            val title = binding.etTitle.text
            val description = binding.etDescription.text
            if(title.isNullOrBlank() || description.isNullOrBlank())
                Snackbar.make(it,"Fill all the blanks", Snackbar.LENGTH_SHORT).show()
            else
                myList.add(Item(title.toString(), description.toString()))
            binding.etTitle.text = null
            binding.etDescription.text = null
            myAdapter.notifyDataSetChanged()
        }
        myAdapter = ToDoAdapter(myList)
        binding.recyclerview.adapter = myAdapter
    }
}