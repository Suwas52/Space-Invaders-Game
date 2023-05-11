import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

import static javax.swing.text.StyleConstants.setBackground;

public class Stars extends Spaceship implements Runnable {


    private Random random = new Random();


    public Stars() {

        for (int i = 0; i < Constants.NUM_CIRCLES; i++) {
            Constants.xC[i] = random.nextInt(Constants.Window_height - Constants.CIRCLE_SIZE);
            Constants.yC[i] = random.nextInt(Constants.Window_height - Constants.CIRCLE_SIZE);
            Constants.blink[i] = true;
        }
        Thread thread = new Thread(this);
        thread.start();
    }




    public void run() {
        while (true) {
            // Blink stars
            for (int i = 0; i < Constants.NUM_CIRCLES; i++) {
                Constants.yC[i]+= 1;
                if (Constants.yC[i] > Constants.Window_height) {
                    Constants.yC[i] = 0;
                }

            }
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {

            }

        }
    }

    private void repaint() {
    }


}