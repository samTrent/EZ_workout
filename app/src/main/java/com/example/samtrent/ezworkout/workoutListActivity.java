package com.example.samtrent.ezworkout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class workoutListActivity extends AppCompatActivity {

    //making our arrayList and adapter to temp hold some strings to display
    ArrayList<String> listOfWorkouts;
    ArrayAdapter<String> itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list2);


        // initializing our ArrayList
        listOfWorkouts = new ArrayList();

        //populating it...
        for(int i = 0; i < 10; i++)
        {
            listOfWorkouts.add("A Temp Workout");
        }


        //convert to list adapter to display...
        itemAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfWorkouts);


        //set it to display!
        ListView listView = (ListView) findViewById(R.id.listOfWorkouts);
        listView.setAdapter(itemAdapter);



        //set up our ability to list a listView item...
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //tell what view we want to move to...
                Intent i = new Intent(workoutListActivity.this, workoutDisplayActivity.class);

                //pass data we want to transfer to the next activity...
                i.putExtra("workout_item", 0);

                //segue to new activity!
                startActivity(i);

            }
        });


    }



}
