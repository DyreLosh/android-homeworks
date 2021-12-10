package com.example.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.app.databinding.FragmentCategoryBinding

class CategoryFragment(private val position: Int) : Fragment() {
    lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        binding.textViewCategory.text = when (position) {
            0 -> getString(R.string.category_work)
            1 -> getString(R.string.category_study)
            2 -> getString(R.string.category_entertainments)
            else -> null
        }
        return binding.root
    }
}
