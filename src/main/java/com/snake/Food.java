package com.snake;

import java.awt.Rectangle;

public class Food {
    private int x;
    private int y;

    public Food(Snake snake) {
        this.randomize(snake);
    }

    public void randomize(Snake snake) {
        boolean collision = true;

        while (collision) {
            collision = false;

            x = (int) (Math.random() * Game.WIDTH);
            y = (int) (Math.random() * Game.HEIGHT);

            for (Rectangle rect : snake.getSnake()) {
                if (rect.getX() == x * Game.SCALE && rect.getY() == y * Game.SCALE) {
                    collision = true;
                }
            }

            if (collision) {
                x = (int) (Math.random() * Game.WIDTH);
                y = (int) (Math.random() * Game.HEIGHT);
                collision = false;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
