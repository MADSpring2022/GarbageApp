package dk.itu.garbage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GarbageActivity extends AppCompatActivity {
    //GUI moved to Fragments

    //Using Fragments
    private FragmentManager fm;
    Fragment fragmentUI, fragmentList;

    //db
    private static ItemsDB itemDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garbage);

        ItemsDB.initialize(GarbageActivity.this);
        itemDB = ItemsDB.get();
        fm = getSupportFragmentManager();
        setUpFragments();

    }

    private void setUpFragments() {
        fragmentUI = fm.findFragmentById(R.id.container_ui);
        fragmentUI = fm.findFragmentById(R.id.container_list);

        if ((fragmentUI == null) && (fragmentList == null)) {
            fragmentUI = new UIFragment();
            fragmentList = new ListFragment();
            fm.beginTransaction()
                    .add(R.id.container_ui, fragmentUI)
                    .add(R.id.container_list, fragmentList)
                    .commit();
        }
    }


}