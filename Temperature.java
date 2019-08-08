package com.duncanritchie;

public class Temperature {
    // Converts a float from Celsius to Fahrenheit.
    public static float toFahrenheit(float celsius) {
        return celsius*9/5+32f;
    }

    // Converts a float from Fahrenheit to Celsius.
    public static float toCelsius(float fahrenheit) {
        return (fahrenheit-32)*5/7f;
    }

    // Main method.
    public static void main(String[] args) {
        float temp = 32;
        System.out.println(temp + " Celsius is " + toFahrenheit(temp) + " Fahrenheit.");
        System.out.println(temp + " Fahrenheit is " + toCelsius(temp) + " Celsius.");
    }
}
