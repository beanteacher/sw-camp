package com.ohgiraffers.level01.basic;

import java.util.Arrays;

public class ShapeManager {
    private Shape[] shapes = new Shape[10];
    private int index;

    public void addShape(Shape shape) {
        /* 배열에 전달 된 Shape를 추가. 단, 배열의 크기가 부족할 경우 2배로 늘려서 추가. */
        if(shapes[shapes.length - 1] != null){
            shapes = Arrays.copyOf(shapes, shapes.length * 2);
            shapes[shapes.length / 2] = shape;

            return;
        }
        for(int i = 0; i < shapes.length; i++) {
            if(shapes[i] == null) {
                shapes[i] = shape;
                break;
            }

        }
    }

    public void removeShape(Shape shape) {
        /* 배열에서 전달 된 Shape를 찾아 제거. 단, 제거 된 인덱스가 비어 있지 않도록 뒤에 있는 객체를 앞으로 당김. */
        System.out.println(shapes.length + ", " + Arrays.toString(shapes));
        for(int i = 0; i < shapes.length; i++) {
            if(shape instanceof Circle) {
                if(shapes[i] instanceof Circle) {
                    shapes[i] = null;
                }
            } else if(shape instanceof Triangle) {
                if(shapes[i] instanceof Triangle) {
                    shapes[i] = null;
                }
            } else if(shape instanceof Rectangle) {
                if(shapes[i] instanceof Rectangle) {
                    shapes[i] = null;
                }
            }
            System.out.println(Arrays.toString(shapes));
        }
    }

    public void printAllShapes() {
        /* 배열에 저장 된 모든 도형의 이름, 넓이, 둘레를 출력 */
        for(int i = 0; i < shapes.length; i++) {
            if(shapes[i] != null) {
                System.out.println("Shape : " + shapes[i].getClass().getSimpleName());
                System.out.println("Area : " + shapes[i].calculateArea());
                System.out.println("Perimeter : " + shapes[i].calculatePerimeter());
            }
        }
    }

    public double getTotalArea() {
        /* 배열에 저장 된 모든 도형의 넓이를 더해서 반환 */
        double totalArea = 0;
        for(Shape shape : shapes) {
            if(shape != null) {
                if(shape instanceof Circle) {
                    totalArea += ((Circle) shape).calculateArea();
                } else if(shape instanceof Triangle) {
                    totalArea += ((Triangle) shape).calculateArea();
                } else if(shape instanceof Rectangle) {
                    totalArea += ((Rectangle) shape).calculateArea();
                }
            }
        }
        return totalArea;
    }

    public double getTotalPerimeter() {
        /* 배열에 저장 된 모든 도형의 둘레를 더해서 반환 */
        double totalPerimeter = 0;
        for(Shape shape : shapes) {
            if(shape != null) {
                if(shape instanceof Circle) {
                    totalPerimeter += ((Circle) shape).calculatePerimeter();
                } else if(shape instanceof Triangle) {
                    totalPerimeter += ((Triangle) shape).calculatePerimeter();
                } else if(shape instanceof Rectangle) {
                    totalPerimeter += ((Rectangle) shape).calculatePerimeter();
                }
            }
        }
        return totalPerimeter;
    }
}
