package com.duncanritchie;

public class Main {

    public static void main(String[] args) {
        int year = 2050;
        int birthYear = 1996;
        int age2 = year - birthYear;
        int age1 = age2-1;
        System.out.println(String.format("I will be either %s or %s in the year %s.",age1,age2,year));
        System.out.println(Math.ceil(Math.random()*10));
    }
}
