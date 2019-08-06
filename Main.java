package com.duncanritchie;

public class Main {
    public static float toFahrenheit(float celsius) {
        return celsius*9/5+32f;
    }

    public static float toCelsius(float fahrenheit) {
        return (fahrenheit-32)*5/7f;
    }

    public static void main(String[] args) {
        int year = 2050;
        int birthYear = 1996;
        int age2 = year - birthYear;
        int age1 = age2-1;
        System.out.println(String.format("I will be either %s or %s in the year %s.",age1,age2,year));
        System.out.println(Math.ceil(Math.random()*10));

        int radius = 9;
        double circumference = 2 * radius * Math.PI;
        double area = radius * radius * Math.PI;
        System.out.println(String.format("A circle of radius %s has circumference %s and area %s.",radius,circumference,area));

        float temp = 32;
        System.out.println(temp+" Celsius is "+toFahrenheit(temp)+" Fahrenheit.");
        System.out.println(temp+" Fahrenheit is "+toCelsius(temp)+" Celsius.");
    }
}
