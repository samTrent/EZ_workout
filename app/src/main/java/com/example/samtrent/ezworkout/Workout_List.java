package com.example.samtrent.ezworkout;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "Workout_List")
public class Workout_List {

    public static final String FIELD_NAME_ID     = "Id";
    public static final String FIELD_NAME_PLACE = "Place";
    public static final String FIELD_NAME_MUSCLE_GROUP   = "MuscleGroup";

    @DatabaseField(id = true, columnName = FIELD_NAME_ID)
    int id;

    @DatabaseField(canBeNull = false, foreign = true, columnName = FIELD_NAME_PLACE)
    public Place fk_place;

    @DatabaseField(canBeNull = false, columnName = FIELD_NAME_MUSCLE_GROUP)
    String MuscleGroup;


    Workout_List() {
        // needed by ormlite
    }

    Workout_List(int newId, String newMGroup, Place nw_fk_Place) {
        id = newId;
        MuscleGroup = newMGroup;
        fk_place = nw_fk_Place;
    }

    public String getMGroup() {
        return MuscleGroup;
    }

    public Place getPlace() {
        return fk_place;
    }

    public int getId() {
        return id;
    }

}

