package com.snake;

import java.awt.Rectangle;

public class Food {
    private int x;
    private int y;

    public Food(Snake snake) {
        this.randomize(snake);
    }

    public void randomize(Snake snake) {
        x = (int) (Math.random() * Game.WIDTH);
        y = (int) (Math.random() * Game.HEIGHT);
        boolean collision = false;

        while (!collision) {
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
}
