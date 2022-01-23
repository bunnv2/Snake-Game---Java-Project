package com.snake;

import javax.swing.JFrame;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.Rectangle;

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

        snake = new Snake();
        food = new Food(snake);
        graphics = new Graphics(this);

        window.add(graphics);

        window.setTitle("Snake");
        window.setSize(WIDTH * SCALE, HEIGHT * SCALE);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
    }

    public void start() {
        graphics.state = "RUNNING";
    }

    public void update() {
        if (graphics.state == "RUNNING") {
            if (isFoodCollision()) {
                snake.grow();
                food.randomize(snake);
            } else if (isWallCollision() || isSnakeCollision()) {
                graphics.state = "END";
            } else {
                snake.move();
            }
        }
    }

    private boolean isWallCollision() {
        if (snake.getX() < 0 || snake.getX() >= WIDTH * SCALE
                || snake.getY() < 0 || snake.getY() >= HEIGHT * SCALE) {
            return true;
        }
        return false;
    }

    private boolean isFoodCollision() {
        if (snake.getX() == food.getX() * SCALE && snake.getY() == food.getY() * SCALE) {
            return true;
        }
        return false;
    }

    private boolean isSnakeCollision() {
        for (int i = 1; i < snake.getSnake().size(); i++) {
            if (snake.getX() == snake.getSnake().get(i).x &&
                    snake.getY() == snake.getSnake().get(i).y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (graphics.state == "RUNNING") {
            if (key == KeyEvent.VK_UP) {
                snake.up();
            } else if (key == KeyEvent.VK_DOWN) {
                snake.down();
            } else if (key == KeyEvent.VK_LEFT) {
                snake.left();
            } else if (key == KeyEvent.VK_RIGHT) {
                snake.right();
            }
        } else if (graphics.state == "END") {
            if (key == KeyEvent.VK_R) {
                graphics.state = "RUNNING";
                snake.reset();
                food.randomize(snake);
            }
            if (key == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
        } else {
            this.start();
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
