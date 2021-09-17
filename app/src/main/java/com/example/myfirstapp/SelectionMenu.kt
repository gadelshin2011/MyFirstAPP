package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myfirstapp.databinding.ActivitySelectionMenuBinding

class SelectionMenu : AppCompatActivity() {
    lateinit var bindingClass: ActivitySelectionMenuBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySelectionMenuBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }



    fun onClickBackMain(view: View){
        finish()

    }







}