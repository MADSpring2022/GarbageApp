package com.example.garbageappv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ListItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        TextView tv = findViewById(R.id.listItemsTv);
        String items = ItemsDB.get(ListItemsActivity.this).listItems();
        tv.setText(items);
    }
}