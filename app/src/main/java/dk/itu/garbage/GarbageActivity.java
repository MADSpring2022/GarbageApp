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

    private ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garbage);

        itemsDB = new ItemsDB();
        itemsDB.fillItemsDB();

        item = findViewById(R.id.input_text);
        listItems = findViewById(R.id.where_button);

        listItems.setOnClickListener((View v) -> {
            item.setText(itemsDB.listItems(item.getText().toString()));
        });



    }


}