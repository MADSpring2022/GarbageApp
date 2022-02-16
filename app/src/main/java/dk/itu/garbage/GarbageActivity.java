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

        ItemsDB.initialize(GarbageActivity.this);
        itemDB = ItemsDB.get();

        item = findViewById(R.id.input_text);
        searchItems = findViewById(R.id.where_button);

        toAddItem = findViewById(R.id.to_add_item);

        //expression lambda (instead of lambda statement)
        searchItems.setOnClickListener((View searchBtn) ->
            item.setText(itemDB.searchItems(item.getText().toString()))
        );

        //intent on click starting new activity AddingActivity
        toAddItem.setOnClickListener((View toAddBtn) -> {
            Intent intent = new Intent(GarbageActivity.this, AddingActivity.class);
            startActivity(intent);
                });



    }


}