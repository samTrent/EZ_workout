package com.example.samtrent.ezworkout;



public class Fill_Database {

    private databaseHelper db;

    // FK from place table
    public long home_id;
    public long gym_id;

    // FK from workout_list table
    // FK for home workout_list
    public long arms_H_Id;
    public long legs_H_Id;
    public long back_H_Id;
    public long chest_H_Id;
    // FK for gym workout_list
    public long arms_G_Id;
    public long legs_G_Id;
    public long back_G_Id;
    public long chest_G_Id;

    // FK from workout table



    public Fill_Database(databaseHelper db) {
        this.db = db;
    }

    public void fill_Place_Table() {

        Place home = new Place(101, "Home");
        Place gym = new Place(102, "Gym");

        home_id = db.insert_Place(home);
        gym_id = db.insert_Place(gym);
    }

    public void fill_Workout_List_Table() {

        Workout_List arms_H = new Workout_List(1, "Arms");
        Workout_List legs_H = new Workout_List(2, "Legs");
        Workout_List back_H = new Workout_List(3, "Back");
        Workout_List chest_H = new Workout_List(4, "Chest");

        arms_H_Id = db.insert_Workout_List(arms_H, home_id);
        legs_H_Id = db.insert_Workout_List(legs_H, home_id);
        back_H_Id = db.insert_Workout_List(back_H, home_id);
        chest_H_Id = db.insert_Workout_List(chest_H, home_id);

        Workout_List arms_G = new Workout_List(5, "Arms");
        Workout_List legs_G = new Workout_List(6, "Legs");
        Workout_List back_G = new Workout_List(7, "Back");
        Workout_List chest_G = new Workout_List(8, "Chest");

        arms_G_Id = db.insert_Workout_List(arms_G, gym_id);
        legs_G_Id = db.insert_Workout_List(legs_G, gym_id);
        back_G_Id = db.insert_Workout_List(back_G, gym_id);
        chest_G_Id = db.insert_Workout_List(chest_G, gym_id);
    }

    public void fill_Workout_Table() {

        Workout bicept_A_H = new Workout();
        Workout tricept_A_H = new Workout();

    }

}
