package com.example.samtrent.ezworkout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;

public class workoutDisplayActivity extends AppCompatActivity {

    databaseHelper db;
    int workout_id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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

}
// ***** WORKING ON GIF PLAYER FUNCTION *****

//    public class AA extends Activity
//    {
//
//        @Override
//        public void onCreate(Bundle savedInstanceState)
//        {
//
//            super.onCreate(savedInstanceStated);
//
//
//            setContentView(new MYGIFView(this));
//        }
//
//    }
//
//
//    private class MYGIFView extends View
//    {
//
//        Movie movie, movie1;
//        InputStream is = null, is1 = null;
//        long moviestart;
//
//        public GIFView(Context context)
//        {
//            super(context);
//
//
//        }
//
//
//    }
//
//    is=context.getResources().openRawResource(R.drawable.earth);
//    movie=Movie.decodeStream(is);
//
//
//
//    @Override
//    protected void onDraw(Canvas canvas)
//    {
//
//        canvas.drawColor(Color.WHITE);
//        super.onDraw(canvas);
//        long now=android.os.SystemClock.uptimeMillis();
//        System.out.println("now="+now);
//        if (moviestart == 0)
//        { // first time
//            moviestart = now;
//
//        }
//}

// test to make sure that we are getting a gif file.
class GifFileTester
{
    public void testGifFile(String gifFilePath)
    {
        if (gifFilePath == "") throw new AssertionError("Gif file was not recieved correctly!");
    }
}