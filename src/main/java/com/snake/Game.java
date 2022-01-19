package com.snake;

import javax.swing.JFrame;

public class Game {

    private Snake snake;
    private Food food;
    private Graphics graphics;

    private JFrame window;
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    public static final int SCALE = 20;

    public Game() {
        window = new JFrame("Snake");

        window.setTitle("Snake");
        window.setSize(WIDTH * SCALE, HEIGHT * SCALE);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
