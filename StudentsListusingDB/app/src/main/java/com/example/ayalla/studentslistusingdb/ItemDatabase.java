package com.example.ayalla.studentslistusingdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {Item.class}, version = 1)
public abstract class ItemDatabase extends RoomDatabase {
    public abstract ItemDao itemDao();
}
