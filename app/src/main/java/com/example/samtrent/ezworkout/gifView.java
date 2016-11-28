package com.example.samtrent.ezworkout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

import com.example.samtrent.ezworkout.R;

import java.io.InputStream;

/**
 * Created by samtrent on 11/14/16.
 */

public class gifView extends View
{
    private InputStream gifInputStream;
    private Movie gifMovie;
    private int movieWidth;
    private int movieHight;
    private long movieDuration;
    private long movieStart;



    public gifView(Context context) {
        super(context);
        init(context);
    }


    public gifView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    public gifView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context)
    {
        setFocusable(true);
        gifInputStream = context.getResources().openRawResource(+R.drawable.hammercurl);

        gifMovie = Movie.decodeStream(gifInputStream);
        movieWidth = gifMovie.width();
        movieHight = gifMovie.height();
        movieDuration = gifMovie.duration();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        setMeasuredDimension(movieWidth, movieHight);

    }

    public int getMovieWidth()
    {
        return movieWidth;
    }

    public int getMovieHeight()
    {
        return movieHight;
    }

    public long getMovieDuration()
    {
        return movieDuration;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        long now = SystemClock.uptimeMillis();

        if(movieStart == 0)
        {
            movieStart = now;
        }

        if(gifMovie != null)
        {
            int dur = gifMovie.duration();
            if(dur == 0)
            {
                dur = 1000;
            }

            int relTime = (int)((now = movieStart));

            gifMovie.setTime(relTime);

            gifMovie.draw(canvas, 0, 0);

            //stop movie
            invalidate();

        }

    }
}
