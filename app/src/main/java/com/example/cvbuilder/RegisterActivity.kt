package com.example.cvbuilder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun register(view: View) {
        val spf = getSharedPreferences("login", Context.MODE_PRIVATE)
        val spe = spf.edit()
        val fn : EditText = findViewById<EditText>(R.id.firstName)
        val ln : EditText = findViewById<EditText>(R.id.lastName)
        val email : EditText = findViewById<EditText>(R.id.email)
        val pwd : EditText = findViewById<EditText>(R.id.password)
        spe.putString("first", fn.text.toString())
        spe.putString("last", ln.text.toString())
        spe.putString("email", email.text.toString())
        spe.putString("pwd", pwd.text.toString())
        spe.apply()
        if(fn != null && ln != null && email !=null && pwd != null) {
            Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}