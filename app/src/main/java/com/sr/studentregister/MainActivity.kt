package com.sr.studentregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        }
    }
}