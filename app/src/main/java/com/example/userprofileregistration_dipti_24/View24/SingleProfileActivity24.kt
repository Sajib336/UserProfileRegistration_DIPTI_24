package com.example.userprofileregistration_dipti_24.View24


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.userprofileregistration_dipti_24.Model24.Profile24
import com.example.userprofileregistration_dipti_24.R

class SingleProfileActivity24 : AppCompatActivity() {
    private lateinit var argentinaProfile: Profile24
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var dobTextView: TextView
    private lateinit var districtTextView: TextView
    private lateinit var mobileTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_profile24)
        argentinaProfile = intent.getSerializableExtra("USER_PROFILE") as Profile24

        nameTextView = findViewById(R.id.nameTextView)
        emailTextView = findViewById(R.id.emailTextView)
        dobTextView = findViewById(R.id.dobTextView)
        districtTextView = findViewById(R.id.districtTextView)
        mobileTextView = findViewById(R.id.mobileTextView)

        populateFields()
    }

    private fun populateFields() {
        nameTextView.text = argentinaProfile.name
        emailTextView.text = argentinaProfile.email
        dobTextView.text = argentinaProfile.dob
        districtTextView.text = argentinaProfile.district
        mobileTextView.text = argentinaProfile.mobile
    }
}