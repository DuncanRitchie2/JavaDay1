package com.duncanritchie;

public class LoopsPractice {


    public static void main(String[] args) {
        String[] toppings = {"cheese", "ham", "cucumber", "lettuce"};
        System.out.println("Enjoy your sandwich with toppings "+StringMethods.toSeparatedString(toppings, ", ")+".");
    }
}
