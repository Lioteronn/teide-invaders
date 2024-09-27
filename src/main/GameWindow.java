package main;

import javax.swing.*;

public class GameWindow extends JFrame {
    private JFrame jframe;
    public GameWindow(GamePanel gamePanel){

        jframe = new JFrame();

        jframe.setSize(544,768);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }

}
