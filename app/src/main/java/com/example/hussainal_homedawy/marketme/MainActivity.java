package com.example.hussainal_homedawy.marketme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hussainal_homedawy.marketme.manager.MarketMe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Setup the main layout
        setContentView(R.layout.activity_main);

        // Switch to the main layout
        MarketMe.switchToFragment(getFragmentManager(), MainFragment.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
