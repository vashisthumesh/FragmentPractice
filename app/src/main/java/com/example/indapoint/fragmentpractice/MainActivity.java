package com.example.indapoint.fragmentpractice;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity implements OnButtonPressListener{

    ViewGroup view;
    FragmentOne fragmentone;

    Fragmenttwo fragmenttwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmenttwo = new Fragmenttwo();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fragmentone = new FragmentOne();
        ft.replace(R.id.test_fragment, fragmentone);
        ft.addToBackStack(null);
        ft.commit();
    }


    @Override
    public void onButtonPressed(String msg) {
       // FragmentOne testFragment1 = new FragmentOne();
        FragmentManager fm1 = getFragmentManager();
        FragmentTransaction ft1 = fm1.beginTransaction();
        ft1.replace(R.id.test_fragment, fragmentone);
        //ft1.add(R.id.test_fragment, fragmentone);

        ft1.commit();

        fragmentone.setMessage(msg);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("MainActivity","resume");


    }

    @Override
    public void onBackPressed(){
        FragmentManager fm = getFragmentManager();
        if(getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }
        else if(getFragmentManager().getBackStackEntryCount() == 1) {
            moveTaskToBack(false);
        }
        else {
            getFragmentManager().popBackStack();
        }
      /*  if(getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }

        else {
            getFragmentManager().popBackStack();
        }*/
    }
}
