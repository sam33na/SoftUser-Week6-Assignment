package com.sr.studentregister

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    private  lateinit var recyclerView:RecyclerView
    private lateinit var tvAge:TextView
    private lateinit var tvAddress:TextView
    private lateinit var tvName:TextView
    private lateinit var tvGender:TextView
    private lateinit var imgDp:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        recyclerView=findViewById(R.id.recyclerView)
        tvAge=findViewById(R.id.tvAge)
        tvAddress=findViewById(R.id.tvAddress)
        tvName=findViewById(R.id.tvName)
        tvGender=findViewById(R.id.tvGender)
        imgDp=findViewById(R.id.imgDp)

    }
}