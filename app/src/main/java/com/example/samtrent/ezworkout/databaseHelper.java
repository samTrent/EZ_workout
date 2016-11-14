package com.example.samtrent.ezworkout;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


public class databaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "OurDatabase";
    private static final int DATABASE_VERSION = 1;

    // Workouts table and columns name
    private static final String TABLE_WORKOUTS = "Workouts";
    private static final String KEY_W_ID = "ID";
    private static final String KEY_W_NAME = "Name";
    private static final String KEY_W_PROCEDURE = "Procedure";
    private static final String KEY_W_IS_FAVORITE = "isFavorite";
    private static final String KEY_W_MUSCLE_GROUP = "Muscle Group";

    // Workouts_list table and column names
    private static final String TABLE_WORKOUT_LIST = "Workout_Lists";
    private static final String KEY_WL_ID = "ID";
    private static final String KEY_WL_MUSCLE_GROUP = "Muscle Group";
    private static final String KEY_WL_PLACE = "Place";

    // Places table and column names
    private static final String TABLE_PLACE = "Places";
    private static final String KEY_P_ID = "ID";
    private static final String KEY_P_PLACE = "Place";

    // Favorite Workouts table and column names
    private static final String TABLE_FAVORITE_WORKOUTS = "Favorite_Workouts";
    private static final String KEY_FW_ID = "ID";
    private static final String KEY_FW_WORKOUT = "Workout";

    private static final String CREATE_WORKOUTS_TABLE = "CREATE TABLE " + TABLE_WORKOUTS +
            "(" + KEY_W_ID + " INTEGER PRIMARY KEY," +
            KEY_W_NAME + " TEXT, " +
            KEY_W_PROCEDURE + " TEXT, " +
            KEY_W_MUSCLE_GROUP + " TEXT, " +
            KEY_W_IS_FAVORITE + " INTEGER)";



    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
