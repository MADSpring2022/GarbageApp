package dk.itu.garbage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class UIFragment extends Fragment {

    private Button searchItems;
    private EditText item;

    private ItemsDB itemDB;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemDB = ItemsDB.get();

        /*
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garbage);

        ItemsDB.initialize(GarbageActivity.this);
        itemDB = ItemsDB.get();

        item = findViewById(R.id.input_text);
        searchItems = findViewById(R.id.where_button);

        //expression lambda (instead of lambda statement)
        searchItems.setOnClickListener((View searchBtn) ->
                item.setText(itemDB.searchItems(item.getText().toString()))
        );
        */

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_u_i, container, false);

        item = v.findViewById(R.id.input_text);


        searchItems = v.findViewById(R.id.where_button);
        searchItems.setOnClickListener((View searchBtn) ->
                item.setText(itemDB.searchItems(item.getText().toString()))
        );

        return v;
    }
}