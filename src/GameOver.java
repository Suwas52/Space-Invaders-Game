import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOver extends JPanel {
    public static void main(String[] args) {
        JFrame frame2 = new JFrame("Space Invaders");
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon image = new ImageIcon("C:\\Java All\\6th sem java project\\SpaceShooter\\src\\Resources\\FINISH.jpg");
                g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        panel.setPreferredSize(new Dimension(Constants.Window_width, Constants.Window_height)); // Set panel size

        JButton resetButton = new JButton("RESTART");
        resetButton.setPreferredSize(new Dimension(250, 50)); // customize the size of the button
        resetButton.setBackground(Color.green);
        resetButton.setForeground(Color.BLACK);
        resetButton.setFont(new Font("Arial", Font.BOLD, 18));

        // add the button to the panel and center it
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 680));
        panel.add(resetButton);

        frame2.setContentPane(panel);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of the Main class
                Main game = new Main();
                // Call the main method of the Main class  to start the game
                game.main(new String[0]);
                // Close the home screen window
                frame2.dispose();

            }
        });


        frame2.pack();
        frame2.setResizable(false);

        frame2.setLocationRelativeTo(null);

        frame2.setVisible(true);

    }
}
