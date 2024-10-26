package com.example.userprofileregistration_dipti_24.View24


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.userprofileregistration_dipti_24.R

class MainActivity24 : AppCompatActivity() {
    private lateinit var listButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main24)

        listButton = findViewById(R.id.profileListBtn)

        listButton.setOnClickListener {
            // Start LoadingActivity instead of ProfileListActivity
            val intent = Intent(this,LodingActivity24::class.java)
            intent.putExtra("TARGET_ACTIVITY", "com.example.userprofileregistration_dipti_24.View24.ProfileListActivity24")
            startActivity(intent)
            finish() // Finish MainActivity24 so the user can't return to it
        }


    }


}