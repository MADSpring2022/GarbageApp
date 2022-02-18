package dk.itu.garbage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AddingActivity extends AppCompatActivity {
    //GUI
    private EditText inputWhat, inputWhere;
    private Button addButton;

    //db
    private static ItemsDB itemsDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        //to use db
        itemsDB = ItemsDB.get();


        //associate GUI and id
        inputWhat = findViewById(R.id.what_text);
        inputWhere = findViewById(R.id.where_text);
        addButton = findViewById(R.id.add_new_item);

        addButton.setOnClickListener((View addNewItemBtn) -> {
            String what = inputWhat.getText().toString().trim();
            String where = inputWhere.getText().toString().trim();

            if (what.length() > 0 && where.length() > 0) {
                itemsDB.addItem(what, where);
                inputWhat.setText("");
                inputWhere.setText("");
            } else {
                Toast.makeText(AddingActivity.this, R.string.empty_toast, Toast.LENGTH_LONG).show();
            }
        });




    }
}