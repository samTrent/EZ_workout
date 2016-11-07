package com.example.samtrent.ezworkout;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "Workout")
public class Workout {

    public static final String FIELD_NAME_ID     = "Id";
    public static final String FIELD_NAME_MUSCLE_GROUP   = "fk_MuscleGroup";
    public static final String FIELD_NAME_NAME   = "Name";
    public static final String FIELD_NAME_PROCEDURE   = "Procedure";
    public static final String FIELD_NAME_GIF   = "Gif";
    public static final String FIELD_NAME_PICTURES   = "Pictures";

    @DatabaseField(id = true, columnName = FIELD_NAME_ID)
    int id;

    @DatabaseField(canBeNull = false, foreign = true, columnName = FIELD_NAME_MUSCLE_GROUP)
    public Workout_List fk_muscleGroup;

    @DatabaseField(canBeNull = false, columnName = FIELD_NAME_NAME)
    String name;

    @DatabaseField(canBeNull = false, columnName = FIELD_NAME_PROCEDURE)
    String procedure;


    Workout() {
        // needed by ormlite
    }

    Workout(int newId, String nwname, Workout_List nw_fk_MGroup, String nwprocedure) {
        id = newId;
        name = nwname;
        procedure = nwprocedure;
        fk_muscleGroup = nw_fk_MGroup;
    }

    public Workout_List getMGroup() {
        return fk_muscleGroup;
    }

    public String getName() {
        return name;
    }

    public String getProcedure() {
        return procedure;
    }

    public int getId() {
        return id;
    }

}
