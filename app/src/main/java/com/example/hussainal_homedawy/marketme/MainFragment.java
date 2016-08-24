package com.example.hussainal_homedawy.marketme;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hussainal-homedawy on 16-08-23.
 */
public class MainFragment extends Fragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle onSavedState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }
}
