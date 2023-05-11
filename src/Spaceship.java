import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class Spaceship extends Entities {

    private int counter = 0;

    private Rectangle spaceshipBoundingBox;

    public Spaceship() {
        this.spaceshipBoundingBox = new Rectangle(Constants.X_POSITION_Spaceship, Constants.Y_POSITION_Spaceship, Constants.SPACESHIP_WIDTH, Constants.SPACESHIP_HEIGHT);
        super.xPos = Constants.X_POSITION_Spaceship;
        super.yPos = Constants.Y_POSITION_Spaceship;
        super.width = Constants.SPACESHIP_WIDTH;
        super.height = Constants.SPACESHIP_HEIGHT;
        super.dx = 0;
        super.dy = 0;

        super.strImg1 = "/Resources/Spaceship.png";
        super.strImg2 = "/Resources/DestroyShip.png";
        super.strImg3 = "/Resources/DestroyShip1.png";



        super.imgIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(super.strImg1)));
        super.img = this.imgIcon.getImage();
        super.alive = true;

    }

    public int movementSpaceShip() {

        if (this.dx < 0) {
            if (this.xPos > Constants.limit_left_ship) {
                this.xPos = this.xPos + this.dx;
            }
        } else if (dx > 0) {
            if (this.xPos + this.dx < Constants.limit_right_ship) {
                this.xPos = this.xPos + this.dx;
            }

        }
        return this.xPos;

    }

    public void DesignAlienShip(Graphics g){
        if(this.alive == false) {
            this.destructionSpaceShip();
        }
        g.drawImage(this.img,this.movementSpaceShip(), this.yPos, null);
    }


    public void destructionSpaceShip() {
        if(counter < 300) {
            if(Time.countSteps % 2 == 0) {super.imgIcon = new ImageIcon(getClass().getResource(super.strImg2));}
            else {super.imgIcon = new ImageIcon(getClass().getResource(super.strImg3));}
            counter++;
        }else {
            Main.game = false;
        }
        super.img = this.imgIcon.getImage();

    }





}
