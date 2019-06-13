package com.example.week2_day3_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //initializes all variables for sharedPref and for person's edit text info
    SharedPreferences sharedPerson;
    EditText etFirstName;
    EditText etLastName;
    EditText etStreetAddress;
    EditText etCity;
    EditText etState;
    EditText etZip;
    String personInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //binding the correct views to the variables for them
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etStreetAddress = findViewById(R.id.etStreetAddress);
        etCity = findViewById(R.id.etCity);
        etState = findViewById(R.id.etState);
        etZip = findViewById(R.id.etZip);
        //sets the sharedPerson to get the shared preferences from previous app use
        sharedPerson = getSharedPreferences("shared_person", MODE_PRIVATE);

    }

    public void onClick(View view) {
        //if the edit text views are all full, store to sharedpref
        if (!etFirstName.getText().toString().isEmpty() && !etLastName.getText().toString().isEmpty() && !etStreetAddress.getText().toString().isEmpty()
        && !etCity.getText().toString().isEmpty() && !etState.getText().toString().isEmpty() && !etZip.getText().toString().isEmpty()) {
            //personInformation is a string to store all the strings in one with a delimiter to be split later
            personInformation = etFirstName.getText().toString() + " , " + etLastName.getText().toString() + " , " +
                    etStreetAddress.getText().toString() + " , " + etCity.getText().toString() + " , " + etState.getText().toString()
                    + " , " + etZip.getText().toString() + " , ";

            //stores the personInformation string to shared preferences
            storeToSharedPreferences(personInformation);
        }
        //starts the DisplayPersonInfo activity
        startActivity(new Intent(this, DisplayPersonInfo.class));
    }

    private void storeToSharedPreferences(String info) {
        //initializes the editor and allows editing
        SharedPreferences.Editor editPerson = sharedPerson.edit();
        //puts the string into the editor of the SharePreferences
        editPerson.putString("input", info);
        //apply the editors
        editPerson.apply();

    }

}