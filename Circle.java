package com.duncanritchie;

public class Circle {
    public static double circumference(double radius) {
        return 2 * radius * Math.PI;
    }
    public static double area(double radius) {
        return radius * radius * Math.PI;
    }

    public static void main(String[] args) {
        int radius = 9;
        double circumference = circumference(radius);
        double area = area(radius);
        System.out.println(String.format("A circle of radius %s has circumference %s and area %s.",radius,circumference,area));
    }
}
