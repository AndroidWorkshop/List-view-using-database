package com.example.ayalla.studentslistusingdb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ItemDao {

    @Insert
    void insert(Item item);

    @Query("SELECT * FROM ITEM" )
    List<Item> getAll();

    @Query("DELETE FROM ITEM")
    void deleteAll();
}
