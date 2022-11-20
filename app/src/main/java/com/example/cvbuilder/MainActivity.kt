package com.example.cvbuilder

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun signIn(view: View) {
        val spf = getSharedPreferences("login", MODE_PRIVATE)
        val em = spf.getString("email", "no value")
        val pwd = spf.getString("pwd", "no value")
        val email : EditText = findViewById(R.id.email)
        val password : EditText = findViewById(R.id.password)
        if(email.text.toString() == em.toString()
            &&
            password.text.toString() == pwd.toString()
        )
            {
                login(email.text.toString())
            }
            else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show()
            }
    }

    fun createAcct(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun login(email: String) {
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("emailAddress", email)
        startActivity(intent)
    }
}