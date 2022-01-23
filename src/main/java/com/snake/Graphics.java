package com.snake;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Rectangle;

public class Graphics
        extends JPanel
        implements ActionListener {
    private Timer dt = new Timer(100, this);
    public String state;

    private Snake s;
    private Food f;
    private Game game;

    public Graphics(Game g) {
        dt.start();
        state = "START";

        game = g;
        s = g.getSnake();
        f = g.getFood();

        this.addKeyListener(game);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);

        if (state == "START") {
            g2d.setColor(Color.white);
            g2d.drawString("Press any key to start the game.", Game.WIDTH / 2 * Game.SCALE - 40,
                    Game.HEIGHT / 2 * Game.SCALE - 20);
        } else if (state == "RUNNING") {
            g2d.setColor(Color.red);
            g2d.fillRect(f.getX() * Game.SCALE, f.getY() * Game.SCALE, Game.SCALE, Game.SCALE);

            g2d.setColor(Color.green);
            for (Rectangle r : s.getSnake()) {
                g2d.fill(r);
            }
        } else {
            g2d.setColor(Color.white);
            g2d.drawString("Your Score: " + (s.getSnake().size() - 3), Game.WIDTH / 2 * Game.SCALE - 40,
                    Game.HEIGHT / 2 * Game.SCALE - 20);
            g2d.drawString("Press R to restart the game.", Game.WIDTH / 2 * Game.SCALE - 40,
                    Game.HEIGHT / 2 * Game.SCALE + 20);
            g2d.drawString("Press ESC to exit the game.", Game.WIDTH / 2 * Game.SCALE - 40,
                    Game.HEIGHT / 2 * Game.SCALE + 40);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        game.update();

    }

}
