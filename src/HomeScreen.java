import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HomeScreen {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Main game = new Main();
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon image = new ImageIcon("C:\\Java All\\SpaceShooter\\src\\Resources\\nice home.jpg");
                g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        panel.setPreferredSize(new Dimension(Constants.Window_width, Constants.Window_height)); // Set panel size

        JButton startButton = new JButton("Start Game");
        startButton.setPreferredSize(new Dimension(200, 50)); // customize the size of the button
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Arial", Font.BOLD, 22));



        // add the button to the panel and center it
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 680));
        panel.add(startButton);

        frame.setContentPane(panel);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    // Call the main method of the Main class  to start the game
                    game.main(new String[0]);
                    // Close the home screen window
                    frame.dispose();

            }
        });


     frame.pack();
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }
}