package com.example.samtrent.ezworkout;



import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "My_Workouts")
public class My_Workouts {

    public static final String FIELD_NAME_ID     = "Id";
    public static final String FIELD_NAME_WORKOUT = "fk_Workout";

    @DatabaseField(id = true, columnName = FIELD_NAME_ID)
    int id;

    @DatabaseField(canBeNull = false, foreign = true, columnName = FIELD_NAME_WORKOUT)
    public Workout fk_workout;


    My_Workouts() {
        // needed by ormlite
    }

    My_Workouts(int newId, Workout nw_fk_Workout) {
        id = newId;
        fk_workout = nw_fk_Workout;
    }

    public Workout getFk_workout() {
        return fk_workout;
    }

    public int getId() {
        return id;
    }

}
