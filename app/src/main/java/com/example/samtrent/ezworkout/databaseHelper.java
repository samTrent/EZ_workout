package com.example.samtrent.ezworkout;

import java.sql.SQLException;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class databaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = databaseHelper.class.getName();

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

    /**************************************************************************
     *
     * Workout methods
     *
     *************************************************************************/
    /*
    * Creating workout
    */
    public long create_Workout(Workout workout, long workout_list_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_W_ID, workout.getId());
        values.put(KEY_W_NAME, workout.getName());
        values.put(KEY_W_PROCEDURE, workout.getProcedure());
        values.put(KEY_W_IS_FAVORITE, workout.getIsFavorite());
        values.put(KEY_W_MUSCLE_GROUP, workout_list_id);

        // insert row
        long workout_id = db.insert(TABLE_WORKOUTS, null, values);

        return workout_id;
    }

    /*
    * get single Workout
    */
    public Workout get_Workout(long workout_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_WORKOUTS + " WHERE "
                + KEY_W_ID + " = " + workout_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Workout w = new Workout();
        w.setId(c.getInt(c.getColumnIndex(KEY_WL_ID)));
        w.setName((c.getString(c.getColumnIndex(KEY_W_NAME))));
        w.setProcedure((c.getString(c.getColumnIndex(KEY_W_PROCEDURE))));
        w.setFk_muscleGroup((c.getInt(c.getColumnIndex(KEY_W_MUSCLE_GROUP))));

        return w;
    }

    /**************************************************************************
     *
     * Workout_List methods
     *
     *************************************************************************/
    /*
    * Creating workout_list
    */
    public long create_Workout_List(Workout_List workout_list, long place_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_WL_ID, workout_list.getId());
        values.put(KEY_WL_MUSCLE_GROUP, workout_list.getMuscleGroup());
        values.put(KEY_WL_PLACE, place_id);

        // insert row
        long workout_list_id = db.insert(TABLE_WORKOUT_LIST, null, values);

        return workout_list_id;
    }

    /*
    * get single Workout_List
    */
    public Workout_List get_Workout_List(long workout_list_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_WORKOUT_LIST + " WHERE "
                + KEY_WL_ID + " = " + workout_list_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Workout_List wl = new Workout_List();
        wl.setId(c.getInt(c.getColumnIndex(KEY_WL_ID)));
        wl.setMuscleGroup((c.getString(c.getColumnIndex(KEY_WL_MUSCLE_GROUP))));
        wl.setFk_place((c.getInt(c.getColumnIndex(KEY_WL_PLACE))));

        return wl;
    }

    /**************************************************************************
     *
     * Place methods
     *
     *************************************************************************/
    /*
    * Creating place
    */
    public long create_Place(Place place) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_P_ID, place.getId());
        values.put(KEY_P_PLACE, place.getPlace());

        // insert row
        long place_id = db.insert(TABLE_PLACE, null, values);

        return place_id;
    }

    /*
    * get single Place
    */
    public Place get_Place(long place_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_PLACE + " WHERE "
                + KEY_P_ID + " = " + place_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Place p = new Place();
        p.setId(c.getInt(c.getColumnIndex(KEY_P_ID)));
        p.setPlace((c.getString(c.getColumnIndex(KEY_P_PLACE))));

        return p;
    }

    /**************************************************************************
     *
     * Favorite_Workout methods
     *
     *************************************************************************/
    /*
    * Creating favorite_workouts
    */
    public long create_Favorite_Workout(My_Workouts my_workouts, long workout_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FW_ID, my_workouts.getId());
        values.put(KEY_FW_WORKOUT, workout_id);

        // insert row
        long fave_workout_id = db.insert(TABLE_FAVORITE_WORKOUTS, null, values);

        return fave_workout_id;
    }

    /*
    * get single Favorite_Workout
    */
    public My_Workouts get_My_Workouts(long fave_workout_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_FAVORITE_WORKOUTS + " WHERE "
                + KEY_FW_ID + " = " + fave_workout_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        My_Workouts mw = new My_Workouts();
        mw.setId(c.getInt(c.getColumnIndex(KEY_WL_ID)));
        mw.setFk_workout((c.getInt(c.getColumnIndex(KEY_FW_WORKOUT))));

        return mw;
    }


}
