package dk.itu.garbage;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class UIFragment extends Fragment {

    //GUI
    private Button searchItems, addItem, delItem, listGarbage;
    private EditText item, inputWhat, inputWhere;

    //db
    private ItemsViewModel itemDB;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_u_i, container, false);


        //for the searchItem button
        item = v.findViewById(R.id.search_text);
        //what, where fields for adding
        inputWhat = v.findViewById(R.id.what_text);
        inputWhere = v.findViewById(R.id.where_text);
        //and button for adding
        addItem = v.findViewById(R.id.add_button);
        delItem = v.findViewById(R.id.delete_item_button);
        listGarbage= v.findViewById(R.id.list_button);



        //adding searchItems to ItemsViewModel makes it possible to use searchItems method of ItemsDB
        searchItems = v.findViewById(R.id.search_button);
        searchItems.setOnClickListener((View searchBtn) ->
                item.setText(itemDB.searchItems(item.getText().toString()))
        );


        //assign itemDB the shared data (ItemsViewModel)
        itemDB = new ViewModelProvider(requireActivity()).get(ItemsViewModel.class);

        // if phone is in portrait mode
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            listGarbage.setOnClickListener(view ->
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container_ui,
                                new ListFragment()).commit());
        }

        //add a new item
        addItem.setOnClickListener(view -> {
            String inWhat = inputWhat.getText().toString().trim();
            String inWhere = inputWhere.getText().toString().trim();

            if ((inWhat.length() > 0) && (inWhere.length() > 0)) {
                itemDB.addItem(inWhat, inWhere);
                inputWhat.setText("");
                inputWhere.setText("");
            } else Toast.makeText(getActivity(), R.string.empty_toast, Toast.LENGTH_LONG).show();
        });

        //delete an item
        delItem.setOnClickListener(view -> {
            if (!inputWhat.getText().toString().trim().isEmpty()) {
                itemDB.removeItem(inputWhat.getText().toString());
                Toast.makeText(getActivity(), "Removed "+ inputWhat.getText(),
                        Toast.LENGTH_SHORT).show();
            } else Toast.makeText(getActivity(), R.string.removed, Toast.LENGTH_LONG).show();
        });

        return v;
    }
}