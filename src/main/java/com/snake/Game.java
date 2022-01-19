package com.snake;

import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Game implements KeyListener {

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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            snake.up();
        } else if (key == KeyEvent.VK_DOWN) {
            snake.down();
        } else if (key == KeyEvent.VK_LEFT) {
            snake.left();
        } else if (key == KeyEvent.VK_RIGHT) {
            snake.right();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }
}
