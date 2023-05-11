import javax.swing.*;
import java.util.Objects;

public class Alien extends Entities {
    public Alien(int xPos, int yPos, String strImg1, String strImg2 ) {


        //Super class variable initialization
        super.xPos = xPos;
        super.yPos = yPos;
        super.width = Constants.WIDTH_ENEMY;
        super.height = Constants.HEIGHT_ENEMY;
        super.dx = 0;
        super.dy = 0;
        super.alive = true;

       // SpaceShip images address
        super.strImg1 = strImg1;
        super.strImg2 = strImg2;
        super.strImg3 = "/Resources/destroyAlien.png";

        //Loading Ship Image
        super.imgIcon = new ImageIcon(getClass().getResource(super.strImg1));
        super.img = this.imgIcon.getImage();

    }

    public void choiceImage(boolean pos1) {
        // Method that loads the alien's image according to its position (1 or 2)
        if(this.alive == true) {
            if(pos1 == true)
            {
                super.imgIcon = new ImageIcon(getClass().getResource(strImg1));
            }
            else {
                super.imgIcon = new ImageIcon(getClass().getResource(strImg2));
            }
        }
        else {
            super.imgIcon = new ImageIcon(getClass().getResource(strImg3));
        }
        super.img = this.imgIcon.getImage();  // reload the image
    }


}
