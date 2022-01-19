package com.snake;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics
        extends JPanel
        implements ActionListener {
    private Timer dt = new Timer(100, this);
    public String state;

    private Snake snake;
    private Food food;
    private Game game;

    public Graphics() {
        dt.start();
        state = "START";
        snake = game.getSnake();
        food = game.getFood();

        this.addKeyListener(game);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
