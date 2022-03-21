package dk.itu.garbage;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ListFragment extends Fragment {
    //private static ItemsDB itemsDB;
    private TextView listGarbage;
    private Button backButton; // to show when in portrait mode

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //itemsDB = ItemsDB.get();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_list, container, false);
        listGarbage = v.findViewById(R.id.list_item);
        backButton = v.findViewById((R.id.back_button));

        ItemsViewModel itemsDB= new ViewModelProvider(requireActivity()).get(ItemsViewModel.class);
        itemsDB.getValue().observe(getViewLifecycleOwner(), items -> listGarbage.setText(items.listItems()));
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            backButton.setOnClickListener(view ->
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container_ui,
                                    new UIFragment()).commit());
        }

        return v;
    }
}