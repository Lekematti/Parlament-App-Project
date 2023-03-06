// 2.3.2023
// Leo Koskimäki
// 2201352

package com.example.parlament_app

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MemberOfParliament::class], version = 5, exportSchema = false)

abstract class ParlamentDatabase() : RoomDatabase() {
    abstract val memberOfParliamentDAO: MemberOfParliamentDAO
    companion object {
        @Volatile
        private var INSTANCE: ParlamentDatabase? = null
        fun getInstance(): ParlamentDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(MyApp.appContext, ParlamentDatabase::class.java,"parliament_database")
                        .fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
