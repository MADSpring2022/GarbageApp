package dk.itu.garbage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GarbageActivity extends AppCompatActivity {
    //GUI variables
    private Button searchItems, toAddItem;
    private TextView item;

    private ItemsDB itemDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garbage);

        itemDB = new ItemsDB();
        itemDB.fillItemsDB();

        item = findViewById(R.id.input_text);
        searchItems = findViewById(R.id.where_button);

        toAddItem = findViewById(R.id.to_add_item);

        //expression lambda (instead of lambda statement)
        searchItems.setOnClickListener((View searchBtn) ->
            item.setText(itemDB.listItems(item.getText().toString()))
        );

        toAddItem.setOnClickListener((View toAddBtn) -> {
            Intent intent = new Intent(GarbageActivity.this, AddingActivity.class);
            startActivity(intent);
                });



    }


}