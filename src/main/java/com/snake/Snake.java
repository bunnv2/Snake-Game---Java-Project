package com.snake;

import java.util.*;
import java.awt.*;

public class Snake {
    private ArrayList<Rectangle> snake;

    public Snake() {
        snake = new ArrayList<Rectangle>();

        Rectangle temp = new Rectangle(Game.SCALE, Game.SCALE);
        temp.setLocation((Game.WIDTH / 2) * Game.SCALE, (Game.HEIGHT / 2) * Game.SCALE);
        snake.add(temp);

        temp = new Rectangle(Game.SCALE, Game.SCALE);
        temp.setLocation((Game.WIDTH / 2 - 1) * Game.SCALE, (Game.HEIGHT / 2 - 1) * Game.SCALE);
        snake.add(temp);

        temp = new Rectangle(Game.SCALE, Game.SCALE);
        temp.setLocation((Game.WIDTH / 2 - 2) * Game.SCALE, (Game.HEIGHT / 2 - 2) * Game.SCALE);
        snake.add(temp);
    }

    public ArrayList<Rectangle> getSnake() {
        return snake;
    }

    public void setSnake(ArrayList<Rectangle> snake) {
        this.snake = snake;
    }
}
