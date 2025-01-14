package com.maya2002yagan.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.maya2002yagan.homework2.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {
    private lateinit var binding : FragmentHomePageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        binding.btnNext.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_homePageFragment_to_firstPageFragment)
        }
        return binding.root
    }
}