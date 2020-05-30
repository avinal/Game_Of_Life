package life;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {

    public static class Ground extends JPanel {
        public Ground(int dime) {
            setPreferredSize(new Dimension(285, 260));
            setSize(285, 260);
            setLocation(0, 50);
            GridLayout layout = new GridLayout(dime, dime);
            setLayout(layout);
            for (int i = 0; i < dime * dime; i++) {
                add(new JButton(""));
            }
        }

        public Ground(State s, int dime) {
            setPreferredSize(new Dimension(285, 260));
            setSize(285, 260);
            setLocation(0, 50);
            GridLayout layout = new GridLayout(dime, dime);
            setLayout(layout);
            for (int i = 0; i < dime; i++) {
                for (int j = 0; j < dime; j++) {
                    JButton cell = new JButton();
                    cell.setBackground(s.current[i][j] == 'O' ? Color.BLACK : Color.WHITE);
                    add(cell);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 20;

        char[][] universe = new char[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (random.nextBoolean()) {
                    universe[i][j] = 'O';
                } else {
                    universe[i][j] = ' ';
                }
            }
        }
        State game = new State(universe);
        GameOfLife newLife = new GameOfLife();
        newLife.getContentPane().setLayout(null);
        newLife.GenerationLabel.setLocation(5, 3);
        newLife.GenerationLabel.setSize(100, 20);

        newLife.AliveLabel.setLocation(5, 20);
        newLife.AliveLabel.setSize(100, 20);

        Ground ground = new Ground(n);
        newLife.add(ground);
        newLife.setVisible(true);

        for (int k = 1; k < 201; k++) {
            newLife.GenerationLabel.setText("Generation #" + k);
            newLife.AliveLabel.setText(("Alive: " + Life.nextGeneration(game)));
            Thread.sleep(500L);
            newLife.remove(ground);
            ground = new Ground(game, n);
            newLife.add(ground);
            newLife.revalidate();
            newLife.repaint();
        }
    }
}



