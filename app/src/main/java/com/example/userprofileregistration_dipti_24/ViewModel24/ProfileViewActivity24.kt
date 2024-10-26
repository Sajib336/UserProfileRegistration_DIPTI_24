package com.example.userprofileregistration_dipti_24.ViewModel24

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.userprofileregistration_dipti_24.Data24.UserDatabase24
import com.example.userprofileregistration_dipti_24.Model24.Profile24
import com.example.userprofileregistration_dipti_24.Repository24.ProfileRepository24
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewActivity24(application: Application) : AndroidViewModel(application) {
    private val repository24: ProfileRepository24
    init {
        val argentinaProfileDao = UserDatabase24.getDatabase(application).userProfileDao()
        repository24 = ProfileRepository24(argentinaProfileDao)
    }

    fun getUserProfiles(): LiveData<List<Profile24>> {
        return repository24.getUserProfiles()
    }

    fun insertUserProfile(profile: Profile24) {
        viewModelScope.launch(Dispatchers.IO) {
            repository24.insert(profile)
        }
    }

    fun updateUserProfile(profile: Profile24) {
        viewModelScope.launch(Dispatchers.IO) {
            repository24.update(profile)
        }
    }

    fun deleteUserProfile(profile: Profile24) {
        viewModelScope.launch(Dispatchers.IO) {
            repository24.delete(profile)
        }
    }
}