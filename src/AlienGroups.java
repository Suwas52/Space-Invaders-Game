


import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AlienGroups {

    //Variable

    // Table containing all aliens

    private final Alien[][] arrAlien = new Alien[5][10];
    private boolean goARight,pos1;
    private int speed;

    private int[] ArrDeathAlien = {-1,-1}; // Dead alien location in aliens array

    Random chance = new Random();


    private int numberAliens = Constants.NUMBER_ALIENS;
    private Rectangle spaceshipBoundingBox;

    public GameOver gameOver = new GameOver();


    //Constructor
    public AlienGroups() {
        this.initArrayAliens();
        this.goARight = true;
        this.pos1 = true;
        this.speed = Constants.ALIEN_SPEED;
        this.spaceshipBoundingBox = new Rectangle(Constants.X_POSITION_Spaceship, Constants.Y_POSITION_Spaceship, Constants.SPACESHIP_WIDTH, Constants.SPACESHIP_HEIGHT);
    }



    private void initArrayAliens() {
        //Method that fills the full array of aliens
        for(int i=0; i<10; i++) {
            this.arrAlien[0][i] = new Alien(Constants.X_POS_INIT_ENEMY + (Constants.WIDTH_ENEMY + Constants.GAP_COLUMNS_ALIEN) * i,
                    Constants.INIT_ALIEN, "/Resources/alien1.png", "/Resources/alien1.png");
            for(int j=1; j<3; j++) {
                this.arrAlien[j][i] = new Alien(Constants.X_POS_INIT_ENEMY + (Constants.WIDTH_ENEMY + Constants.GAP_COLUMNS_ALIEN) *
                        i, Constants.INIT_ALIEN + Constants.GAP_LINES_ALIEN * j, "/Resources/alien2.png", "/Resources/alien2.png");
            }
            for(int j=3; j<5; j++) {
                this.arrAlien[j][i] = new Alien(Constants.X_POS_INIT_ENEMY + (Constants.WIDTH_ENEMY + Constants.GAP_COLUMNS_ALIEN)
                        * i, Constants.INIT_ALIEN + Constants.GAP_LINES_ALIEN * j, "/Resources/alien3.png", "/Resources/alien3.png");
            }
        }
    }



    public void designAlien(Graphics g){
        if(Time.countSteps % (100 - 10 * this.speed) == 0) {this.displacementAliens();}
// Draw the aliens contained in the arrAlien array
        for(int i = 0; i <10; i++){
            for (int j =0; j<5;j++){
                if(this.arrAlien[j][i] != null) {
                    this.arrAlien[j][i].choiceImage(pos1);

                    g.drawImage(this.arrAlien[j][i].getImg(), this.arrAlien[j][i].getxPos(), this.arrAlien[j][i].getyPos(),
                            null);

                    Rectangle alienBoundingBox = new Rectangle(this.arrAlien[j][i].getxPos(), this.arrAlien[j][i].getyPos(), Constants.WIDTH_ENEMY, Constants.HEIGHT_ENEMY);

                    if (alienBoundingBox.intersects(spaceshipBoundingBox)) {

                        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Main.background);
                        currentFrame.dispose();
                        gameOver = new GameOver();
                        gameOver.main(new String[0]);

                    }
                }
            }

        }
    }

    private boolean LeftEdgeKey() {
        // Method that detects the left edge of the window
        boolean response = false;
        for(int i=0; i<10; i++) {
            for(int j=0; j<5; j++) {
                if(this.arrAlien[j][i] != null) {
                    if(this.arrAlien[j][i].getxPos() < Constants.Window_margin) {
                        response = true;
                        break;
                    }
                }
            }
        }
        return response;
    }

    private boolean rightEdgeKey() {
        // Method that detects the right edge of the window
        boolean response = false;
        for(int i=0; i<10; i++) {
            for(int j=0; j<5; j++) {
                if(this.arrAlien[j][i] != null) {
                    if(this.arrAlien[j][i].getxPos() >
                            Constants.Window_width - Constants.HEIGHT_ENEMY - Constants.DX_ENEMY - Constants.Window_margin) {
                        response = true;
                        break;
                    }
                }
            }
        }
        return response;
    }

    public void alienRotatesAndDescends() {
        // Method that changes the direction of movement of the alien and lowers it by one notch
        if(this.rightEdgeKey() == true) {
            for(int i=0; i<10; i++) {
                for(int j=0; j<5; j++) {
                    if (this.arrAlien[j][i] != null) {
                        this.arrAlien[j][i].setyPos(this.arrAlien[j][i].getyPos() + Constants.DY_ENEMY);
                    }
                }
            }
            this.goARight = false;
            if(this.speed < 9) {this.speed++;}
        } else {
            if(this.LeftEdgeKey() == true) {
                for(int i=0; i<10; i++) {
                    for(int j=0; j<5; j++) {
                        if (this.arrAlien[j][i] != null) {
                            this.arrAlien[j][i].setyPos(this.arrAlien[j][i].getyPos() + Constants.DY_ENEMY);
                        }
                    }
                }
                this.goARight = true;
                if(this.speed < 9) {this.speed++;}
            }
        }
    }

    public void displacementAliens() {
        // Method that manages the movement of aliens
        if(this.ArrDeathAlien[0] != -1) {
            EliminateAlienDeath(ArrDeathAlien);
            ArrDeathAlien[0] = -1;
        }
        if(this.goARight == true) {
            for(int i=0; i<10; i++) {
                for(int j=0; j<5; j++) {
                    if(this.arrAlien[j][i] != null) {
                        this.arrAlien[j][i].setxPos(this.arrAlien[j][i].getxPos() + Constants.DX_ENEMY);
                    }
                }

            }
        }else{// Move left
            for(int i=0; i<10; i++) {
                for(int j=0; j<5; j++) {
                    if (this.arrAlien[j][i] != null) {
                        this.arrAlien[j][i].setxPos(this.arrAlien[j][i].getxPos() - Constants.DX_ENEMY);
                    }
                }
            }
        }
        // Change the alien's image
        if(this.pos1 == true) {this.pos1 = false;}
        else {this.pos1 = true;}
        // Update the direction of movement if an alien reaches the edge of the window
        this.alienRotatesAndDescends();
    }


    public void ShipBulletTouchAlien(ShipBullet shipBullet) {
        // Detect shipBullet contact with alien
        for(int i=0; i<10; i++) {
            for(int j=0; j<5; j++) {
                if(this.arrAlien[j][i] != null) {

                    if(shipBullet.killAlien(this.arrAlien[j][i]) == true) {

                        this.arrAlien[j][i].alive = false; // We kill the alien
                        Main.background.score = Main.background.score + 2;
                        shipBullet.yPos = -1; // We kill the shot
                        // We save the position of the dead alien in the array
                        this.ArrDeathAlien[0] = j;
                        this.ArrDeathAlien[1] = i;




                    }

                }

            }
        }
    }

    private void EliminateAlienDeath(int[] ArrDeathAlien) {
// Method that removes the dead alien from the array (null box)
        this.arrAlien[ArrDeathAlien[0]][ArrDeathAlien[1]] = null;
        this.numberAliens--;

    }


    public int[] AlienRandomShot() {
        // Returns the position of an alien drawn at random in arrAlien at the bottom of its
        // column (row, column)
        int positionAlien[] = {-1,-1};
        if(this.numberAliens != 0) {
            do {int i = chance.nextInt(10);
                for(int j=4;j>=0;j--) {
                    if(arrAlien[j][i]!= null) {
                        positionAlien[0] = this.arrAlien[j][i].getxPos();
                        positionAlien[1] = this.arrAlien[j][i].getyPos();
                        break;
                    }
                }
            } while(positionAlien[0] == -1);



        }
        return positionAlien;
    }

    public int getAlienNumber() {return numberAliens;}

    public int positionAlienLowest() {
        // Return the altitude of the feet of the lowest alien
        int posBas = 0, posBasFinal = 0;
        for(int i=1; i<10;i++) {
            for(int j=4; j>=0;j--) {
                if(this.arrAlien[j][i] != null) {
                    posBas = this.arrAlien[j][i].yPos + this.arrAlien[j][i].height;
                    break;
                }
            }
            if(posBas > posBasFinal) {posBasFinal = posBas;}
        }
        return posBasFinal;
    }


}
