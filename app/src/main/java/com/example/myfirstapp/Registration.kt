package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.example.myfirstapp.databinding.ActivityRegistrationBinding
import kotlinx.coroutines.launch

class Registration : AppCompatActivity() {
    private lateinit var bindingClass: ActivityRegistrationBinding
  private lateinit var userManager: UserManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        // Здесь мы получаем ссылку на наш класс userManager
        userManager = UserManager(applicationContext)


        // сохраняем и получаем данные, введенные пользователем
        bindingClass.buttonRegistration.setOnClickListener {
            storeUser()
        }

        /**
        * Эта функция извлекает сохраненные данные
        * как только они хранятся и даже
        * после закрытия и перезапуска приложения
        */

        observeData()

    }

    private fun observeData() {

        /**
         * получение и обновление логина
        * каждый раз при изменении возраста пользователя это будет наблюдать userLoginFlow
         */

        userManager.userLoginFlow.asLiveData().observe(this) { login ->
            login?.let {
                bindingClass.tvLogin.text = "Login:$login"
            }
        }
        userManager.userPasswordFlow.asLiveData().observe(this) { password ->
            password?.let {
                bindingClass.tvPassword.text = "Password:$password"
            }
        }


    }


    /**
    * эта функция сохраняет данные в
    * настройки, когда мы нажимаем кнопку сохранения
    */

    private fun storeUser() {
        val login = bindingClass.twEditLogin.text.toString()
        val password = bindingClass.twEditPassword.text.toString()


        /**
        * хранить значения
        * Наш класс - это функция приостановки, она запускается только внутри области сопрограммы.
        */


        lifecycleScope.launch {
            userManager.storeUserData(login, password)
            Toast.makeText(
                this@Registration,
                "Пользователь сохранен",
                Toast.LENGTH_SHORT
            ).show()

            // после сохранения нашего пользователя
            // нам нужно очистить входные данные в нашем тексте редактирования

            bindingClass.twEditLogin.text.clear()
            bindingClass.twEditPassword.text.clear()
        }


    }


    // fun onClickBackMain(view: View){

    /**intent.putExtra(R.string.keyReg.toString(), bindingClass.twEditLogin.text.toString())
     *intent.putExtra(R.string.keyReg1.toString(), bindingClass.twEditPassword.text.toString())
     *setResult(RESULT_OK, intent)
     *finish()*/

}









