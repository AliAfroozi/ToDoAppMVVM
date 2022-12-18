package com.example.mvvm_training.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm_training.dao.ToDoDao
import com.example.mvvm_training.models.ToDo

@Database(entities = [ToDo::class], version = 1)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun todoDao(): ToDoDao
    companion object {
        private  var instance: ToDoDatabase? = null
    }

    suspend fun getInstance(context: Context): ToDoDatabase {
        if (instance == null) {
            instance = Room.databaseBuilder(
                context, ToDoDatabase::class.java, "todo.db")
                .fallbackToDestructiveMigration().build()
        }
        return instance as ToDoDatabase
    }

}