package com.javarush.task.task23.task2312;

/**
 * Created by noname on 17.07.17.
 */
public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    void run() {}

    void print() {}

    public static Room game;

    public void createMouse() {
        this.mouse = new Mouse((int)(Math.random() * width), (int)(Math.random() * height));
    }

    public void eatMouse() {
        createMouse();
    }

    public static void main(String[] args) {
        Snake snake = new Snake(10, 10);
        game = new Room(100, 100, snake);
        snake.setDirection(SnakeDirection.DOWN);
    }
}
