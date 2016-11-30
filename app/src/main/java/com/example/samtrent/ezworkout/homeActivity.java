package com.example.samtrent.ezworkout;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

public class homeActivity extends AppCompatActivity {

    databaseHelper db;
    public ListView mainListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*  A database helper for querying
        *   and inserting data
         */
        db = new databaseHelper(getApplicationContext());

        Fill_Database fd = new Fill_Database(db);
        fd.fill_Place_Table();
        fd.fill_Workout_List_Table();
        fd.fill_Workout_Table();


        /*
        *   Query the my workouts table for
        *   every favorite workout and add
        *   a button for each of them
         */
        List<Workout> my_fav_list = db.query_All_My_Workouts();
        if (my_fav_list.size() != 0) {
            for (Workout w : my_fav_list) {
                add_My_Workout_Button(w);
            }
        }

        /*
        *   Query the workout list table for
        *   each home workout group and add
        *   a button for each of them
         */
        List<Workout_List> home_list = db.query_All_Workout_Lists("Home");
        for (Workout_List wl : home_list) {
            add_Home_Button(wl);
        }

        /*
        *   Query the workout list table for
        *   each gym workout group and add
        *   a button for each of them
         */
        List<Workout_List> gym_list = db.query_All_Workout_Lists("Gym");
        for (Workout_List wl : gym_list) {
            add_Gym_Button(wl);
        }

    }



    /*
    *   Add each button for every
    *   workout in the my workouts
    *   table
     */
    public void add_My_Workout_Button(Workout w) {
        LinearLayout l_Fav = (LinearLayout) findViewById(R.id.favLayout);

        ImageButton ib = new ImageButton(homeActivity.this);
        ib.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
        ib.setOnClickListener(straightToWorkoutOnClickListener);
        ib.setTag(w.getId());
        ib.setId(w.getId());

        l_Fav.addView(ib);
    }

    /*
    *   Add each button for every
    *   home workout group in the
    *   workout list table
     */
    public void add_Home_Button(Workout_List wl) {
        LinearLayout l_Home = (LinearLayout) findViewById(R.id.homeLayout);
        String icon = wl.getIcon();
        int id = this.getResources().getIdentifier(icon, "drawable", this.getPackageName());

        ImageButton ib = new ImageButton(homeActivity.this);
        ib.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
        ib.setOnClickListener(trialOnClickListener);
        ib.setTag(wl.getId());
        ib.setId(wl.getId());
        ib.setImageResource(id);

        l_Home.addView(ib);
    }

    /*
    *   Add each button for every
    *   gym workout group in the
    *   workout list table
     */
    public void add_Gym_Button(Workout_List wl) {
        LinearLayout l_Gym = (LinearLayout) findViewById(R.id.gymLayout);
        String icon = wl.getIcon();
        int id = this.getResources().getIdentifier(icon, "drawable", this.getPackageName());

        ImageButton ib = new ImageButton(homeActivity.this);
        ib.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
        ib.setOnClickListener(trialOnClickListener);
        ib.setTag(wl.getId());
        ib.setId(wl.getId());
        ib.setImageResource(id);

        l_Gym.addView(ib);
    }

    /*
    *   OnClickListener for the home and
    *   gym workout buttons
     */
    private View.OnClickListener trialOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            ImageButton imgBtn = (ImageButton) v;

            Intent intent = new Intent(homeActivity.this, workoutListActivity.class);
            intent.putExtra("Group", v.getId());

            startActivity(intent);
        }
    };

    /*
    *   OnClickListener for each favorite
    *   workout button
     */
    private View.OnClickListener straightToWorkoutOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            ImageButton imgBtn = (ImageButton) v;

            Intent intent = new Intent(homeActivity.this, workoutDisplayActivity.class);
            intent.putExtra("Workout", v.getId());

            startActivity(intent);
        }
    };

}
