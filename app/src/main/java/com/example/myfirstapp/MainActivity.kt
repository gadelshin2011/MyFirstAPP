package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myfirstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    lateinit var textLogin:String
    lateinit var textPassword: String







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)




    }

    fun onClickDataVerification(view: View){
       pullData()
       when(compadeValue(textLogin,textPassword)){

            true -> openPicturePlus()

            false ->openPictureMinus()
        }





    }

    fun pullData(){
        textLogin = bindingClass.editTextPersonName.text.toString()
        textPassword= bindingClass.editTextPersonPasswordd.text.toString()

        }

    private fun compadeValue(textLogin :String, textPassword : String ):Boolean {
         return textLogin == "admin" && textPassword == "admin"

    }

    fun openPicturePlus(){
        bindingClass.showPicture.visibility=View.VISIBLE
        bindingClass.showPicture.setImageResource(R.drawable.plus)

    }
    fun openPictureMinus(){
        bindingClass.showPicture.visibility=View.VISIBLE
        bindingClass.showPicture.setImageResource(R.drawable.minus)

    }

}