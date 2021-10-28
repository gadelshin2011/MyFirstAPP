package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.asLiveData
import com.example.myfirstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    private var launcher: ActivityResultLauncher<Intent>? = null
    lateinit var UserLogin: String
    lateinit var UserPassword: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        getDataActivityRegistration()
    }

    fun onClickDataVerification(view: View) {
        getDataTextView()
        launcher?.launch(Intent(this, SelectionMenu::class.java))
             bindingClass.twInfo.text = ""
                clearTextView()

     //   when (comparedValue()) {
//
        //            true -> {
//                launcher?.launch(Intent(this, SelectionMenu::class.java))
//                bindingClass.twInfo.text = ""
//                clearTextView()
//            }
 //           false -> falseData()
     //   }
    }


    fun onClickRegistration(view: View) {
        launcher?.launch(Intent(this, Registration::class.java))
        bindingClass.twInfo.text = ""
        clearTextView()
    }

    private fun getDataTextView() {
        UserLogin = bindingClass.editTextPersonName.text.toString()
        UserPassword = bindingClass.editTextPersonPassword.text.toString()
    }

    private fun comparedValue(): Boolean {
        return UserLogin == getString(R.string.login) && UserPassword == getString(R.string.password)
   }

    private fun falseData() {
        bindingClass.twInfo.text = getString(R.string.falseINFO)
        bindingClass.buttonRegistration.visibility = View.VISIBLE
    }

    private fun clearTextView() {
        bindingClass.editTextPersonName.text.clear()
        bindingClass.editTextPersonPassword.text.clear()
    }


    private fun getDataActivityRegistration() {
        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    var resultLogin = result.data?.getStringExtra(R.string.keyRegLog.toString())
                    var resultPassword = result.data?.getStringExtra(R.string.keyRegPass.toString())
                    bindingClass.twInfo.text = ""
                    bindingClass.buttonRegistration.visibility = View.GONE
                    bindingClass.editTextPersonName.setText(resultLogin)
                    bindingClass.editTextPersonPassword.setText(resultPassword)
                }

            }
    }

}