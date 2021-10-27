package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.myfirstapp.databinding.FragmentPasswordBinding
import android.R
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction


class passwordFragment : Fragment() {
    lateinit var binding: FragmentPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPasswordBinding.inflate(inflater)
        return binding.root





    }


    companion object {
        @JvmStatic
        fun newInstance() = passwordFragment()
    }






}




