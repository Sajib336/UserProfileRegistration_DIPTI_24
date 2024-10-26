package com.example.userprofileregistration_dipti_24.View24


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofileregistration_dipti_24.Adapter24.ProfileAdapter24
import com.example.userprofileregistration_dipti_24.Model24.Profile24
import com.example.userprofileregistration_dipti_24.R
import com.example.userprofileregistration_dipti_24.ViewModel24.ProfileViewActivity24
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfileListActivity24 : AppCompatActivity() {

    private lateinit var profileViewModel24: ProfileViewActivity24
    private lateinit var profileAdapter24: ProfileAdapter24

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_list24)

        profileViewModel24 = ViewModelProvider(this).get(ProfileViewActivity24::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.profileRecyclerView)
        profileAdapter24 = ProfileAdapter24()

        recyclerView.adapter = profileAdapter24
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe profiles from ViewModel
        profileViewModel24.getUserProfiles().observe(this, Observer { profiles ->
            if (profiles.isEmpty()) {
                // Show a Toast message if there are no profiles
                Toast.makeText(this, "No profiles available", Toast.LENGTH_SHORT).show()
            } else {
                profileAdapter24.submitList(profiles)
            }
        })

        // Set item click listener for details
        profileAdapter24.setOnItemClickListener { profile24 ->
            val intent = Intent(this@ProfileListActivity24, SingleProfileActivity24::class.java)
            intent.putExtra("USER_PROFILE", profile24)
            startActivity(intent)
        }

        // Set delete click listener
        profileAdapter24.setOnDeleteClickListener { userProfile ->
            showDeleteConfirmationDialog(userProfile)
        }

        // Set update click listener
        profileAdapter24.setOnUpdateClickListener { userProfile ->
            val intent = Intent(this@ProfileListActivity24, UpdateProfileActivity24::class.java)
            intent.putExtra("USER_PROFILE", userProfile)
            startActivity(intent)
        }

        // Add profile button click listener
        findViewById<FloatingActionButton>(R.id.addProfileBtn).setOnClickListener {
            val intent = Intent(this@ProfileListActivity24, AddProfileActivity24::class.java)
            startActivity(intent)
        }
    }

    // Show delete confirmation dialog
    private fun showDeleteConfirmationDialog(profile: Profile24) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete Profile")
        builder.setMessage("Are you sure you want to delete this profile?")

        builder.setPositiveButton("Yes") { dialog, which ->
            profileViewModel24.deleteUserProfile(profile)  // Delete the profile
            dialog.dismiss()
        }

        builder.setNegativeButton("No") { dialog, which ->
            dialog.dismiss()  // Cancel delete operation
        }

        val dialog = builder.create()
        dialog.show()
    }
}