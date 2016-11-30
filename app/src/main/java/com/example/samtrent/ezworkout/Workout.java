package com.example.samtrent.ezworkout;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "Workout")
public class Workout {

    private int id;
    private int fk_muscleGroup;
    private String name;
    private String procedure;
    private int isFavorite;
    private String gifName;

    // constructors
    public Workout() {
        isFavorite = 0;
    }

    // set foreign key with Workout_List object
    public Workout(int newId, String nwname, String nwprocedure) {
        setId(newId);
        setName(nwname);
        setProcedure(nwprocedure);
        isFavorite = 0;
    }

    // set foreign key directly with an int
    public Workout(int newId, String nwname, int nw_fk_MGroup, String nwprocedure, String gifName) {
        setId(newId);
        setName(nwname);
        setFk_muscleGroup(nw_fk_MGroup);
        setProcedure(nwprocedure);
        isFavorite = 0;
        setGifName(gifName);
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        id = i;
    }

    public int getFk_muscleGroup() {
        return fk_muscleGroup;
    }

    public void setFk_muscleGroup(int fk) {
        fk_muscleGroup = fk;
    }

    public void setFk_muscleGroup(Workout_List w) {
        fk_muscleGroup = w.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String p) {
        procedure = p;
    }

    public int getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(int f) {
        isFavorite = f;
    }

    public void setGifName(String gifName) { this.gifName = gifName; }

    public String getGifName() { return  gifName; }

}
