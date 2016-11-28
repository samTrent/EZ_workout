package com.example.samtrent.ezworkout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class workoutDisplayActivity extends AppCompatActivity {

    databaseHelper db;
    int workout_id;

    // creating our "gif" object
    GifDrawable gifAnim;
    private GifImageView mGifImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_display);

        db = new databaseHelper(getApplicationContext());
        workout_id = getIntent().getExtras().getInt("Workout");

        Workout workout = db.query_Workout(workout_id);

        TextView title = (TextView) findViewById(R.id.workoutTitle);
        title.setText(workout.getName());

        TextView description = (TextView) findViewById(R.id.instructionText);
        description.setText(workout.getProcedure());
    }

        mGifImageView = (GifImageView) findViewById(R.id.giffy);

        // check to see if the gif file exsists...
        try {

            //if successful, create the gif object with the gif file as a param
            gifAnim = new GifDrawable(getResources(), R.drawable.hammercurl);

            gifAnim.setLoopCount(0); // loop the gif
            mGifImageView.setImageDrawable(gifAnim); // set the gif as an imageObject


        }

        catch (IOException e)
        {
            Log.e("make gif", "onCreate: could not generate gif", e);
            e.printStackTrace();
        }

//        //
//        gifAnim.addAnimationListener(new AnimationListener()
//        {
//            @Override
//            public void onAnimationCompleted(int loopNumber) {
//                gifAnim.setLoopCount(0);
//                gifAnim.reset();
//                Log.d("ayyy", "onAnimationCompleted: IN anin");
//            }
//
//
//        });



    }



}

// test to make sure that we are getting a gif file.
class GifFileTester
{
    public void testGifFile(String gifFilePath)
    {
        if (gifFilePath == "") throw new AssertionError("Gif file was not recieved correctly!");
    }
}