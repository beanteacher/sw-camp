package com.ohgiraffers.level01.basic;

public class Circle extends Shape implements  Resizable{

    private final static double PI = 3.14;
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void resize(double factor) {
        radius = (int) (radius * factor);
    }

    @Override
    double calculateArea() {
        return radius * radius * PI;
    }

    @Override
    double calculatePerimeter() {
        return radius * 2 * PI;
    }
}
