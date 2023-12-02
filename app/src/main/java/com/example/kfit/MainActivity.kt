package com.example.kfit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kfit.views.AuthentificationFragment
import com.example.kfit.views.MainMenuFragment
import java.net.Authenticator

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.mainFragmentContainer,AuthentificationFragment()).commit()
    }

}