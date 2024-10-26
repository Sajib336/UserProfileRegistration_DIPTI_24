package com.example.userprofileregistration_dipti_24.Data24


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.userprofileregistration_dipti_24.Model24.Profile24
import com.example.userprofileregistration_dipti_24.Dao24.ProfileDao24

@Database(entities = [Profile24::class], version = 1)
abstract class UserDatabase24: RoomDatabase() {
    abstract fun userProfileDao(): ProfileDao24

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase24? = null

        fun getDatabase(context: Context): UserDatabase24 {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase24::class.java,
                    "user_profile_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}