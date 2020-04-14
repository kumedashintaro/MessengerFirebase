package com.example.messengerfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        register_button.setOnClickListener{

            val email = email_edittext.text.toString()
            val password = password_edittext.text.toString()

            Log.d("MainActivity","Email is: " + email)
            Log.d("MainAvtivity", "Password: $password")

        }

        already_hava_account_text_view.setOnClickListener{
            Log.d("MainActivity","Try to show login activity")
        }


    }
    }
