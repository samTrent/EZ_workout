package com.example.samtrent.ezworkout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

        db = new databaseHelper(getApplicationContext());

        Fill_Database fd = new Fill_Database(db);
        fd.fill_Place_Table();
        fd.fill_Workout_List_Table();
        fd.fill_Workout_Table();

        List<Workout_List> home_list = db.query_All_Workout_Lists("Home");
        List<Workout_List> gym_list = db.query_All_Workout_Lists("Gym");

        for (Workout_List wl : home_list) {
            add_Home_Button(wl);
            //Log.i("With Home Query", wl.getId() + ": " + wl.getMuscleGroup() + ", FK " + wl.getFk_place());
        }

        for (Workout_List wl : gym_list) {
            add_Gym_Button(wl);
            //Log.i("With Gym Query", wl.getId() + ": " + wl.getMuscleGroup() + ", FK " + wl.getFk_place());
        }

    }


    public void add_Home_Button(Workout_List wl) {
        LinearLayout l_Home = (LinearLayout) findViewById(R.id.homeLayout);

        ImageButton ib = new ImageButton(homeActivity.this);
        ib.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
        ib.setOnClickListener(trialOnClickListener);
        ib.setTag(wl.getId());
        ib.setId(wl.getId());

        l_Home.addView(ib);
    }


    public void add_Gym_Button(Workout_List wl) {
        LinearLayout l_Gym = (LinearLayout) findViewById(R.id.gymLayout);

        ImageButton ib = new ImageButton(homeActivity.this);
        ib.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
        ib.setOnClickListener(trialOnClickListener);
        ib.setTag(wl.getId());
        ib.setId(wl.getId());

        l_Gym.addView(ib);
    }


    private View.OnClickListener trialOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            ImageButton imgBtn = (ImageButton) v;

            Intent intent = new Intent(homeActivity.this, workoutListActivity.class);
            intent.putExtra("Group", v.getId());

            startActivity(intent);
        }
    };

}
