package com.example.indapoint.fragmentpractice;

import android.annotation.TargetApi;
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
import android.widget.TextView;
import android.widget.Toast;


@TargetApi(Build.VERSION_CODES.KITKAT)
public class FragmentOne extends Fragment {
    View view;
    TextView fr_tv_1;
    Button fr_bt_1;
    String message = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_test,container, false);


       fr_bt_1= view.findViewById(R.id.fr_bt_1);
        fr_tv_1= view.findViewById(R.id.fr_tv_1);

        fr_tv_1.setText(message);


        fr_bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Fragmenttwo();
                FragmentManager fragmentManager = getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.test_fragment, fragment);
               // fragmentTransaction.add(R.id.test_fragment,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    void setMessage(String msg){
         Log.e("msg",""+msg);
       this.message=msg;
        Log.e("msg11",""+msg);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("frag1","resume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("frag1","Pause");

    }

}
