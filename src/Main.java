
import javax.swing.*;


public class   Main  {

    public static Background background;
    public static boolean game = true;

    public static void main(String[] args) {
        JFrame frame = new JFrame(" Space Invaders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Constants.Window_width, Constants.Window_height);
        background = new Background();
        frame.setContentPane(background);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

}
