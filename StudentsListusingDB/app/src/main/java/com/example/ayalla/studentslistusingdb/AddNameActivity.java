package com.example.ayalla.studentslistusingdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);
    }

    public void saveName(View view){
        EditText name = (EditText) findViewById(R.id.name);
        String nameAdded = name.getText().toString();
        if(nameAdded.isEmpty()) {
            setResult(RESULT_CANCELED);
            finish();
        }
        Intent resultIntent = new Intent();
        resultIntent.putExtra("name",nameAdded);
        setResult(RESULT_OK,resultIntent);
        finish();
    }

}
