package ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell;

public class GameSettings {

<<<<<<< HEAD
    public static final int SCREEN_WIDTH = 720;
    public static final int SCREEN_HEIGHT = 1280;

=======
    // Device settings

    public static final int SCREEN_WIDTH = 720;
    public static final int SCREEN_HEIGHT = 1280;

    // Physics settings

>>>>>>> f85ea08e922905eb3281ceb08540506d20a8979e
    public static final float STEP_TIME = 1f / 60f;
    public static final int VELOCITY_ITERATIONS = 6;
    public static final int POSITION_ITERATIONS = 6;
    public static final float SCALE = 0.05f;

<<<<<<< HEAD
    public static float TRASH_FORCE_RATIO = 10;
    public static float SHIP_VELOCITY = 20;
    public static float ENEMY_BULLET_VELOCITY = -75;
    public static long STARTING_SHIP_APPEARANCE_COOL_DOWN = 2000;
    public static int BULLET_VELOCITY = 200;
    public static int SHOOTING_COOL_DOWN = 1000;
    public static int ENEMY_SHOOTING_COOL_DOWN = 1500;
    public static float BULLET_IMPULSE_FORCE = 5000;
=======
    public static float SHIP_FORCE_RATIO = 10;
    public static float TRASH_VELOCITY = 20;
    public static long STARTING_TRASH_APPEARANCE_COOL_DOWN = 2000; // in [ms] - milliseconds
    public static int BULLET_VELOCITY = 200; // in [m/s] - meter per second
    public static int SHOOTING_COOL_DOWN = 1000; // in [ms] - milliseconds
>>>>>>> f85ea08e922905eb3281ceb08540506d20a8979e

    public static final short TRASH_BIT = 2;
    public static final short SHIP_BIT = 4;
    public static final short BULLET_BIT = 8;
<<<<<<< HEAD
    public static final short ENEMY_BULLET_BIT = 16;
=======


    // Object sizes
>>>>>>> f85ea08e922905eb3281ceb08540506d20a8979e

    public static final int SHIP_WIDTH = 150;
    public static final int SHIP_HEIGHT = 150;
    public static final int TRASH_WIDTH = 140;
    public static final int TRASH_HEIGHT = 100;
<<<<<<< HEAD
    public static final int BULLET_WIDTH = 24;
    public static final int BULLET_HEIGHT = 72;
    public static final int ENEMY_BULLET_WIDTH = 15;
    public static final int ENEMY_BULLET_HEIGHT = 45;
=======
    public static final int BULLET_WIDTH = 15;
    public static final int BULLET_HEIGHT = 45;
>>>>>>> f85ea08e922905eb3281ceb08540506d20a8979e

}
