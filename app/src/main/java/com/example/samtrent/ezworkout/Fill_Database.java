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
    public long ab_H_Id;
    // FK for gym workout_list
    public long arms_G_Id;
    public long legs_G_Id;
    public long back_G_Id;
    public long chest_G_Id;
    public long ab_G_Id;

    // FK from workout table
    // Gym Arms
    public long basic_Curl_A_G_Id;
    private String basic_Curl_A_G_Procedure = "Materials needed:\n\n" +
            "- Weighted dumbbell\n" +
            "- (optional) Flat surface to sit on\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Stand up straight with a dumbbell in each hand at arm's length. Keep your\n" +
            "elbows close to your torso and rotate the palms of your hands until they are\n" +
            "facing forward. This will be your starting position.\n\n" +

            "2. Now, keeping the upper arms stationary, exhale and curl the weights while\n" +
            "contracting your biceps. Continue to raise the weights until your biceps are fully\n" +
            "contracted and the dumbbells are at shoulder level. Hold the contracted position\n" +
            "for a brief pause as you squeeze your biceps.\n\n" +

            "3. Then, inhale and slowly begin to lower the dumbbells back to the starting\n" +
            "position.\n\n" +

            "4. Repeat for the recommended amount of repetitions.\n\n" +
            "Variations: There are many possible variations for this movement. For instance, you can\n" +
            "perform the exercise sitting down on a bench with or without back support and you can\n" +
            "also perform it by alternating arms; first lift the right arm for one repetition, the the left,\n" +
            "then the right, etc.\n";

    public long hammer_Curl_A_G_Id;
    private String hammer_Curl_A_G_Procedure = "Materials needed:\n\n" +
            "- Weighted dumbbell\n" +
            "- (optional) Flat surface to sit on\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Stand up with your torso upright and a dumbbell on each hand being held at arms\n" +
            "length. The elbows should be close to the torso.\n\n" +

            "2. The palms of the hands should be facing your torso. This will be your starting position.\n\n" +

            "3. Now, while holding your upper arm stationary, exhale and curl the weight forward while\n" +
            "contracting the biceps. Continue to raise the weight until the biceps are fully contracted\n" +
            "and the dumbbell is at shoulder level. Hold the contracted position for a brief moment as you\n" +
            "squeeze the biceps. \n\n" +

            "Tip: Focus on keeping the elbow stationary and only moving your forearm.\n\n" +

            "4. After the brief pause, inhale and slowly begin the lower the dumbbells back down to the starting position.\n\n" +

            "5. Repeat for the recommended amount of repetitions.";

    public long dips_A_G_Id;
    private String dips_A_G_Procedure = "Materials needed:\n\n" +
            "- Weighted dumbbell\n" +
            "- (optional) Flat surface to sit on\n\n\n" +
            "                                   Instructions\n\n" +
            "1. For this exercise you will need access to parallel bars. To get yourself into the\n" +
            "starting position, hold your body at arms length (arms locked) above the bars.\n\n" +

            "2. While breathing in, lower yourself slowly with your torso leaning forward around 30\n" +
            " degrees or so and your elbows flared out slightly until you feel a slight stretch in the chest.\n\n" +

            "3. Once you feel the stretch, use your chest to bring your body back to the starting\n" +
            " position as you breathe out. Tip: Remember to squeeze the chest at the top of the\n" +
            "movement for a second.\n\n" +

            "4. Repeat the movement for the prescribed amount of repetitions.\n\n" +

            "Variations:\n" +
            "If you are new at this exercise and do not have the strength to perform it, use a dip\n" +
            "assist machine if available. These machines use weight to help you push your bodyweight.";

    public long tricep_Extension_A_G_Id;
    private String tricep_Extension_A_G_Procedure = "Materials needed:\n\n" +
            "- Weighted dumbbell\n\n\n" +
            "                                   Instructions\n\n" +
            "1. To begin, stand up with a dumbbell held by both hands. Your feet should be about shoulder " +
            "width apart from each other. Slowly use both hands to grab the dumbbell and lift it over " +
            "your head until both arms are fully extended.\n\n" +

            "2. The resistance should be resting in the palms of your hands with your thumbs around it. " +
            "The palm of the hands should be facing up towards the ceiling. This will be your starting position.\n\n" +

            "3. Keeping your upper arms close to your head with elbows in and perpendicular to the floor, " +
            "lower the resistance in a semicircular motion behind your head until your forearms touch " +
            "your biceps. Tip: The upper arms should remain stationary and only the forearms should " +
            "move. Breathe in as you perform this step.\n\n" +

            "4. Go back to the starting position by using the triceps to raise the dumbbell. Breathe " +
            "out as you perform this step.\n\n" +

            "5. Repeat for the recommended amount of repetitions. Variations:\n\n" +

            "• Another way to perform this exercise is to use an e-z or straight bar instead in " +
            "which case you will be holding the bar from the inside (around 5 inches between both " +
            "hands) with the palms facing forward (pronated grip).";

    public long forearm_Curl_A_G_Id;
    private String forearm_Curl_A_G_Procedure = "Materials needed:\n\n" +
            "- Weighted Barbell\n" +
            "- (optional) Weighted dumbbell - (optional) Flat Bench\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Hold a barbell with both hands and your palms facing up; hands spaced about shoulder width.\n\n" +

            "2. Kneel flat on the floor, at a distance that is slightly wider than shoulder width apart.\n\n" +

            "3. Lean forward and place your forearms on top of your flat bench with your palms up.\n" +
            "Tip: Make sure that the front of the wrists lay on top of the flat bench. This will " +
            "be your starting position.\n\n" +

            "4. Lower the bar as far as possible while inhaling and keeping a tight grip.\n\n" +

            "5. Now curl bar up as high as possible while flexing the forearms and exhaling. Hold " +
            "the contraction at the top for a second and Tip: Only the wrist should move.\n\n" +

            "Variations: This exercise can also be done with one or two dumbbells. Alternatively " +
            "an EZ bar can also be used. You can also do this standing up as well.";

    public long weighted_Windup_A_G_Id;
    private String weighted_Windup_A_G_Procedure = "Materials needed:\n\n" +
            "- Weighted plate\n" +
            "- Windup bar\n" +
            "- Connecting chain\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Hold the windup bar straight out in front of you with your arms parallel to the floor.\n\n" +

            "2. Using only your hands/writs, windup the chain holding the weighed plate to the top of the bar.\n\n" +

            "3. Once its at the top, reverse the motion lowering the weighed plate.";

    // Gym Legs
    public long squats_L_G_Id;
    private String squats_L_G_Procedure = "Materials needed: - none\n\n" +
            "                                   Instructions\n\n" +
            "1. Stand with your feet shoulder width apart. You can place your hands behind your head. " +
            "This will be your starting position.\n\n" +

            "2. Begin the movement by flexing your knees and hips, sitting back with your hips.\n\n" +

            "3. Continue down to full depth if you are able,and quickly reverse the motion until " +
            "you return to the starting position. As you squat, keep your head and chest up and push your knees out.";

    public long leg_Press_L_G_Id;
    private String leg_Press_L_G_Procedure = "Materials needed:\n\n" +
            "-(optional) Weighted dumbbells\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Stand with your torso upright holding two dumbbells in your hands by your sides. This " +
            "will be your starting position.\n\n" +

            "2. Step forward with your right leg around 2 feet or so from the foot being left stationary " +
            "behind and lower your upper body down, while keeping the torso upright and maintaining " +
            "balance. Inhale as you go down. Note: As in the other exercises, do not allow your knee " +
            "to go forward beyond your toes as you come down, as this will put undue stress on the " +
            "knee joint. Make sure that you keep your front shin perpendicular to the ground.\n\n" +

            "3. Using mainly the heel of your foot, push up and go back to the starting position as you exhale.\n\n" +

            "4. Repeat the movement for the recommended amount of repetitions and then perform with the left leg.\n\n" +

            "Caution: This is a movement that requires a great deal of balance so if you suffer " +
            "from balance problems you may wish to either avoid it or just use your own bodyweight " +
            "while holding on to a fixed object. Definitely never perform with a barbell on your " +
            "back if you suffer from balance issues.\n\n" +

            "Variations: There are several ways to perform the exercise.\n" +
            "One way is to alternate each leg. For instance do one repetition with the right, then " +
            "the left, then the right and so on.";

    public long calf_Raises_L_G_Id;
    private String calf_Raises_L_G_Procedure = "Materials needed:\n\n" +
            "-(optional) Weighted dumbbells\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Stand with your torso upright. Place the ball of the foot on a sturdy and stable " +
            "elevated surface (that is around 2-3 inches or taller). This will be your starting position.\n\n" +

            "2. With the toes pointing either straight (to hit all parts equally), inwards " +
            "(for emphasis on the outer head) or outwards (for emphasis on the inner head), raise " +
            "the heels off the floor as you exhale by contracting the calves. Hold the top " +
            "contraction for a second.\n\n" +

            "3. As you inhale, go back to the starting position by slowly lowering the heels.\n\n" +

            "4. Repeat for the recommended amount of times.\n\n" +

            "Note: If you choose to use dumbbells, you may need to use wrist wraps to avoid having " +
            "them slip out of your hands.";

    public long leg_Curl_L_G_Id;
    private String leg_Curl_L_G_Procedure = "";

    public long leg_Extension_L_G_Id;
    private String leg_Extension_L_G_Procedure = "";

    public long dead_Lift_L_G_Id;
    private String dead_Lift_L_G_Procedure = "";

    // Gym Back
    public long lat_Pulldown_B_G_Id;
    private String lat_Pulldown_B_G_Procedure = "Materials needed:\n\n" +
            "- Lat pulldown machine\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Sit down on a pull-down machine with a wide bar attached to the top pulley. Make " +
            "sure that you adjust the knee pad of the machine to fit your height. These pads will " +
            "prevent your body from being raised by the resistance attached to the bar.\n\n" +

            "2. Grab the bar with the palms facing forward using the prescribed grip. Note on " +
            "grips: For a wide grip, your hands need to be spaced out at a distance wider than " +
            "your shoulder width. For a medium grip, your hands need to be spaced out at a distance " +
            "equal to your shoulder width and for a close grip at a distance smaller than your " +
            "shoulder width.\n\n" +

            "3. As you have both arms extended in front of you - while holding the bar at the " +
            "chosen grip width - bring your torso back around 30 degrees or so while creating a " +
            "curvature on your lower back and sticking your chest out. This is your starting position.\n\n" +

            "4. As you breathe out, bring the bar down until it touches your upper chest by drawing " +
            "the shoulders and the upper arms down and back. Tip: Concentrate on squeezing the back " +
            "muscles once you reach the full contracted position. The upper torso should remain " +
            "stationary (only the arms should move). The forearms should do no other work except " +
            "for holding the bar; therefore do not try to pull the bar down using the forearms.\n\n" +

            "5. After a second in the contracted position, while squeezing your shoulder blades " +
            "together, slowly raise the bar back to the starting position when your arms are fully " +
            "extended and the lats are fully stretched. Inhale during this portion of the movement.\n\n" +

            "6. Repeat this motion for the prescribed amount of repetitions.\n\n" +

            "Variations: The behind-the-neck variation is not recommended as it can be hard on the " +
            "rotator cuff due to the hyperextension created by bringing the bar behind the neck.";

    public long single_Arm_Dumbbell_Row_B_G_Id;
    private String single_Arm_Dumbbell_Row_B_G_Procedure = "";

    public long side_Lateral_Raises_B_G_Id;
    private String side_Lateral_Raises_B_G_Procedure = "Materials needed:\n\n" +
            "- Weighted Dumbbell\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Pick a couple of dumbbells and stand with a straight torso and the dumbbells by " +
            "your side at arms length with the palms of the hand facing you. This will be " +
            "your starting position.\n\n" +

            "2. While maintaining the torso in a stationary position (no swinging), lift the " +
            "dumbbells to your side with a slight bend on the elbow and the hands slightly " +
            "tilted forward as if pouring water in a glass. Continue to go up until you arms " +
            "are parallel to the floor. Exhale as you execute this movement and pause for a " +
            "second at the top.\n\n" +

            "3. Lower the dumbbells back down slowly to the starting position as you inhale.\n\n" +

            "4. Repeat for the recommended amount of repetitions.\n\n" +

            "Variation: This exercise can also be performed sitting down.";

    public long weighted_Shrugs_B_G_Id;
    private String weighted_Shrugs_B_G_Procedure = "Materials needed:\n\n" +
            "- Weighted Dumbbell\n" +
            "- (optional) Weighted barbell\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Stand up straight with your feet at shoulder width as you hold a barbell with both " +
            "hands in front of you using a pronated grip (palms facing the thighs).\n" +
            "Tip: Your hands should be a little wider than shoulder width apart. You can use wrist " +
            "wraps for this exercise for a better grip. This will be your starting position.\n\n" +

            "2. Raise your shoulders up as far as you can go as you breathe out and hold the " +
            "contraction for a second. Tip: Refrain from trying to lift the barbell by using your biceps.\n\n" +

            "3. Slowly return to the starting position as you breathe in.\n\n" +

            "4. Repeat for the recommended amount of repetitions.\n\n" +

            "Variations: You can also rotate your shoulders as you go up, going in a semicircular " +
            "motion from front to rear. However this version is not good for people with shoulder problems. " +
            "In addition, this exercise can be performed with the barbell behind the back, with " +
            "dumbbells by the side, a smith machine or with a shrug machine.";

    public long bent_Over_Row_B_G_Id;
    private String bent_Over_Row_B_G_Procedure = "Materials needed:\n\n" +
            "- Weighted barbell\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Holding a barbell with a pronated grip (palms facing down), bend your knees slightly " +
            "and bring your torso forward, by bending at the waist, while keeping the back straight " +
            "until it is almost parallel to the floor. Tip: Make sure that you keep the head up. " +
            "The barbell should hang directly in front of you as your arms hang perpendicular to " +
            "the floor and your torso. This is your starting position.\n\n" +

            "2. Now, while keeping the torso stationary, breathe out and lift the barbell to you. " +
            "Keep the elbows close to the body and only use the forearms to hold the weight. At the " +
            "top contracted position, squeeze the back muscles and hold for a brief pause.\n\n" +

            "3. Then inhale and slowly lower the barbell back to the starting position.\n\n" +

            "4. Repeat for the recommended amount of repetitions.\n\n" +

            "Caution: This exercise is not recommended for people with back problems. A Low Pulley " +
            "Row is a better choice for people with back issues. Also, just like with the bent knee " +
            "dead-lift, if you have a healthy back, ensure perfect form and never slouch the back " +
            "forward as this can cause back injury.\n" +
            "Be cautious as well with the weight used; in case of doubt, use less weight rather than more.\n\n" +

            "Variations: You can perform the same exercise using a supinated (palms facing you) grip.";

    public long military_Press_B_G_Id;
    private String military_Press_B_G_Procedure = "Materials needed:\n\n" +
            "- Weighted Dumbbell\n" +
            "- (optional) Weighted barbell\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Start by placing a barbell that is about chest high on a squat rack. Once you have " +
            "selected the weights, grab the barbell using a pronated (palms facing forward) grip. " +
            "Make sure to grip the bar wider than shoulder width apart from each other.\n\n" +

            "2. Slightly bend the knees and place the barbell on your collar bone. Lift the barbell " +
            "up keeping it lying on your chest. Take a step back and position your feet shoulder " +
            "width apart from each other.\n\n" +

            "3. Once you pick up the barbell with the correct grip length, lift the bar up over " +
            "your head by locking your arms. Hold at about shoulder level and slightly in front " +
            "of your head. This is your starting position.\n\n" +

            "4. Lower the bar down to the collarbone slowly as you inhale.\n\n" +

            "5. Lift the bar back up to the starting position as you exhale.\n\n" +

            "6. Repeat for the recommended amount of repetitions.\n\n" +

            "Variations:\n" +
            "• This exercise can also be performed sitting as those with lower back problems " +
            "are better off performing this seated variety.\n" +
            "• The behind the neck variation is not recommended for people with shoulder " +
            "problems as it can be hard on the rotator cuff due to the hyperextension created " +
            "by bringing the bar behind the neck.\n" +
            "• Another option is to use dumbbells when performing this exercise for better isolation.";

    public long reverse_Flies_B_G_Id;
    private String reverse_Flies_B_G_Procedure = "Materials needed:\n\n" +
            "- Weighted Dumbbell\n\n\n" +
            "                                   Instructions\n\n" +
            "1. To begin, stand up with your back at a 45 degree angle with a slight bend in your " +
            "knees or you can lie down on an incline bench with the chest and stomach pressing " +
            "against the incline. Have the dumbbells in each hand with the palms facing each " +
            "other (neutral grip).\n\n" +

            "2. Extend the arms in front of you so that they are perpendicular to the angle of your " +
            "back or the bench. The legs should be stationary while applying pressure with the ball " +
            "of your toes. This is the starting position.\n\n" +

            "3. Maintaining the slight bend of the elbows, move the weights out and away from each " +
            "other (to the side) in an arc motion while exhaling. Tip: Try to squeeze your shoulder " +
            "blades together to get the best results from this exercise.\n\n" +

            "4. The arms should be elevated until they are parallel to the floor.\n\n" +

            "5. Feel the contraction and slowly lower the weights back down to the starting position " +
            "while inhaling.\n\n" +

            "6. Repeat for the recommended amount of repetitions.";

    // Gym Chest
    public long bench_Press_C_G_Id;
    private String bench_Press_C_G_Procedure = "Materials needed:\n\n" +
            "- Weighted barbell\n" +
            "- Flat bench\n" +
            "- Rack for barbell\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Lie back on a flat bench. Using a medium width grip (a grip that creates a 90- " +
            "degree angle in the middle of the movement between the forearms and the upper arms), " +
            "lift the bar from the rack and hold it straight over you with your arms locked. " +
            "This will be your starting position.\n\n" +

            "2. From the starting position, breathe in and begin coming down slowly until the bar " +
            "touches your middle chest.\n\n" +

            "3. After a brief pause, push the bar back to the starting position as you breathe " +
            "out. Focus on pushing the bar using your chest muscles. Lock your arms and squeeze " +
            "your chest in the contracted position at the top of the motion, hold for a second " +
            "and then start coming down slowly again. Tip: Ideally, lowering the weight should " +
            "take about twice as long as raising it.\n\n" +

            "4. Repeat the movement for the prescribed amount of repetitions.\n\n" +

            "5. When you are done, place the bar back in the rack.\n\n" +

            "Caution:\n" +
            "If you are new at this exercise, it is advised that you use a spotter. If no spotter " +
            "is available, then be conservative with the amount of weight used.\n" +
            "Also, beware of letting the bar drift too far forward. You want the bar to touch your " +
            "middle chest and nowhere else.\n" +
            "Don't bounce the weight off your chest. You should be in full control of the barbell " +
            "at all times.";

    public long dumbbell_Bench_Press_C_G_Id;
    private String dumbbell_Bench_Press_C_G_Procedure = "";

    public long incline_Dumbbell_Press_C_G_Id;
    private String incline_Dumbbell_Press_C_G_Procedure = "Materials needed:\n\n" +
            "- Weighted dumbbells\n" +
            "- Flat bench\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Lie back on an incline bench with a dumbbell in each hand atop your thighs. The " +
            "palms of your hands will be facing each other.\n\n" +

            "2. Then, using your thighs to help push the dumbbells up, lift the dumbbells one at " +
            "a time so that you can hold them at shoulder width.\n\n" +

            "3. Once you have the dumbbells raised to shoulder width, rotate your wrists forward " +
            "so that the palms of your hands are facing away from you. This will be your " +
            "starting position.\n\n" +

            "4. Be sure to keep full control of the dumbbells at all times. Then breathe out and " +
            "push the dumbbells up with your chest.\n\n" +

            "5. Lock your arms at the top, hold for a second, and then start slowly lowering " +
            "the weight. Tip Ideally, lowering the weights should take about twice as long as " +
            "raising them.\n\n" +

            "6. Repeat the movement for the prescribed amount of repetitions.\n\n" +

            "7. When you are done, place the dumbbells back on your thighs and then on the\n\n" +
            "floor. This is the safest manner to release the dumbbells.\n\n" +

            "Variations: You can use several angles on the incline bench if the bench you " +
            "are using is adjustable.\n" +
            "Another variation of this exercise is to perform it with the palms of the " +
            "hands facing each other.\n" +
            "Also, you can perform the exercise with the palms facing each other and then twisting " +
            "the wrist as you lift the dumbbells so that at the top of the movement the palms " +
            "are facing away from the body. I personally do not use this variation very often as " +
            "it seems to be hard on my shoulders.";

    public long decline_Dumbbell_Press_C_G_Id;
    private String decline_Dumbbell_Press_C_G_Procedure = "";


    // Home Arms
    public long band_Basic_Curl_A_H_Id;
    private String band_Basic_Curl_A_H_Procedure = "";

    public long band_Hammer_Curl_A_H_Id;
    private String band_Hammer_Curl_A_H_Procedure = "";

    public long chair_Dips_A_H_Id;
    private String chair_Dips_A_H_Procedure;

    public long band_Tricep_Extension_A_H_Id;
    private String band_Tricep_Extension_A_H_Procedure = "";

    public long band_Forearm_Curl_A_H_Id;
    private String band_Forearm_Curl_A_H_Procedure = "";

    public long band_Tricep_Pulldown_A_H_Id;
    private String band_Tricep_Pulldown_A_H_Procedure = "";

    // Home Legs
    public long air_Squats_L_H_Id;
    private String air_Squats_L_H_Procedure = "";

    public long lunges_L_H_Id;
    private String lunges_L_H_Procedure = "";

    public long stair_Calf_Raises_L_H_Id;
    private String stair_Calf_Raises_L_H_Procedure = "";

    public long jump_Rope_L_H_Id;
    private String jump_Rope_L_H_Procedure = "Materials needed:\n\n" +
            "- Jump Rope\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Hold an end of the rope in each hand. Position the rope behind you on the ground. " +
            "Raise your arms up and turn the rope over your head bringing it down in front of you. " +
            "When it reaches the ground, jump over it. Find a good turning pace that can be maintained. " +
            "Different speeds and techniques can be used to introduce variation.\n\n" +

            "2. Rope jumping is exciting, challenges your coordination, and requires a lot of energy. " +
            "A 150 lb person will burn about 350 calories jumping rope for 30 minutes, compared to " +
            "over 450 calories running.";

    // Home Back
    public long closeGrip_Pullup_B_H_Id;
    private String closeGrip_Pullup_B_H_Procedure = "";

    public long wideGrip_Pullup_B_H_Id;
    private String wideGrip_Pullup_B_H_Procedure = "";

    public long band_lat_Pulldown_B_H_Id;
    private String band_lat_Pulldown_B_H_Procedure = "";

    public long band_Sitting_Row_B_H_Id;
    private String band_Sitting_Row_B_H_Procedure = "";

    public long band_Military_Press_B_H_Id;
    private String band_Military_Press_B_H_Procedure = "";

    public long band_Shrugs_B_H_Id;
    private String band_Shrugs_B_H_Procedure = "";

    // Home Chest
    public long wide_Pushup_C_H_Id;
    private String wide_Pushup_C_H_Procedure = "";

    public long diamond_Pushup_C_H_Id;
    private String diamond_Pushup_C_H_Procedure = "";

    public long decline_Pushup_C_H_Id;
    private String decline_Pushup_C_H_Procedure = "Materials needed:\n\n" +
            "- Flat bench\n\n\n" +
            "                                   Instructions\n\n" +
            "1. Lie on the floor face down and place your hands about 36 inches apart while " +
            "holding your torso up at arms length. Move your feet up to a box or bench. This " +
            "will be your starting position.\n\n" +

            "2. Next, lower yourself downward until your chest almost touches the floor as " +
            "you inhale.\n\n" +

            "3. Now breathe out and press your upper body back up to the starting position " +
            "while squeezing your chest.\n\n" +

            "4. After a brief pause at the top contracted position, you can begin to lower " +
            "yourself downward again for as many repetitions as needed.";

    public long band_Bench_Press_C_H_Id;
    private String band_Bench_Press_C_H_Procedure = "";

    // Ab workouts
    public long crunches_Ab_G_Id;
    public long crunches_Ab_H_Id;
    private String crunches_Ab_Procedure = "";

    public long leg_Raises_Ab_G_Id;
    public long leg_Raises_Ab_H_Id;
    private String leg_Raises_Ab_Procedure = "";

    public long russian_Twist_Ab_G_Id;
    public long russian_Twist_Ab_H_Id;
    private String russian_Twist_Ab_Procedure = "";

    public long broom_Stick_Twist_Ab_G_Id;
    public long broom_Stick_Twist_Ab_H_Id;
    private String broom_Stick_Twist_Ab_Procedure = "";


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
        Workout_List arms_H = new Workout_List(101, "Arms", 1001, "armsicon");
        Workout_List legs_H = new Workout_List(102, "Legs", 1001, "legsicon");
        Workout_List back_H = new Workout_List(103, "Back", 1001, "backicon");
        Workout_List chest_H = new Workout_List(104, "Chest", 1001, "chesticon");
        Workout_List ab_H = new Workout_List(105, "Ab", 1001, "abbicon");

        arms_H_Id = db.insert_Workout_List(arms_H, home_id);
        legs_H_Id = db.insert_Workout_List(legs_H, home_id);
        back_H_Id = db.insert_Workout_List(back_H, home_id);
        chest_H_Id = db.insert_Workout_List(chest_H, home_id);
        ab_H_Id = db.insert_Workout_List(ab_H, home_id);

        // Add gym workout groups
        Workout_List arms_G = new Workout_List(205, "Arms", 1002, "armsicon");
        Workout_List legs_G = new Workout_List(206, "Legs", 1002, "legsicon");
        Workout_List back_G = new Workout_List(207, "Back", 1002, "backicon");
        Workout_List chest_G = new Workout_List(208, "Chest", 1002, "chesticon");
        Workout_List ab_G = new Workout_List(209, "Ab", 1002, "abbicon");

        arms_G_Id = db.insert_Workout_List(arms_G, gym_id);
        legs_G_Id = db.insert_Workout_List(legs_G, gym_id);
        back_G_Id = db.insert_Workout_List(back_G, gym_id);
        chest_G_Id = db.insert_Workout_List(chest_G, gym_id);
        ab_G_Id = db.insert_Workout_List(ab_G, gym_id);
    }

    public void fill_Workout_Table() {

        // Add gym arm workouts
        Workout basic_Curl_A_G = new Workout(1, "Consentration Curl", 205, basic_Curl_A_G_Procedure, "bicepcurl");
        Workout hammer_Curl_A_G = new Workout(2, "Hammer Curl", 205, hammer_Curl_A_G_Procedure, "hammercurl");
        Workout dips_A_G = new Workout(3, "Dips", 205, dips_A_G_Procedure, "dips");
        Workout tricep_Extension_A_G = new Workout(4, "Tricep Extension", 205, tricep_Extension_A_G_Procedure, "tricepextention");
        Workout forearm_Curl_A_G = new Workout(5, "Forearm Curl", 205, forearm_Curl_A_G_Procedure, "forearmcurl");
        Workout weighted_Windup_A_G = new Workout(6, "Weighted Windup", 205, weighted_Windup_A_G_Procedure, "weightedwindup");

        basic_Curl_A_G_Id = db.insert_Workout(basic_Curl_A_G, arms_G_Id);
        hammer_Curl_A_G_Id = db.insert_Workout(hammer_Curl_A_G, arms_G_Id);
        dips_A_G_Id = db.insert_Workout(dips_A_G, arms_G_Id);
        tricep_Extension_A_G_Id = db.insert_Workout(tricep_Extension_A_G, arms_G_Id);
        forearm_Curl_A_G_Id = db.insert_Workout(forearm_Curl_A_G, arms_G_Id);
        weighted_Windup_A_G_Id = db.insert_Workout(weighted_Windup_A_G, arms_G_Id);

        // Add gym leg workouts
        Workout squats_L_G = new Workout(7, "Squats", 206, squats_L_G_Procedure, null);
        Workout leg_Press_L_G = new Workout(8, "Leg Press", 206, leg_Press_L_G_Procedure, null);
        Workout calf_Raises_L_G = new Workout(9, "Calf Raises", 206, calf_Raises_L_G_Procedure, "calfraise");
        Workout leg_Curl_L_G = new Workout(10, "Leg Curl", 206, leg_Curl_L_G_Procedure, null);
        Workout leg_Extension_L_G = new Workout(11, "Leg Extension", 206, leg_Extension_L_G_Procedure, null);
        Workout dead_Lift_L_G = new Workout(12, "Dead Lift", 206, dead_Lift_L_G_Procedure, null);

        squats_L_G_Id = db.insert_Workout(squats_L_G, legs_G_Id);
        leg_Press_L_G_Id = db.insert_Workout(leg_Press_L_G, legs_G_Id);
        calf_Raises_L_G_Id = db.insert_Workout(calf_Raises_L_G, legs_G_Id);
        leg_Curl_L_G_Id = db.insert_Workout(leg_Curl_L_G, legs_G_Id);
        leg_Extension_L_G_Id = db.insert_Workout(leg_Extension_L_G, legs_G_Id);
        dead_Lift_L_G_Id = db.insert_Workout(dead_Lift_L_G, legs_G_Id);

        // Add gym back workouts
        Workout lat_Pulldown_B_G = new Workout(13, "Lateral Pulldown", 207, lat_Pulldown_B_G_Procedure, "latpulldown");
        Workout bent_Over_Row_B_G = new Workout(14, "Bent Over Row", 207, bent_Over_Row_B_G_Procedure, "bentoverrow");
        Workout single_Arm_Dumbbell_Row_B_G = new Workout(15, "Single-Arm Dumbbell Row", 207, single_Arm_Dumbbell_Row_B_G_Procedure, null);
        Workout weighted_Shrugs_B_G = new Workout(16, "Weighted Shrugs", 207, weighted_Shrugs_B_G_Procedure, "shrugs");
        Workout reverse_Flies_B_G = new Workout(17, "Reverse Flies", 207, reverse_Flies_B_G_Procedure, "reverseflys");
        Workout military_Press_B_G = new Workout(18, "Military Press", 207, military_Press_B_G_Procedure, "militarypress");
        Workout side_Lateral_Raises_B_G = new Workout(19, "Side Lateral Raises", 207, side_Lateral_Raises_B_G_Procedure, "sidelateralraises");

        lat_Pulldown_B_G_Id = db.insert_Workout(lat_Pulldown_B_G, back_G_Id);
        bent_Over_Row_B_G_Id = db.insert_Workout(bent_Over_Row_B_G, back_G_Id);
        single_Arm_Dumbbell_Row_B_G_Id = db.insert_Workout(single_Arm_Dumbbell_Row_B_G, back_G_Id);
        weighted_Shrugs_B_G_Id = db.insert_Workout(weighted_Shrugs_B_G, back_G_Id);
        reverse_Flies_B_G_Id = db.insert_Workout(reverse_Flies_B_G, back_G_Id);
        military_Press_B_G_Id = db.insert_Workout(military_Press_B_G, back_G_Id);
        side_Lateral_Raises_B_G_Id = db.insert_Workout(side_Lateral_Raises_B_G, back_G_Id);

        // Add gym chest workouts
        Workout bench_Press_C_G = new Workout(20, "Bench Press", 208, bench_Press_C_G_Procedure, "benchpress");
        Workout dumbbell_Bench_Press_C_G = new Workout(21, "Dumbbell Bench Press", 208, dumbbell_Bench_Press_C_G_Procedure, null);
        Workout incline_Dumbbell_Press_C_G = new Workout(22, "Incline Dumbbell Press", 208, incline_Dumbbell_Press_C_G_Procedure, "inclineddumbbellpress");
        Workout decline_Dumbbell_Press_C_G = new Workout(23, "Decline Dumbbell Press", 208, decline_Dumbbell_Press_C_G_Procedure, null);

        bench_Press_C_G_Id = db.insert_Workout(bench_Press_C_G, chest_G_Id);
        dumbbell_Bench_Press_C_G_Id = db.insert_Workout(dumbbell_Bench_Press_C_G, chest_G_Id);
        incline_Dumbbell_Press_C_G_Id = db.insert_Workout(incline_Dumbbell_Press_C_G, chest_G_Id);
        decline_Dumbbell_Press_C_G_Id = db.insert_Workout(decline_Dumbbell_Press_C_G, chest_G_Id);



        // Add home arm workouts
        Workout band_Basic_Curl_A_H = new Workout(24, "Band Basic Curl", 101, band_Basic_Curl_A_H_Procedure, null);
        Workout band_Hammer_Curl_A_H = new Workout(25, "Band Hammer Curl", 101, band_Hammer_Curl_A_H_Procedure, null);
        Workout chair_Dips_A_H = new Workout(26, "Chair Dips", 101, chair_Dips_A_H_Procedure, null);
        Workout band_Tricep_Extension_A_H = new Workout(27, "Band Tricep Extension", 101, band_Tricep_Extension_A_H_Procedure, null);
        Workout band_Forearm_Curl_A_H = new Workout(28, "Band Forearm Curl", 101, band_Forearm_Curl_A_H_Procedure, null);
        Workout band_Tricep_Pulldown_A_H = new Workout(29, "Band Tricep Pulldown", 101, band_Tricep_Pulldown_A_H_Procedure, null);

        band_Basic_Curl_A_H_Id = db.insert_Workout(band_Basic_Curl_A_H, arms_H_Id);
        band_Hammer_Curl_A_H_Id = db.insert_Workout(band_Hammer_Curl_A_H, arms_H_Id);
        chair_Dips_A_H_Id = db.insert_Workout(chair_Dips_A_H, arms_H_Id);
        band_Tricep_Extension_A_H_Id = db.insert_Workout(band_Tricep_Extension_A_H, arms_H_Id);
        band_Forearm_Curl_A_H_Id = db.insert_Workout(band_Forearm_Curl_A_H, arms_H_Id);
        band_Tricep_Pulldown_A_H_Id = db.insert_Workout(band_Tricep_Pulldown_A_H, arms_H_Id);

        // Add home leg workouts
        Workout air_Squats_L_H = new Workout(30, "Air Squats/Band Squats", 102, air_Squats_L_H_Procedure, null);
        Workout lunges_L_H = new Workout(31, "Lunges", 102, lunges_L_H_Procedure, null);
        Workout stair_Calf_Raises_L_H = new Workout(32, "Stair Calf Raises", 102, stair_Calf_Raises_L_H_Procedure, null);
        Workout jump_Rope_L_H = new Workout(33, "Jump Rope", 102, "Coming Soon", null);

        air_Squats_L_H_Id = db.insert_Workout(air_Squats_L_H, legs_H_Id);
        lunges_L_H_Id = db.insert_Workout(lunges_L_H, legs_H_Id);
        stair_Calf_Raises_L_H_Id = db.insert_Workout(stair_Calf_Raises_L_H, legs_H_Id);
        jump_Rope_L_H_Id = db.insert_Workout(jump_Rope_L_H, legs_H_Id);

        // Add home back workouts
        Workout closeGrip_Pullup_B_H = new Workout(34, "Close-Grip Pull-Up", 103, closeGrip_Pullup_B_H_Procedure, null);
        Workout wideGrip_Pullup_B_H = new Workout(35, "Wide-Grip Pull-Up", 103, wideGrip_Pullup_B_H_Procedure, null);
        Workout band_lat_Pulldown_B_H = new Workout(36, "Band Lat Pulldown", 103, band_lat_Pulldown_B_H_Procedure, null);
        Workout band_Sitting_Row_B_H = new Workout(37, "Band Sitting Row", 103, band_Sitting_Row_B_H_Procedure, null);
        Workout band_Military_Press_B_H = new Workout(38, "Band Military Press", 103, band_Military_Press_B_H_Procedure, null);
        Workout band_Shrugs_B_H = new Workout(39, "Band Shrugs", 103, band_Shrugs_B_H_Procedure, null);

        closeGrip_Pullup_B_H_Id = db.insert_Workout(closeGrip_Pullup_B_H, back_H_Id);
        wideGrip_Pullup_B_H_Id = db.insert_Workout(wideGrip_Pullup_B_H, back_H_Id);
        band_lat_Pulldown_B_H_Id = db.insert_Workout(band_lat_Pulldown_B_H, back_H_Id);
        band_Sitting_Row_B_H_Id = db.insert_Workout(band_Sitting_Row_B_H, back_H_Id);
        band_Military_Press_B_H_Id = db.insert_Workout(band_Military_Press_B_H, back_H_Id);
        band_Shrugs_B_H_Id = db.insert_Workout(band_Shrugs_B_H, back_H_Id);

        // Add home chest workouts
        Workout wide_Pushup_C_H = new Workout(40, "Wide Push-Up", 104, wide_Pushup_C_H_Procedure, null);
        Workout diamond_Pushup_C_H = new Workout(41, "Diamond Push-Up", 104, diamond_Pushup_C_H_Procedure, null);
        Workout decline_Pushup_C_H = new Workout(42, "Decline Push-Up", 104, decline_Pushup_C_H_Procedure, null);
        Workout band_Bench_Press_C_H = new Workout(43, "Band Bench Press", 104, band_Bench_Press_C_H_Procedure, null);

        wide_Pushup_C_H_Id = db.insert_Workout(wide_Pushup_C_H, chest_H_Id);
        diamond_Pushup_C_H_Id = db.insert_Workout(diamond_Pushup_C_H, chest_H_Id);
        decline_Pushup_C_H_Id = db.insert_Workout(decline_Pushup_C_H, chest_H_Id);
        band_Bench_Press_C_H_Id = db.insert_Workout(band_Bench_Press_C_H, chest_H_Id);


        // Add gym ab workouts
        Workout crunches_Ab_G = new Workout(44, "Crunches", 209, crunches_Ab_Procedure, "crunches");
        Workout leg_Raises_Ab_G = new Workout(45, "Leg Raises", 209, leg_Raises_Ab_Procedure, "legraises");
        Workout russian_Twist_Ab_G = new Workout(46, "Russian Twist", 209, russian_Twist_Ab_Procedure, "russiantwist");
        Workout broom_Stick_Twist_Ab_G = new Workout(47, "Broom Stick Twist", 209, broom_Stick_Twist_Ab_Procedure, "broomsticktwist");

        crunches_Ab_G_Id = db.insert_Workout(crunches_Ab_G, ab_G_Id);
        leg_Raises_Ab_G_Id = db.insert_Workout(leg_Raises_Ab_G, ab_G_Id);
        russian_Twist_Ab_G_Id = db.insert_Workout(russian_Twist_Ab_G, ab_G_Id);
        broom_Stick_Twist_Ab_G_Id = db.insert_Workout(broom_Stick_Twist_Ab_G, ab_G_Id);


        // Add home ab workouts
        Workout crunches_Ab_H = new Workout(48, "Crunches", 105, crunches_Ab_Procedure, "crunches");
        Workout leg_Raises_Ab_H = new Workout(49, "Leg Raises", 105, leg_Raises_Ab_Procedure, "legraises");
        Workout russian_Twist_Ab_H = new Workout(50, "Russian Twist", 105, russian_Twist_Ab_Procedure, "russiantwist");
        Workout broom_Stick_Twist_Ab_H = new Workout(51, "Broom Stick Twist", 105, broom_Stick_Twist_Ab_Procedure, "broomsticktwist");

        crunches_Ab_H_Id = db.insert_Workout(crunches_Ab_H, ab_H_Id);
        leg_Raises_Ab_H_Id = db.insert_Workout(leg_Raises_Ab_H, ab_H_Id);
        russian_Twist_Ab_H_Id = db.insert_Workout(russian_Twist_Ab_H, ab_H_Id);
        broom_Stick_Twist_Ab_H_Id = db.insert_Workout(broom_Stick_Twist_Ab_H, ab_H_Id);
    }

}
