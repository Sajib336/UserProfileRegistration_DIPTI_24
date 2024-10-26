package com.example.userprofileregistration_dipti_24.Dao24

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.userprofileregistration_dipti_24.Model24.Profile24

@Dao
interface ProfileDao24 {
    @Insert
    suspend fun insert(argentinaProfile: Profile24)

    @Update
    suspend fun update(argentinaProfile: Profile24)

    @Delete
    suspend fun delete(argentinaProfile: Profile24)

    @Query("SELECT * FROM profile")
    fun getAllUserProfiles(): LiveData<List<Profile24>>
}