package com.kassandra.apps.flutter.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class FragmentsContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_container);

        InputFragment inputFragment = new InputFragment();
        ResultFragment resultFragment = new ResultFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.flTopFragmentContaienr, inputFragment).commit();
        fragmentManager.beginTransaction().add(R.id.flBottomFragmentContaienr,resultFragment).commit();
    }
}