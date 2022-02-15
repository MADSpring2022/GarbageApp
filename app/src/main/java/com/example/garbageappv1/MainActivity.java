package com.example.garbageappv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

//define activity Java class
public class MainActivity extends AppCompatActivity {

    //MainActivity has to be declared in Manifest!

    private Button where_button;
    private ItemDB itemDB;

    //onCreate initializes UI/ activity
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        //(Resource.isLayout.XMLfile)
        setContentView(R.layout.activity_main);

        itemDB = new ItemDB();
        itemDB.fillItemsDB();
        //view is basic building block of UI
        where_button = findViewById(R.id.where_button);

        where_button.setOnClickListener(view -> {
            //what the button does?
            EditText editText = findViewById(R.id.userInput);
            String userInput = String.valueOf(editText.getText());
            String matchResult = itemDB.matcher(userInput);
            editText.setText("should be placed in:"+" "+ matchResult);
        });
    }


    }