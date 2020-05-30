package life;

import javax.swing.*;

public class GameOfLife extends JFrame {
    public JLabel GenerationLabel = new JLabel();
    public JLabel AliveLabel = new JLabel();

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 350);
        add(GenerationLabel);
        add(AliveLabel);
        GenerationLabel.setName("GenerationLabel");
        AliveLabel.setName("AliveLabel");
        GenerationLabel.setText("Generation #0");
        AliveLabel.setText("Alive: 0");

        setVisible(true);
    }

}
