package com.example.mvvm_training.dao

import androidx.annotation.RequiresPermission
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvm_training.models.ToDo

@Dao
interface ToDoDao {

    @Insert
    fun insertToDo(ToDo : ToDo)

    @Delete
    fun delete(ToDo: ToDo)

    @Update
    fun updateToDo(ToDo: ToDo)

    @Query("SELECT * FROM todo")
    fun getAllToDos() : LiveData<List<ToDo>>

}