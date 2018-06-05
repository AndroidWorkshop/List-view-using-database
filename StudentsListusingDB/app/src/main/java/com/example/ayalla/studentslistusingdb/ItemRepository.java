package com.example.ayalla.studentslistusingdb;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

public class ItemRepository {
    private final ItemDatabase db;
    public ItemRepository(Context applicationContext) {
        db = Room.databaseBuilder(applicationContext, ItemDatabase.class, "students_database").
                allowMainThreadQueries().build();
    }

    public void addItem(Item item ){
        db.itemDao().insert(item);
    }


    public List<Item> getAllNames() {
       return db.itemDao().getAll();
    }

    public void deleteAll() {
        db.itemDao().deleteAll();
    }
}
