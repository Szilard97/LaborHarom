package com.example.laborharom;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface MyDao {

    @Insert
    public void addStudent(Students students);

}
