package dk.itu.garbage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GarbageActivity extends AppCompatActivity {
    //GUI variables
    private Button listItems;
    private TextView item;

    private ItemsDB itemDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garbage);

        itemDB = new ItemsDB();
        itemDB.fillItemsDB();

        item = findViewById(R.id.input_text);
        listItems = findViewById(R.id.where_button);

        //expression lambda (instead of lambda statement)
        listItems.setOnClickListener((View v) ->
            item.setText(itemDB.listItems(item.getText().toString()))
        );



    }


}