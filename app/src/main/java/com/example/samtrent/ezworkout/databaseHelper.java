package com.example.samtrent.ezworkout;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



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
    // Workouts table create
    private static final String CREATE_WORKOUTS_TABLE =
            "CREATE TABLE " + TABLE_WORKOUTS +
                    "(" + KEY_W_ID + " INTEGER PRIMARY KEY," +
                    KEY_W_NAME + " TEXT, " +
                    KEY_W_PROCEDURE + " TEXT, " +
                    KEY_W_MUSCLE_GROUP + " INTEGER, " +
                    KEY_W_IS_FAVORITE + " INTEGER)";

    // Workouts_lists table and column names
    private static final String TABLE_WORKOUT_LIST = "Workout_Lists";
    private static final String KEY_WL_ID = "ID";
    private static final String KEY_WL_MUSCLE_GROUP = "Muscle Group";
    private static final String KEY_WL_PLACE = "Place";
    // Workouts_list table create
    private static final String CREATE_WORKOUTS_LIST_TABLE =
            "CREATE TABLE " + TABLE_WORKOUT_LIST +
                    "(" + KEY_WL_ID + " INTEGER PRIMARY KEY," +
                    KEY_WL_MUSCLE_GROUP + " INTEGER, " +
                    KEY_WL_PLACE + " INTEGER)";

    // Places table and column names
    private static final String TABLE_PLACE = "Places";
    private static final String KEY_P_ID = "ID";
    private static final String KEY_P_PLACE = "Place";
    // Places table create
    private static final String CREATE_PLACE_TABLE =
            "CREATE TABLE " + TABLE_PLACE +
                    "(" + KEY_P_ID + " INTEGER PRIMARY KEY," +
                    KEY_P_PLACE + " TEXT)";

    // Favorite Workouts table and column names
    private static final String TABLE_FAVORITE_WORKOUTS = "Favorite_Workouts";
    private static final String KEY_FW_ID = "ID";
    private static final String KEY_FW_WORKOUT = "Workout";
    // Favorite Workouts table create
    private static final String CREATE_FAV_WORKOUTS_TABLE =
            "CREATE TABLE " + TABLE_FAVORITE_WORKOUTS +
                    "(" + KEY_FW_ID + " INTEGER PRIMARY KEY," +
                    KEY_FW_WORKOUT + " INTEGER)";


    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_WORKOUTS_TABLE);
        db.execSQL(CREATE_WORKOUTS_LIST_TABLE);
        db.execSQL(CREATE_PLACE_TABLE);
        db.execSQL(CREATE_FAV_WORKOUTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUT_LIST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLACE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITE_WORKOUTS);

        // create new tables
        onCreate(db);
    }


}
