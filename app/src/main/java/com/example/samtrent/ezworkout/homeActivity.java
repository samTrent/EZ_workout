package com.example.samtrent.ezworkout;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

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
        Log.w("Home", "Fav List Size: " + my_fav_list.size());
        if (my_fav_list.size() == 0) {
            TextView tv = new TextView(homeActivity.this);
            tv.setText("You currently have no favorite workouts");
            //tv.setTextSize(20);
            //tv.setGravity(Gravity.CENTER);
            //tv.setTypeface(null, Typeface.BOLD);
            //tv.setPadding(20, 20, 20, 20);
            //tv.setBackgroundColor(3);

            LinearLayout l_fav = (LinearLayout) findViewById(R.id.favLayout);
            l_fav.addView(tv);
        }
        else if (my_fav_list.size() != 0) {
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


    @Override
    public void onResume() {
        super.onResume();

        LinearLayout l_Fav = (LinearLayout) findViewById(R.id.favLayout);
        l_Fav.removeAllViews();

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
    }



    /*
    *   Add each button for every
    *   workout in the my workouts
    *   table
     */
    public void add_My_Workout_Button(Workout w) {
        LinearLayout l_Fav = (LinearLayout) findViewById(R.id.favLayout);
        LinearLayout n_Layout = new LinearLayout(homeActivity.this);
        n_Layout.setOrientation(LinearLayout.VERTICAL);

        Workout_List wl = db.query_Workout_List(w.getFk_muscleGroup());
        String icon = wl.getIcon();
        int id = this.getResources().getIdentifier(icon, "drawable", this.getPackageName());

        ImageButton ib = new ImageButton(homeActivity.this);
        ib.setLayoutParams(new LinearLayout.LayoutParams(250, 250));
        ib.setScaleType(ImageView.ScaleType.CENTER);
        ib.setAdjustViewBounds(true);
        ib.setOnClickListener(straightToWorkoutOnClickListener);
        ib.setTag(w.getId());
        ib.setId(w.getId());
        ib.setImageResource(id);

        n_Layout.addView(ib);


        TextView tv = new TextView(homeActivity.this);
        tv.setText(w.getName());
        tv.setGravity(Gravity.CENTER);
        tv.setHorizontallyScrolling(false);
        tv.setTextSize(10);
        tv.setTypeface(null, Typeface.BOLD);
        //tv.setCompoundDrawablePadding(10);


        n_Layout.addView(tv);
        l_Fav.addView(n_Layout);
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
        ib.setScaleType(ImageView.ScaleType.CENTER);
        ib.setAdjustViewBounds(true);
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
        ib.setScaleType(ImageView.ScaleType.CENTER);
        ib.setAdjustViewBounds(true);
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
