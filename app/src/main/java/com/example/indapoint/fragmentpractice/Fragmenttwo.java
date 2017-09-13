package com.example.indapoint.fragmentpractice;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


@TargetApi(Build.VERSION_CODES.KITKAT)
public class Fragmenttwo extends Fragment {

    OnButtonPressListener buttonListener;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = (ViewGroup) inflater.inflate(R.layout.fragment_test1, container,false);
      final EditText fr_et_2=(EditText) view.findViewById(R.id.fr_tv_2);
         Button fr_bt_2=(Button)view.findViewById(R.id.fr_bt_2);

        fr_bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String msg=fr_et_2.getText().toString();
               // buttonListener=(OnButtonPressListener) getActivity();
                buttonListener.onButtonPressed(msg);
            }
        });

        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            buttonListener = (OnButtonPressListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "implement onButtonPressed");
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.e("frag2","resume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("frag2","Pause");

    }


}
