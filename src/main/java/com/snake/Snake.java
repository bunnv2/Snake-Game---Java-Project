package com.snake;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Snake {
    private ArrayList<Rectangle> snake;

    private String direction; // UP, DOWN, LEFT, RIGHT, NONE

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

        direction = "NONE";
    }

    public void move() {
        if (direction != "NONE") {
            Rectangle temp = new Rectangle(Game.SCALE, Game.SCALE);
            Rectangle head = snake.get(0);

            if (direction == "UP") {
                temp.setLocation(head.x, head.y - Game.SCALE);
            } else if (direction == "DOWN") {
                temp.setLocation(head.x, head.y + Game.SCALE);
            } else if (direction == "LEFT") {
                temp.setLocation(head.x - Game.SCALE, head.y);
            } else if (direction == "RIGHT") {
                temp.setLocation(head.x + Game.SCALE, head.y);
            }

            snake.add(0, temp);
            snake.remove(snake.size() - 1);
        }
    }

    public void grow() {
        Rectangle temp = new Rectangle(Game.SCALE, Game.SCALE);
        Rectangle head = snake.get(0);

        if (direction == "UP") {
            temp.setLocation(head.x, head.y - Game.SCALE);
        } else if (direction == "DOWN") {
            temp.setLocation(head.x, head.y + Game.SCALE);
        } else if (direction == "LEFT") {
            temp.setLocation(head.x - Game.SCALE, head.y);
        } else if (direction == "RIGHT") {
            temp.setLocation(head.x + Game.SCALE, head.y);
        }

        snake.add(0, temp);
    }

    public ArrayList<Rectangle> getSnake() {
        return snake;
    }

    public void setSnake(ArrayList<Rectangle> snake) {
        this.snake = snake;
    }

    public void up() {
        direction = "UP";
    }

    public void down() {
        direction = "DOWN";
    }

    public void left() {
        direction = "LEFT";
    }

    public void right() {
        direction = "RIGHT";
    }
}
