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
    public long basic_Curl_A_G_Id;
    private String basic_Curl_Procedure = "Materials needed:\n\n" +
            "- Weighted dumbbell\n" +
            "- (optional) Flat surface to sit on\n\n\n" +
            "                                   Instructions\n\n" +
            "1    Stand up straight with a dumbbell in each hand at arm's length. Keep your\n" +
            "elbows close to your torso and rotate the palms of your hands until they are\n" +
            "facing forward. This will be your starting position.\n\n" +
            "2  Now, keeping the upper arms stationary, exhale and curl the weights while\n" +
            "contracting your biceps. Continue to raise the weights until your biceps are fully\n" +
            "contracted and the dumbbells are at shoulder level. Hold the contracted position\n" +
            "for a brief pause as you squeeze your biceps.\n\n" +
            "3  Then, inhale and slowly begin to lower the dumbbells back to the starting\n" +
            "position.\n\n" +
            "4  Repeat for the recommended amount of repetitions.\n\n" +
            "Variations: There are many possible variations for this movement. For instance, you can\n" +
            "perform the exercise sitting down on a bench with or without back support and you can\n" +
            "also perform it by alternating arms; first lift the right arm for one repetition, the the left,\n" +
            "then the right, etc.\n";


    public Fill_Database(databaseHelper db) {
        this.db = db;
    }

    public void fill_Place_Table() {

        Place home = new Place(1001, "Home");
        Place gym = new Place(1002, "Gym");

        home_id = db.insert_Place(home);
        gym_id = db.insert_Place(gym);
    }

    public void fill_Workout_List_Table() {

        Workout_List arms_H = new Workout_List(101, "Arms", 1001);
        Workout_List legs_H = new Workout_List(102, "Legs", 1001);
        Workout_List back_H = new Workout_List(103, "Back", 1001);
        Workout_List chest_H = new Workout_List(104, "Chest", 1001);

        arms_H_Id = db.insert_Workout_List(arms_H, home_id);
        legs_H_Id = db.insert_Workout_List(legs_H, home_id);
        back_H_Id = db.insert_Workout_List(back_H, home_id);
        chest_H_Id = db.insert_Workout_List(chest_H, home_id);

        Workout_List arms_G = new Workout_List(205, "Arms", 1002);
        Workout_List legs_G = new Workout_List(206, "Legs", 1002);
        Workout_List back_G = new Workout_List(207, "Back", 1002);
        Workout_List chest_G = new Workout_List(208, "Chest", 1002);

        arms_G_Id = db.insert_Workout_List(arms_G, gym_id);
        legs_G_Id = db.insert_Workout_List(legs_G, gym_id);
        back_G_Id = db.insert_Workout_List(back_G, gym_id);
        chest_G_Id = db.insert_Workout_List(chest_G, gym_id);
    }

    public void fill_Workout_Table() {

        Workout basic_Curl_A_G = new Workout(1, "Consentration Curl", 205, basic_Curl_Procedure);

        basic_Curl_A_G_Id = db.insert_Workout(basic_Curl_A_G, arms_G_Id);
    }

}
