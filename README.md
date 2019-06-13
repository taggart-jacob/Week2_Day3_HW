# Week2_Day3_HW

Problem:

Create an activity with an edittext for each item listed below. On a button click, save the values of the items listed below to shared preferences. Then open another activity and display each item saved in the MainActivity to SEPARATE textviews.
Hint: this is week 1 day 3 homework, just refactored to use shared preferences :) 
First Name
Last Name
Street Address
City
State
Zip

Solution:

MainActivity

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


DisplayPersonInfo


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


![Screen Shot 2019-06-13 at 1 15 26 PM](https://user-images.githubusercontent.com/51377398/59453475-fa693b00-8ddd-11e9-96c0-6924e106271e.png)
![Screen Shot 2019-06-13 at 1 16 14 PM](https://user-images.githubusercontent.com/51377398/59453476-fa693b00-8ddd-11e9-89b2-a9ae8617b376.png)
![Screen Shot 2019-06-13 at 1 16 05 PM](https://user-images.githubusercontent.com/51377398/59453477-fb01d180-8ddd-11e9-9523-dbdb41195ccb.png)
