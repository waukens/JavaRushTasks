package com.javarush.task.task24.task2413;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height + 2][width + 2];
    }

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

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public void setPoint(double x, double y, char c) {
        int roundX = (int)Math.round(x);
        int roundY = (int)Math.round(y);
        if ((roundX >= 0 && roundX < matrix[0].length) && (roundY >= 0 && roundY < matrix.length)) {
            matrix[roundY][roundX] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = (int)Math.round(y); i < matrix.length; i++) {
            for (int j = (int)Math.round(x); j < matrix[0].length; j++) {
                setPoint(i, j, c);
            }
        }
    }
}
