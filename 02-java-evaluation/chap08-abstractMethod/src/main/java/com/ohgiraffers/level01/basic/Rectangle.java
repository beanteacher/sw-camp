package com.ohgiraffers.level01.basic;

public class Rectangle extends Shape implements Resizable {

    private int width;
    private int height;

    public Rectangle (int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void resize(double factor) {
        width = (int) (width * factor);
        height = (int) (height * factor);
    }

    @Override
    double calculateArea() {
        return width * height;
    }

    @Override
    double calculatePerimeter() {
        return (width + height) * 2;
    }
}
