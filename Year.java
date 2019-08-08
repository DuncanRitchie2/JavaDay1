package com.duncanritchie;

public class Year {
    public static int older(int currentYear, int birthYear) {
        return currentYear - birthYear;
    }
    public static int younger(int currentYear, int birthYear) {
        return older(currentYear,birthYear) - 1;
    }
    public static void main(String[] args) {
        int currentYear = 2019;
        int birthYear = 1996;
        int age2 = older(currentYear,birthYear);
        int age1 = younger(currentYear,birthYear);
        System.out.println(String.format("I will be either %s or %s in the year %s.", age1, age2, currentYear));
    }
}
