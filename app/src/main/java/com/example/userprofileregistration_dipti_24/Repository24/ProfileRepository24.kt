package com.example.userprofileregistration_dipti_24.Repository24

import androidx.lifecycle.LiveData
import com.example.userprofileregistration_dipti_24.Model24.Profile24
import com.example.userprofileregistration_dipti_24.Dao24.ProfileDao24

class ProfileRepository24 (private val userProfileDao24: ProfileDao24) {
    fun getUserProfiles(): LiveData<List<Profile24>> {
        return userProfileDao24.getAllUserProfiles()
    }

    suspend fun insert(userProfile: Profile24) {
        userProfileDao24.insert(userProfile)
    }

    suspend fun update(userProfile: Profile24) {
        userProfileDao24.update(userProfile)
    }

    suspend fun delete(userProfile: Profile24) {
        userProfileDao24.delete(userProfile)
    }
}