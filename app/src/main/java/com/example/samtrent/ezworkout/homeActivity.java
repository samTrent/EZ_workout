package com.example.samtrent.ezworkout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //setting up our button to be "clickable"
        ImageButton armGymButton = (ImageButton) findViewById(R.id.armGymButton);


        //what happens when we click the button...
        armGymButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //go to new activity!
                startActivity(new Intent(homeActivity.this, workoutListActivity.class));



            }
        });

    }








}
