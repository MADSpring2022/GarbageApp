package com.example.garbageappv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewItemActivity extends AppCompatActivity {

    private Button addNewItem;
    private ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);

        itemsDB = ItemsDB.get(this);
        itemsDB.fillItemsDB();

        addNewItem = findViewById(R.id.addButton);

        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText whatEditTxt = findViewById(R.id.userInputWhat);
                EditText whereEditTxt = findViewById(R.id.userInputWhere);
                String userInputWhat = String.valueOf(whatEditTxt.getText());
                String userInputWhere = String.valueOf(whereEditTxt.getText());
                itemsDB.addItem(userInputWhat, userInputWhere);


                Intent intent = new Intent(AddNewItemActivity.this, ListItemsActivity.class);
                startActivity(intent);


            }
        });
    }
}