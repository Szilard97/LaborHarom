package com.example.laborharom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = (Students.class), version = 1)
public abstract class MyAddDatabase extends RoomDatabase {

    public abstract MyDao myDao( );
}
