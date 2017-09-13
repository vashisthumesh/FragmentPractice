package com.example.indapoint.fragmentpractice;

/**
 * Created by indapoint on 1/9/17.
 */

public interface OnButtonPressListener {

    public void onButtonPressed(String msg);


   /* if(getFragmentManager().getBackStackEntryCount() == 0) {
        super.onBackPressed();
    }
    else if(getFragmentManager().getBackStackEntryCount() == 1) {
        moveTaskToBack(false);
    }
    else {
        getFragmentManager().popBackStack();
    }
*/
}
