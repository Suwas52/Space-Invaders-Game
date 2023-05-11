import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyboard implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(Main.background.spaceShip.isAlive() == true) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_RIGHT) {
                Main.background.spaceShip.setDx(Constants.DX_Spaceship);
            } else if (keyCode == KeyEvent.VK_LEFT) {
                Main.background.spaceShip.setDx(-Constants.DX_Spaceship);
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (Main.background.shipBullet.isShooting() == false) {
                    Main.background.shipBullet.setyPos(Constants.Y_POSITION_Spaceship - Constants.SPACESHIP_BULLET_HEIGHT);
                    Main.background.shipBullet.setxPos(Main.background.spaceShip.getxPos() + Constants.SPACESHIP_WIDTH / 2 - 1);
                    Main.background.shipBullet.setShooting(true);
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.background.spaceShip.setDx(0);
    }
}
