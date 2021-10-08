package com.example.myfirstapp

import android.content.Intent
import android.content.pm.LauncherActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myfirstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    lateinit var textLogin:String
    lateinit var textPassword: String
    private var launcher: ActivityResultLauncher<Intent>? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {

            }


        }
    }

    fun onClickOpenActivityRegistration(view: View){
       launcher?.launch(Intent(this@MainActivity,Registration::class.java ))
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
        textPassword= bindingClass.editTextPersonPassword.text.toString()

        }

    private fun compadeValue(textLogin :String, textPassword : String ):Boolean {
         return textLogin == getString(R.string.login) && textPassword == getString(R.string.password)

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