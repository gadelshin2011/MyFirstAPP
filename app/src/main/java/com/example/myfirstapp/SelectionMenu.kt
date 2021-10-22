package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.myfirstapp.databinding.ActivitySelectionMenuBinding

class SelectionMenu : AppCompatActivity() {
    lateinit var bindingClass: ActivitySelectionMenuBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySelectionMenuBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        openFragmentPassword()
        functionNavigationMenu()
        startActionBar()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return true
    }


    private fun functionNavigationMenu() {
        //bindingClass.bottomNavigationMenu.selectedItemId = R.id.windows_password
        bindingClass.bottomNavigationMenu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.windows_password -> {
                    Toast.makeText(this, "Password", Toast.LENGTH_SHORT).show()
                    openFragmentPassword()

                }
                R.id.windows_home -> {
                    Toast.makeText(this, "home", Toast.LENGTH_SHORT).show()
                    openFragmentHome()
                }
            }
            true
        }

    }


    private fun openFragmentPassword() {
        supportFragmentManager
            .beginTransaction().replace(R.id.FragmentAccount, passwordFragment.newInstance())
            .commit()
    }

    private fun openFragmentHome() {
        supportFragmentManager
            .beginTransaction().replace(R.id.FragmentAccount, HomeFragment.newInstance()).commit()
    }

    private fun startActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }


}