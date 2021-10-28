package com.example.myfirstapp

import android.app.ActionBar
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.myfirstapp.databinding.DialogFragmentLogautBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class HomeBottomFragment : BottomSheetDialogFragment() {


    lateinit var binding: DialogFragmentLogautBinding
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogFragmentLogautBinding.inflate(inflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    companion object {
        fun newInstance() = HomeBottomFragment()
    }


    }


