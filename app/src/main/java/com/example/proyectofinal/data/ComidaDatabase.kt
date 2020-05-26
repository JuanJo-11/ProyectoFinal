package com.example.proyectofinal.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Comida::class), version = 1, exportSchema = false)
abstract class ComidaDatabase: RoomDatabase() {

    abstract fun comidaDao(): ComidaDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ComidaDatabase? = null

        fun getDatabase(context: Context): ComidaDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ComidaDatabase::class.java,
                    "comida_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}