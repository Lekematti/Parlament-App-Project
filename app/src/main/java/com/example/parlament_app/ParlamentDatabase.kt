package com.example.parlament_app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MemberOfParliament::class], version = 5, exportSchema = false)

abstract class ParlamentDatabase: RoomDatabase() {
    abstract val memberOfParliamentDAO: MemberOfParliamentDAO
    companion object {
        @Volatile
        private var INSTANCE: ParlamentDatabase? = null
        fun getInstance(): ParlamentDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(MyApp.appContext, ParlamentDatabase::class.java,"ops_database")
                        .fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
