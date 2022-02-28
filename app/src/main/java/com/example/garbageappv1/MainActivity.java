package com.example.garbageappv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button where_button;
    private Button addButton;
    private ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemsDB = ItemsDB.get(this);
        itemsDB.fillItemsDB();

        where_button = findViewById(R.id.where_button);
        addButton = findViewById(R.id.addButton);


        where_button.setOnClickListener( v -> {
            // what the button does?
            EditText editText = findViewById(R.id.userInput);
            String userInput = String.valueOf(editText.getText());
            String matchResult = itemsDB.matcher(userInput);
            editText.setText("should be placed in:" + " " + matchResult);
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewItemActivity.class);
                startActivity(intent);

            }
        });

    }
}