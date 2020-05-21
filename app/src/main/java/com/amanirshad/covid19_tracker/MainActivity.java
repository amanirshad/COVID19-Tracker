package com.amanirshad.covid19_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class MainActivity extends AppCompatActivity {

    TextView confirmedCases, recoveredCases, deathCases, countryName;

    SliderLayout sliderLayout;

    ImageButton searchButton;

    EditText countryNameEditText;

    TextView seeDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setScrollTimeInSec(3);
        setSliderView();

        confirmedCases = findViewById(R.id.confirmed_no);
        recoveredCases = findViewById(R.id.revovered_no);
        deathCases = findViewById(R.id.deaths_no);

        searchButton = findViewById(R.id.searchButton);
        countryNameEditText = findViewById(R.id.countryToBeSearched);

        seeDetails = findViewById(R.id.btn_see_details);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                assert connectivityManager != null;
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                        new searchData.execute();
                } else {
                    Snackbar snackbar = Snackbar.make(view, "No internet Connection", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });
    }


    private void setSliderView() {
        for (int i = 0; i < 3; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.picture_01);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.picture_02);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.picture_03);
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.FIT_CENTER);

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }

    public class searchData extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {

        }
    }

}

