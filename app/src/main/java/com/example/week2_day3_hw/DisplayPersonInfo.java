package com.example.week2_day3_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayPersonInfo extends AppCompatActivity {
    //textviews
    TextView tvFirstName;
    TextView tvLastName;
    TextView tvStreetAddress;
    TextView tvCity;
    TextView tvState;
    TextView tvZip;
    //sharedpreferences
    SharedPreferences sharedPerson;
    //string to get the massive string from shared preferences
    String rawInfoPerson;
    //string array for each string after the split
    String[] infoPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sharedPerson gets the previous shared preferences
        sharedPerson= getSharedPreferences("shared_person", MODE_PRIVATE);

        //sets content view
        setContentView(R.layout.activity_display_person_info);

        //binds the views to vars
        tvFirstName = findViewById(R.id.tvFirstName);
        tvLastName = findViewById(R.id.tvLastName);
        tvStreetAddress = findViewById(R.id.tvAddress);
        tvCity = findViewById(R.id.tvCity);
        tvState = findViewById(R.id.tvState);
        tvZip = findViewById(R.id.tvZip);

        //raw info person gets the sharedpreference string
        rawInfoPerson = sharedPerson.getString("input", "No input");
        //infoPerson array takes in the sharedpreferences strings by using a comma as a delimiter
        infoPerson = rawInfoPerson.split(",");
        //sets the textViews to the appropriate index of the string based on the order of the text entered and split
        tvFirstName.setText(infoPerson[0]);
        tvLastName.setText(infoPerson[1]);
        tvStreetAddress.setText(infoPerson[2]);
        tvCity.setText(infoPerson[3]);
        tvState.setText(infoPerson[4]);
        tvZip.setText(infoPerson[5]);
    }
}
