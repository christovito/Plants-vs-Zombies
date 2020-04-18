import java.awt.*;
import javax.swing.*;
import java.awt.EventQueue;

public class GamePlay extends JFrame {

    public GamePlay(){
        initBoard();
    }

    private void initBoard(){
        add(new GameBoard());
        setResizable(false);
        pack();

        JLabel background = new JLabel("");
        background.setIcon(new javax.swing.ImageIcon("images/background.jpg"));
        background.setBounds(0, 0, 800, 600);
        add(background);

        setTitle("Plants vs Zombies");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            EventQueue.invokeLater(() -> {
            GamePlay play = new GamePlay();
            play.setVisible(true);
        });
        } catch (Exception e){
        } 
    }
}