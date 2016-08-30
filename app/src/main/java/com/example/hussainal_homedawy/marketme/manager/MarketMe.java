package com.example.hussainal_homedawy.marketme.manager;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;

import com.example.hussainal_homedawy.marketme.R;

public class MarketMe {
    public static void switchToFragment(FragmentManager fragmentManager, Class fragment) {
        try {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, (Fragment) fragment.newInstance(), fragment.getName());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } catch (Exception ex) {
            Log.d("switchToFragment %s", ex.getMessage());
        }
    }
}
