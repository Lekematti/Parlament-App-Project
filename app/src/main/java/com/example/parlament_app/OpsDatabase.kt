package com.example.parlament_app

import androidx.room.Database

@Database(entities = [OpsLogEntry::class], version = 3, exportSchema = false)

abstract class OpsDatabase: RoomDatabase() {
    abstract val OpsLogDAO: OpsLogDAO
    companion object {
        @Volatile
        private var INSTANCE: OpsDatabase? = null
        fun getInstance(): OpsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(MyApp.appContext, OpsDatabase::class.java,"ops_database")
                        .fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
