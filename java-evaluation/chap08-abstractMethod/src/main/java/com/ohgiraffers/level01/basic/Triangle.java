package com.ohgiraffers.level01.basic;

public class Triangle extends Shape implements Resizable {

    private int base;
    private int height;
    private int side1;
    private int side2;
    private int side3;

    public Triangle(int base, int height, int side1, int side2, int side3) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public void resize(double factor) {
        base = (int) (base * factor);
        height = (int) (height * factor);
        side1 = (int) (side1 * factor);
        side2 = (int) (side2 * factor);
        side3 = (int) (side3 * factor);
    }

    @Override
    double calculateArea() {
        return (double) (base * height) / 2;
    }

    @Override
    double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}
