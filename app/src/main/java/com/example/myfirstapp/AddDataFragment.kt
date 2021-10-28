package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfirstapp.databinding.FragmentAddDataBinding
import com.example.myfirstapp.databinding.FragmentHomeBinding

class AddDataFragment : Fragment() {
    lateinit var binding: FragmentAddDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddDataBinding.inflate(inflater)
        return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.SaveNewData.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

    }


    companion object {
        fun newInstance() = AddDataFragment()
    }


}