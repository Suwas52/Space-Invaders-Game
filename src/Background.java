import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Background extends JPanel {
    private JLabel scoreLabel;



    Main game = new Main();

    public GameOver gameOver = new GameOver();

    public Spaceship spaceShip = new Spaceship();
    public Stars stars = new Stars();
    public AlienGroups groupAliens = new AlienGroups();
    public ShipBullet shipBullet = new ShipBullet();

    public AlienBullet alienBullet1, alienBullet2, alienBullet3;



    public int score = 0;
    private Font gameOverFont = new Font("Arial", Font.BOLD, 80);


    public Background() {
        super();
        //scorelable
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        scoreLabel.setBounds(10, 10, 150, 30);


        this.add(scoreLabel);

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Keyboard());
        Thread timer = new Thread(new Time());
        timer.start();





    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the color to black
        g.setColor(Color.BLACK);
        // Fill the entire panel with black
        g.fillRect(0, 0, getWidth(), getHeight());


        //Star Genereate
        g.setColor(Color.WHITE);
        for (int i = 0; i < Constants.NUM_CIRCLES; i++) {
            if (Constants.blink[i]) {
                g.fillOval(Constants.xC[i], Constants.yC[i], Constants.CIRCLE_SIZE, Constants.CIRCLE_SIZE);
            }
        }

        //Design SpaceShip
        this.spaceShip.DesignAlienShip(g);

        this.groupAliens.designAlien(g);

        //Drawing of Bullet
        this.shipBullet.DrawingBullet(g);

        // Detect shipShot contact with alien
        this.groupAliens.ShipBulletTouchAlien(this.shipBullet);


        //Drawing Alien bullet

        if(Time.countSteps % 900 == 0) {
            alienBullet1 = new AlienBullet(this.groupAliens.AlienRandomShot());}
        if(this.alienBullet1 != null) {
            this.alienBullet1.DrawingShootingAlien(g);
            if(this.alienBullet1.shipkey(spaceShip) == true) {this.spaceShip.setAlive(false);}
        }

        if(Time.countSteps % 1000 == 0) {
            alienBullet2 = new AlienBullet(this.groupAliens.AlienRandomShot());}
        if(this.alienBullet2 != null) {
            this.alienBullet2.DrawingShootingAlien(g);
            if(this.alienBullet2.shipkey(spaceShip) == true) {
                this.spaceShip.setAlive(false);}

        }

        if(Time.countSteps % 1200 == 0) {
            alienBullet3 = new AlienBullet(this.groupAliens.AlienRandomShot());}
        if(this.alienBullet3 != null) {
            this.alienBullet3.DrawingShootingAlien(g);
            if(this.alienBullet3.shipkey(spaceShip) == true) {
                this.spaceShip.setAlive(false);}

        }

        if(this.groupAliens.getAlienNumber() == 0) {groupAliens = new AlienGroups();}


        if(this.groupAliens.positionAlienLowest() > Constants.Y_POSITION_Spaceship) {this.spaceShip.destructionSpaceShip();}

        scoreLabel.setText("Score: " +score);

        if(this.spaceShip.isAlive() == false) {


            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Main.background);
            currentFrame.dispose();
             gameOver = new GameOver();
            gameOver.main(new String[0]);

        }

    }
}