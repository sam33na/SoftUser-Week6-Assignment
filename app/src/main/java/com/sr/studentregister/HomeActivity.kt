package com.sr.studentregister

import android.app.AlertDialog
import android.content.Intent
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
    private  var details=Details()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_register, R.id.navigation_home))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    override fun onBackPressed() {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Logout?")

        builder.setMessage("Do you want to logout?")

        builder.setIcon(android.R.drawable.ic_dialog_info)

        builder.setPositiveButton("YES"){ _, _ ->
            details.setLogin(null)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("msg", "Logged Out")
            startActivity(intent)
        }

        val alert: AlertDialog = builder.create()
        alert.setCancelable(true)
        alert.show()
    }
}