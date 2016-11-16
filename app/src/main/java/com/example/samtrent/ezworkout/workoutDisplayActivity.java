package com.example.samtrent.ezworkout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;

public class workoutDisplayActivity extends AppCompatActivity {

    // creating our "gif" object
    GifDrawable gifAnim;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_display);


        // check to see if the gif file exsists...



            //if successful, create the gif object with the gif file as a param


        try {

            gifAnim = new GifDrawable(getResources(), R.drawable.hammercurl);
            gifAnim.setTint(10);

        } catch (IOException e)
        {
            Log.e("make gif", "onCreate: could not generate gif", e);
            
            e.printStackTrace();
        }

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