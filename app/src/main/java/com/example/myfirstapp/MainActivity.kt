package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myfirstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    private var launcher: ActivityResultLauncher<Intent>? = null
    lateinit var textLogin:String
    lateinit var textPassword: String




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result:ActivityResult ->
            if(result.resultCode == RESULT_OK){
                var resultLogin = result.data?.getStringExtra(R.string.keyReg.toString())
                var resultPassword = result.data?.getStringExtra(R.string.keyReg1.toString())
                bindingClass.twInfo.text = "$resultLogin && $resultPassword"

        }

        }


    }

    fun onClickDataVerification(view: View){
       pullData()
       when(comparedValue(textLogin,textPassword)){
            true -> {
                launcher?.launch(Intent(this,SelectionMenu::class.java))
                bindingClass.twInfo.text = ""
                bindingClass.showPicture.visibility= View.INVISIBLE

            }

            false ->falseData()
       }




    }

    fun onClickRegistration(view: View){
        launcher?.launch(Intent(this,Registration::class.java))
        }


    fun pullData(){
        textLogin = bindingClass.editTextPersonName.text.toString()
        textPassword= bindingClass.editTextPersonPassword.text.toString()

        }

    private fun comparedValue(textLogin :String, textPassword : String ):Boolean {
         return textLogin == getString(R.string.login) && textPassword == getString(R.string.password)

    }

    private fun openPicturePlus(){
        bindingClass.showPicture.visibility=View.VISIBLE
        bindingClass.showPicture.setImageResource(R.drawable.plus)
    }
    private fun openPictureMinus(){
        bindingClass.showPicture.visibility=View.VISIBLE
        bindingClass.showPicture.setImageResource(R.drawable.minus)
    }
    private fun trueData(){
        bindingClass.buttonRegistration.visibility = View.GONE
        openPicturePlus()

    }
    private fun falseData(){
        bindingClass.twInfo.text = getString(R.string.falseINFO);
        bindingClass.buttonRegistration.visibility = View.VISIBLE;
        openPictureMinus()
    }

}