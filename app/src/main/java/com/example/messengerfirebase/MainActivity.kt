package com.example.messengerfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_button.setOnClickListener{
            performRegister()
        }

        already_hava_account_text_view.setOnClickListener{
            Log.d("MainActivity","Try to show login activity")

            //launch the login activity somehow
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun performRegister(){
        val email = email_edittext_login.text.toString()
        val password = password_edittext_login.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter text email/pw", Toast.LENGTH_LONG).show()
            return
        }

        Log.d("MainActivity","Email is: " + email)
        Log.d("MainAvtivity", "Password: $password")

        //Firebase
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(!it.isSuccessful)return@addOnCompleteListener

                //else if successful
                //Log.d("Main", "Successfully created user with uid: ${it.result.user.uid}")
            }
            .addOnFailureListener{
                Log.d("Main","Failed to create user: ${it.message}")
                Toast.makeText(this,"Filed to create user: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }

    }
