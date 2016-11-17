package com.example.samtrent.ezworkout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class homeActivity extends AppCompatActivity {

    // Database Helper
    databaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        db = new databaseHelper(getApplicationContext());



        Fill_Database fd = new Fill_Database(db);
        fd.fill_Place_Table();
        fd.fill_Workout_List_Table();
        fd.fill_Workout_Table();

        List<Workout_List> home_list = db.query_All_Workout_Lists("Home");
        List<Workout_List> gym_list = db.query_All_Workout_Lists("Gym");
        List<Workout> arm_list = db.query_All_Workouts("Arms");



        for (Workout_List wl : home_list) {
            Button nwB = new Button(this);
            nwB.setText(wl.getMuscleGroup());
            nwB.setId(wl.getId());
            final int index = wl.getId();
            nwB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //go to new activity!
                    startActivity(new Intent(homeActivity.this, workoutListActivity.class));
                }
            });

            Log.i("With Home Query", wl.getId() + ": " + wl.getMuscleGroup() + ", FK " + wl.getFk_place());
        }

        for (Workout_List wl : gym_list) {
            Log.i("With Gym Query", wl.getId() + ": " + wl.getMuscleGroup() + ", FK " + wl.getFk_place());
        }

        for (Workout w : arm_list) {
            Log.i("With Arm Query", w.getId() + ": " + w.getName());
        }



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

        //db.clearDB();
        //db.close();
    }

}
