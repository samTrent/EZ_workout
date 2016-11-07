package com.example.samtrent.ezworkout;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;



public class databaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "workout.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Place, Integer> place_Dao = null;
    private Dao<Workout_List, Integer> workout_list_Dao = null;
    private Dao<Workout, Integer> workout_Dao = null;
    private Dao<My_Workouts, Integer> my_workouts_Dao = null;
    private RuntimeExceptionDao<Place, Integer> runtimeDao = null;

    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Place.class);
            TableUtils.createTable(connectionSource, Workout_List.class);
            TableUtils.createTable(connectionSource, Workout.class);
            TableUtils.createTable(connectionSource, My_Workouts.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            Log.i(databaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Place.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(databaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }

    }


    public Dao<Place, Integer> get_Dao() throws SQLException {
        return place_Dao;
    }

    public Dao<Workout_List, Integer> get_Workout_List() throws SQLException {
        return workout_list_Dao;
    }

    public Dao<Workout, Integer> get_Workout() throws SQLException {
        return workout_Dao;
    }

    public Dao<My_Workouts, Integer> get_My_workouts_Dao() throws SQLException {
        return my_workouts_Dao;
    }


    public RuntimeExceptionDao<Place, Integer> getPlaceDao() {
        if (runtimeDao == null) {
            runtimeDao = getRuntimeExceptionDao(Place.class);
        }

        return runtimeDao;
    }


    @Override
    public void close() {
        super.close();
        place_Dao = null;
        workout_list_Dao = null;
        workout_Dao = null;
        my_workouts_Dao = null;
        runtimeDao = null;

    }
}
