package com.example.samtrent.ezworkout;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

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

        /*
        *  check if the given workout is a
        *  favorite workout or not and create
        *  the rating bar for the different
        *  cases
         */
        if (workout.getIsFavorite() == 0) {
            RelativeLayout rBar = (RelativeLayout) findViewById(R.id.activity_workout_display);

            RatingBar add_To_Fav = new RatingBar(workoutDisplayActivity.this);
            add_To_Fav.setNumStars(1);
            add_To_Fav.setRating(0);
            add_To_Fav.setOnRatingBarChangeListener(addToFavListener);

            rBar.addView(add_To_Fav);
        }
        else if (workout.getIsFavorite() == 1){
            RelativeLayout rBar = (RelativeLayout) findViewById(R.id.activity_workout_display);

            RatingBar remove_From_Fav = new RatingBar(workoutDisplayActivity.this);
            remove_From_Fav.setNumStars(1);
            remove_From_Fav.setRating(1);
            remove_From_Fav.setOnRatingBarChangeListener(removeFromFavListener);

            rBar.addView(remove_From_Fav);
        }

        /*
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
        */

    }


    /*
    *  add the given workout to the
    *  favorite workouts table if the
    *  rating bar is selected
    */
    private RatingBar.OnRatingBarChangeListener addToFavListener = new RatingBar.OnRatingBarChangeListener() {

        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            Toast.makeText(getApplicationContext(), "Added to Favorites", Toast.LENGTH_LONG).show();

            My_Workouts new_My_Workout = new My_Workouts();
            long new_My_Workout_Id = db.insert_Favorite_Workout(new_My_Workout, workout_id);

            db.update_Fav_Workout(1, workout_id);
            //Workout workout = db.query_Workout(workout_id);
            //workout.setIsFavorite(1);

        }

    };

    /*
    *  remove the given workout from the
    *  favorite workouts table if the
    *  rating bar is unselected
    */
    private RatingBar.OnRatingBarChangeListener removeFromFavListener = new RatingBar.OnRatingBarChangeListener() {

        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            Toast.makeText(getApplicationContext(), "Removed from Favorites", Toast.LENGTH_LONG).show();

            db.remove_Favorite_Workout(workout_id);

            db.update_Fav_Workout(0, workout_id);
            //Workout workout = db.query_Workout(workout_id);
            //workout.setIsFavorite(0);

        }

    };

}
// ***** WORKING ON GIF PLAYER FUNCTION *****

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


// test to make sure that we are getting a gif file.
class GifFileTester
{
    public void testGifFile(String gifFilePath)
    {
        if (gifFilePath == "") throw new AssertionError("Gif file was not recieved correctly!");
    }
}