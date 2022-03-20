package dk.itu.garbage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.res.Configuration;
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
    private final static ItemsViewModel itemDB = new ItemsViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garbage);

        //ItemsDB.initialize(GarbageActivity.this);
        //itemDB = ItemsDB.get();

        //ItemsDB itemDB = new ViewModelProvider(this).get(ItemsDB.class);

        fm = getSupportFragmentManager();
        setUpFragments();

    }

    private void setUpFragments() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {        fragmentUI = fm.findFragmentById(R.id.container_ui);
            fragmentUI = fm.findFragmentById(R.id.container_ui);
            fragmentList = fm.findFragmentById(R.id.container_list);

            if ((fragmentUI == null) && (fragmentList == null)) {
                fragmentUI = new UIFragment();
                fragmentList = new ListFragment();
                fm.beginTransaction()
                        .add(R.id.container_ui, fragmentUI)
                        .add(R.id.container_list, fragmentList)
                        .commit();
            } else {
                // for portrait
                if (fragmentUI == null) {
                    fragmentUI = new UIFragment();
                    fm.beginTransaction()
                            .add(R.id.container_ui, fragmentUI)
                            .commit();
                }

            }


            }


    }


}