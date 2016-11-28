package com.example.samtrent.ezworkout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;


public class workoutListActivity extends AppCompatActivity {

    databaseHelper db;
    int workout_Group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list2);

        db = new databaseHelper(getApplicationContext());
        workout_Group = getIntent().getExtras().getInt("Group");

        List<Workout> workout_list = db.query_All_Workouts(workout_Group);

        for (Workout w : workout_list) {
            add_Workout_Button(w);
            //Log.i("With Home Query", w.getId() + ": " + w.getName() + ", FK " + w.getFk_muscleGroup());
        }
    }

    public void add_Workout_Button(Workout w) {
        LinearLayout workouts = (LinearLayout) findViewById(R.id.llWorkouts);
        Button b = new Button(this);

        b.setOnClickListener(workoutOnClickListener);
        b.setText(w.getName());
        b.setTag(w.getId());
        b.setId(w.getId());

        workouts.addView(b);
    }



    private View.OnClickListener workoutOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Button imgBtn = (Button) v;

            //tell what view we want to move to...
            Intent i = new Intent(workoutListActivity.this, workoutDisplayActivity.class);

            //pass data we want to transfer to the next activity...
            i.putExtra("Workout", v.getId());

            //segue to new activity!
            startActivity(i);
        }
    };

}

