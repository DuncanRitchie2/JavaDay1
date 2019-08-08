package com.duncanritchie;

public class Temperature {
    public static float toFahrenheit(float celsius) {
        return celsius*9/5+32f;
    }

    public static float toCelsius(float fahrenheit) {
        return (fahrenheit-32)*5/7f;
    }

    public static void main(String[] args) {
        float temp = 32;
        System.out.println(temp + " Celsius is " + toFahrenheit(temp) + " Fahrenheit.");
        System.out.println(temp + " Fahrenheit is " + toCelsius(temp) + " Celsius.");
    }
}