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
    // Gym Arms
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

    public long hammer_Curl_A_G_Id;
    public long dips_A_G_Id;
    public long tricep_Extension_A_G_Id;
    public long forearm_Curl_A_G_Id;
    public long weighted_Windup_A_G_Id;

    // Gym Legs
    public long squats_L_G_Id;
    public long leg_Press_L_G_Id;
    public long calf_Raises_L_G_Id;
    public long leg_Curl_L_G_Id;
    public long leg_Extension_L_G_Id;
    public long dead_Lift_L_G_Id;

    // Gym Back
    public long lat_Pulldown_B_G_Id;
    public long single_Arm_Dumbbell_Row_B_G_Id;
    public long side_Lateral_Raises_B_G_Id;
    public long weighted_Shrugs_B_G_Id;
    public long bent_Over_Row_B_G_Id;
    public long military_Press_B_G_Id;
    public long reverse_Flies_B_G_Id;

    // Gym Chest
    public long bench_Press_C_G_Id;
    public long dumbbell_Bench_Press_C_G_Id;
    public long incline_Dumbbell_Press_C_G_Id;
    public long decline_Dumbbell_Press_C_G_Id;


    // Home Arms
    public long band_Basic_Curl_A_H_Id;
    public long band_Hammer_Curl_A_H_Id;
    public long chair_Dips_A_H_Id;
    public long band_Tricep_Extension_A_H_Id;
    public long band_Forearm_Curl_A_H_Id;
    public long band_Tricep_Pulldown_A_H_Id;

    // Home Legs
    public long air_Squats_L_H_Id;
    public long lunges_L_H_Id;
    public long stair_Calf_Raises_L_H_Id;
    public long jump_Rope_L_H_Id;

    // Home Back
    public long closeGrip_Pullup_B_H_Id;
    public long wideGrip_Pullup_B_H_Id;
    public long band_lat_Pulldown_B_H_Id;
    public long band_Sitting_Row_B_H_Id;
    public long band_Military_Press_B_H_Id;
    public long band_Shrugs_B_H_Id;

    // Home Chest
    public long wide_Pushup_C_H_Id;
    public long diamond_Pushup_C_H_Id;
    public long decline_Pushup_C_H_Id;
    public long band_Bench_Press_C_H_Id;


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

        // Add home workout groups
        Workout_List arms_H = new Workout_List(101, "Arms", 1001, "bicep_icon");
        Workout_List legs_H = new Workout_List(102, "Legs", 1001, "leg_icon");
        Workout_List back_H = new Workout_List(103, "Back", 1001, "back_icon");
        Workout_List chest_H = new Workout_List(104, "Chest", 1001, "chest_icon");

        arms_H_Id = db.insert_Workout_List(arms_H, home_id);
        legs_H_Id = db.insert_Workout_List(legs_H, home_id);
        back_H_Id = db.insert_Workout_List(back_H, home_id);
        chest_H_Id = db.insert_Workout_List(chest_H, home_id);

        // Add gym workout groups
        Workout_List arms_G = new Workout_List(205, "Arms", 1002, "bicep_icon");
        Workout_List legs_G = new Workout_List(206, "Legs", 1002, "leg_icon");
        Workout_List back_G = new Workout_List(207, "Back", 1002, "back_icon");
        Workout_List chest_G = new Workout_List(208, "Chest", 1002, "chest_icon");

        arms_G_Id = db.insert_Workout_List(arms_G, gym_id);
        legs_G_Id = db.insert_Workout_List(legs_G, gym_id);
        back_G_Id = db.insert_Workout_List(back_G, gym_id);
        chest_G_Id = db.insert_Workout_List(chest_G, gym_id);
    }

    public void fill_Workout_Table() {

        // Add gym arm workouts
        Workout basic_Curl_A_G = new Workout(1, "Consentration Curl", 205, basic_Curl_Procedure);
        Workout hammer_Curl_A_G = new Workout(2, "Hammer Curl", 205, "Coming Soon");
        Workout dips_A_G = new Workout(3, "Dips", 205, "Coming Soon");
        Workout tricep_Extension_A_G = new Workout(4, "Tricep Extension", 205, "Coming Soon");
        Workout forearm_Curl_A_G = new Workout(5, "Forearm Curl", 205, "Coming Soon");
        Workout weighted_Windup_A_G = new Workout(6, "Weighted Windup", 205, "Coming Soon");

        basic_Curl_A_G_Id = db.insert_Workout(basic_Curl_A_G, arms_G_Id);
        hammer_Curl_A_G_Id = db.insert_Workout(hammer_Curl_A_G, arms_G_Id);
        dips_A_G_Id = db.insert_Workout(dips_A_G, arms_G_Id);
        tricep_Extension_A_G_Id = db.insert_Workout(tricep_Extension_A_G, arms_G_Id);
        forearm_Curl_A_G_Id = db.insert_Workout(forearm_Curl_A_G, arms_G_Id);
        weighted_Windup_A_G_Id = db.insert_Workout(weighted_Windup_A_G, arms_G_Id);

        // Add gym leg workouts
        Workout squats_L_G = new Workout(7, "Squats", 206, "Coming Soon");
        Workout leg_Press_L_G = new Workout(8, "Leg Press", 206, "Coming Soon");
        Workout calf_Raises_L_G = new Workout(9, "Calf Raises", 206, "Coming Soon");
        Workout leg_Curl_L_G = new Workout(10, "Leg Curl", 206, "Coming Soon");
        Workout leg_Extension_L_G = new Workout(11, "Leg Extension", 206, "Coming Soon");
        Workout dead_Lift_L_G = new Workout(12, "Dead Lift", 206, "Coming Soon");

        squats_L_G_Id = db.insert_Workout(squats_L_G, legs_G_Id);
        leg_Press_L_G_Id = db.insert_Workout(leg_Press_L_G, legs_G_Id);
        calf_Raises_L_G_Id = db.insert_Workout(calf_Raises_L_G, legs_G_Id);
        leg_Curl_L_G_Id = db.insert_Workout(leg_Curl_L_G, legs_G_Id);
        leg_Extension_L_G_Id = db.insert_Workout(leg_Extension_L_G, legs_G_Id);
        dead_Lift_L_G_Id = db.insert_Workout(dead_Lift_L_G, legs_G_Id);

        // Add gym back workouts
        Workout lat_Pulldown_B_G = new Workout(13, "Lateral Pulldown", 207, "Coming Soon");
        Workout bent_Over_Row_B_G = new Workout(14, "Bent Over Row", 207, "Coming Soon");
        Workout single_Arm_Dumbbell_Row_B_G = new Workout(15, "Single-Arm Dumbbell Row", 207, "Coming Soon");
        Workout weighted_Shrugs_B_G = new Workout(16, "Weighted Shrugs", 207, "Coming Soon");
        Workout reverse_Flies_B_G = new Workout(17, "Reverse Flies", 207, "Coming Soon");
        Workout military_Press_B_G = new Workout(18, "Military Press", 207, "Coming Soon");
        Workout side_Lateral_Raises_B_G = new Workout(19, "Side Lateral Raises", 207, "Coming Soon");

        lat_Pulldown_B_G_Id = db.insert_Workout(lat_Pulldown_B_G, back_G_Id);
        bent_Over_Row_B_G_Id = db.insert_Workout(bent_Over_Row_B_G, back_G_Id);
        single_Arm_Dumbbell_Row_B_G_Id = db.insert_Workout(single_Arm_Dumbbell_Row_B_G, back_G_Id);
        weighted_Shrugs_B_G_Id = db.insert_Workout(weighted_Shrugs_B_G, back_G_Id);
        reverse_Flies_B_G_Id = db.insert_Workout(reverse_Flies_B_G, back_G_Id);
        military_Press_B_G_Id = db.insert_Workout(military_Press_B_G, back_G_Id);
        side_Lateral_Raises_B_G_Id = db.insert_Workout(side_Lateral_Raises_B_G, back_G_Id);

        // Add gym chest workouts
        Workout bench_Press_C_G = new Workout(20, "Bench Press", 208, "Coming Soon");
        Workout dumbbell_Bench_Press_C_G = new Workout(21, "Dumbbell Bench Press", 208, "Coming Soon");
        Workout incline_Dumbbell_Press_C_G = new Workout(22, "Incline Dumbbell Press", 208, "Coming Soon");
        Workout decline_Dumbbell_Press_C_G = new Workout(23, "Decline Dumbbell Press", 208, "Coming Soon");

        bench_Press_C_G_Id = db.insert_Workout(bench_Press_C_G, chest_G_Id);
        dumbbell_Bench_Press_C_G_Id = db.insert_Workout(dumbbell_Bench_Press_C_G, chest_G_Id);
        incline_Dumbbell_Press_C_G_Id = db.insert_Workout(incline_Dumbbell_Press_C_G, chest_G_Id);
        decline_Dumbbell_Press_C_G_Id = db.insert_Workout(decline_Dumbbell_Press_C_G, chest_G_Id);

        // Add home arm workouts
        Workout band_Basic_Curl_A_H = new Workout(24, "Band Basic Curl", 101, "Coming Soon");
        Workout band_Hammer_Curl_A_H = new Workout(25, "Band Hammer Curl", 101, "Coming Soon");
        Workout chair_Dips_A_H = new Workout(26, "Chair Dips", 101, "Coming Soon");
        Workout band_Tricep_Extension_A_H = new Workout(27, "Band Tricep Extension", 101, "Coming Soon");
        Workout band_Forearm_Curl_A_H = new Workout(28, "Band Forearm Curl", 101, "Coming Soon");
        Workout band_Tricep_Pulldown_A_H = new Workout(29, "Band Tricep Pulldown", 101, "Coming Soon");

        band_Basic_Curl_A_H_Id = db.insert_Workout(band_Basic_Curl_A_H, arms_H_Id);
        band_Hammer_Curl_A_H_Id = db.insert_Workout(band_Hammer_Curl_A_H, arms_H_Id);
        chair_Dips_A_H_Id = db.insert_Workout(chair_Dips_A_H, arms_H_Id);
        band_Tricep_Extension_A_H_Id = db.insert_Workout(band_Tricep_Extension_A_H, arms_H_Id);
        band_Forearm_Curl_A_H_Id = db.insert_Workout(band_Forearm_Curl_A_H, arms_H_Id);
        band_Tricep_Pulldown_A_H_Id = db.insert_Workout(band_Tricep_Pulldown_A_H, arms_H_Id);

        // Add home leg workouts
        Workout air_Squats_L_H = new Workout(30, "Air Squats/Band Squats", 102, "Coming Soon");
        Workout lunges_L_H = new Workout(31, "Lunges", 102, "Coming Soon");
        Workout stair_Calf_Raises_L_H = new Workout(32, "Stair Calf Raises", 102, "Coming Soon");
        Workout jump_Rope_L_H = new Workout(33, "Jump Rope", 102, "Coming Soon");

        air_Squats_L_H_Id = db.insert_Workout(air_Squats_L_H, legs_H_Id);
        lunges_L_H_Id = db.insert_Workout(lunges_L_H, legs_H_Id);
        stair_Calf_Raises_L_H_Id = db.insert_Workout(stair_Calf_Raises_L_H, legs_H_Id);
        jump_Rope_L_H_Id = db.insert_Workout(jump_Rope_L_H, legs_H_Id);

        // Add home back workouts
        Workout closeGrip_Pullup_B_H = new Workout(34, "Close-Grip Pull-Up", 103, "Coming Soon");
        Workout wideGrip_Pullup_B_H = new Workout(35, "Wide-Grip Pull-Up", 103, "Coming Soon");
        Workout band_lat_Pulldown_B_H = new Workout(36, "Band Lat Pulldown", 103, "Coming Soon");
        Workout band_Sitting_Row_B_H = new Workout(37, "Band Sitting Row", 103, "Coming Soon");
        Workout band_Military_Press_B_H = new Workout(38, "Band Military Press", 103, "Coming Soon");
        Workout band_Shrugs_B_H = new Workout(39, "Band Shrugs", 103, "Coming Soon");

        closeGrip_Pullup_B_H_Id = db.insert_Workout(closeGrip_Pullup_B_H, back_H_Id);
        wideGrip_Pullup_B_H_Id = db.insert_Workout(wideGrip_Pullup_B_H, back_H_Id);
        band_lat_Pulldown_B_H_Id = db.insert_Workout(band_lat_Pulldown_B_H, back_H_Id);
        band_Sitting_Row_B_H_Id = db.insert_Workout(band_Sitting_Row_B_H, back_H_Id);
        band_Military_Press_B_H_Id = db.insert_Workout(band_Military_Press_B_H, back_H_Id);
        band_Shrugs_B_H_Id = db.insert_Workout(band_Shrugs_B_H, back_H_Id);

        // Add home chest workouts
        Workout wide_Pushup_C_H = new Workout(40, "Wide Push-Up", 104, "Coming Soon");
        Workout diamond_Pushup_C_H = new Workout(41, "Diamond Push-Up", 104, "Coming Soon");
        Workout decline_Pushup_C_H = new Workout(42, "Decline Push-Up", 104, "Coming Soon");
        Workout band_Bench_Press_C_H = new Workout(43, "Band Bench Press", 104, "Coming Soon");

        wide_Pushup_C_H_Id = db.insert_Workout(wide_Pushup_C_H, chest_H_Id);
        diamond_Pushup_C_H_Id = db.insert_Workout(diamond_Pushup_C_H, chest_H_Id);
        decline_Pushup_C_H_Id = db.insert_Workout(decline_Pushup_C_H, chest_H_Id);
        band_Bench_Press_C_H_Id = db.insert_Workout(band_Bench_Press_C_H, chest_H_Id);
    }

}
