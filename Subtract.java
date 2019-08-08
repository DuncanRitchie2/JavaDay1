package com.duncanritchie;

// This is not a very useful function, but it demonstrates that I can write a very basic function in Java!

public class Subtract {
    public static float subtract(float num1, float num2) {
        return num1 - num2;
    }

    public static void main(String[] args) {
        System.out.println("The difference is "+subtract(7,4));  // 3.0
    }
}
