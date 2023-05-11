public abstract class Constants {

    //Screen Size
    public static final int Window_height = 800;
    public static final int Window_width = 800;
    public static final int Window_margin = 50;

    //    Dimension of spaceship
    public static final int SPACESHIP_WIDTH = 55;
    public static final int SPACESHIP_HEIGHT = 60;

    //Position initial of Spaceship
    public final static int X_POSITION_Spaceship = (Window_width- SPACESHIP_WIDTH)/2;
    public final static int Y_POSITION_Spaceship = 650;

    //
    public final static int DX_Spaceship = 3;



    // Limit movement of spaceship
    public final static int limit_left_ship = 10;
    public final static int limit_right_ship = 710;

    //Star
    public static final int NUM_CIRCLES = 100;
    public static final int CIRCLE_SIZE = 2;

    public static int[] xC = new int[NUM_CIRCLES];

    public static int[] yC = new int[NUM_CIRCLES];

    public static boolean[] blink = new boolean[NUM_CIRCLES];


    // Dimensions of the alien
    public final static int WIDTH_ENEMY = 33;
    public final static int HEIGHT_ENEMY = 25;



    //Alien position parameters
    public final static int INIT_ALIEN = 50;
    public final static int X_POS_INIT_ENEMY = 20 + Window_margin;

    public final static int GAP_LINES_ALIEN = 40;

    public final static int GAP_COLUMNS_ALIEN = 10;

    // Unit of movement of the alien
    public final static int DX_ENEMY = 5;
    public final static int DY_ENEMY = 25;

    public static int ALIEN_SPEED = 9;

    public final static int NUMBER_ALIENS = 50;

    //Dimensions of Bullet
    public static final int SPACESHIP_BULLET_WIDTH = 5;
    public static final int SPACESHIP_BULLET_HEIGHT = 15;

    // Bullet movement unit
    public final static int DY_BULLET = 10;

    //ALIEN SHOOTING ************************************/
    // Dimensions of the shot
    public static final int ALIEN_BULLET_WIDTH = 5;
    public static final int ALIEN_BULLET_HEIGHT = 15;

    // Shot movement unit
    public final static int DY_BULLET_ALIEN = 6;


}
