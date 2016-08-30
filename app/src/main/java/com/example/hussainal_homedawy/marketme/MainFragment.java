package com.example.hussainal_homedawy.marketme;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hussainal_homedawy.marketme.manager.MarketMe;
import com.example.hussainal_homedawy.marketme.manager.TextManager;
import com.example.hussainal_homedawy.marketme.object.Client;
import com.example.hussainal_homedawy.marketme.object.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hussainal-homedawy on 16-08-23.
 */
public class MainFragment extends Fragment {
    private Button broadcastTextMessages;
    private Button surveyTextMessages;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSavedState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // Locate all controls
        broadcastTextMessages = (Button) view.findViewById(R.id.btn_broadcast);
        surveyTextMessages = (Button) view.findViewById(R.id.btn_survey);

        // Setup all controls
        broadcastTextMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MarketMe.switchToFragment(getFragmentManager(), BroadcastFragment.class);
            }
        });

        surveyTextMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }
}
