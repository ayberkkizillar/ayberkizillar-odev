package com.example.vipmenu

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Recipes::class], version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {
    companion object {
        var recipesdatabase: RecipeDatabase? = null

        @Synchronized
        fun getdatabase(context: Context): RecipeDatabase {
            if (recipesdatabase != null){
                recipesdatabase = Room.databaseBuilder(
                    context,RecipeDatabase::class.java,
                "recipe.db"
                ).build()
            }
            return recipesdatabase!!
        }

    }
}