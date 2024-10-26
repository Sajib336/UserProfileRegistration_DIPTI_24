package com.example.userprofileregistration_dipti_24.View24

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.userprofileregistration_dipti_24.Model24.Profile24
import com.example.userprofileregistration_dipti_24.R
import com.example.userprofileregistration_dipti_24.ViewModel24.ProfileViewActivity24


class AddProfileActivity24 : AppCompatActivity() {
    private lateinit var profileViewModel24: ProfileViewActivity24
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_profile24)

        profileViewModel24 = ViewModelProvider(this).get(ProfileViewActivity24::class.java)

        val nameEditText = findViewById<EditText>(R.id.profileNameEt)
        val emailEditText = findViewById<EditText>(R.id.profileEmailEt)
        val dobEditText = findViewById<EditText>(R.id.profileDOBEt)
        val districtEditText = findViewById<EditText>(R.id.profileDistrictEt)
        val mobileEditText = findViewById<EditText>(R.id.profilemobileEt)

        findViewById<Button>(R.id.addBtn).setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val dob = dobEditText.text.toString()
            val district = districtEditText.text.toString()
            val mobile = mobileEditText.text.toString()

            val userProfile = Profile24(name = name, email = email, dob = dob, district = district, mobile = mobile)
            profileViewModel24.insertUserProfile(userProfile)

            finish()
        }
    }
}