package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myfirstapp.databinding.ActivityRegistrationBinding

class Registration : AppCompatActivity() {
    lateinit var bindingClass: ActivityRegistrationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

    }

    fun onClickBackMain(view: View){

        intent.putExtra(R.string.keyReg.toString(), bindingClass.twEditLogin.text.toString())
        intent.putExtra(R.string.keyReg1.toString(), bindingClass.twEditPassword.text.toString())
        setResult(RESULT_OK, intent)
        finish()

    }






}