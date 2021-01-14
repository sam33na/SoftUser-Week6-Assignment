package com.sr.studentregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    var usr:String="admin"
    var pw:String="admin"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.etUsr)
        password = findViewById(R.id.etPw)
        login = findViewById(R.id.btnLogin)

        login.setOnClickListener {
            var username=username.text.toString()
            var password=password.text.toString()
            nullCheck()
            if(username==usr && password==pw)
            {
                Toast.makeText(this,"Login Successfull", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this, "Invalid loign", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun nullCheck()
    {
        when {
            TextUtils.isEmpty(username.text) -> {
                username.error = "Please fill username"
                username.requestFocus()
            }
            TextUtils.isEmpty(password.text) -> {
                password.error = "Please fill password"
                password.requestFocus()
            }
        }
    }
}