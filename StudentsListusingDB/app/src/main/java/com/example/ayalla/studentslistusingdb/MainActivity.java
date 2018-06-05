package com.example.ayalla.studentslistusingdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_NAME_REQUEST_CODE = 100;
    private ItemRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repository = new ItemRepository(getApplicationContext());
        renderNamesList();
    }

    private void renderNamesList() {
        List<Item> names = repository.getAllNames();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new ItemListActivityAdapter(names));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_NAME_REQUEST_CODE && resultCode == RESULT_OK) {
            String nameAdded = data.getStringExtra("name");
            repository.addItem(new Item(nameAdded));
        }
        renderNamesList();
    }

    public void addName(View view) {
        Intent addIntent = new Intent(this, AddNameActivity.class);
        startActivityForResult(addIntent, ADD_NAME_REQUEST_CODE);
    }

    public void deleteAll(View view) {
        repository.deleteAll();
        renderNamesList();
    }
}
