package com.duncanritchie;

import java.util.ArrayList;

public class LoopsPractice {
    public static String[] toppings = {"cheese", "ham", "cucumber", "lettuce"};
    public static ArrayList birds = new ArrayList();
    public static String[] films = {"Inside Out", "Braveheart", "Harry Potter", "King Kong", "Big Hero 6", "It's a Wonderful Life"};
    public static ArrayList foods = new ArrayList();

    public static void printRandoms(double min,double max,int count) {
        for (int i = 0; i < count; i++) {
            double rand = Math.random()*(max-min)+min;
            System.out.println(rand);
        }
    }

    public static void printFilms() {
        for (String film : films) {
            System.out.println(film);
        }
    }

    public static void printFoods() {
        foods.add("Kedgeree");
        foods.add("Paella");
        foods.add("Toad-in-the-hole");
        foods.add("Salad nicoise");
        foods.add("Haggis");
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(foods.get(i));
        }
    }

    public static void filmCheck() {
        String neededFilm = "Harry Potter";
        if(films[2].length() >= neededFilm.length()) {
            if (films[2].substring(0, neededFilm.length()) == neededFilm) {
                System.out.println("Expecto Patronum");
            }
            else {
                System.out.println(films[2].substring(0, neededFilm.length())+" is not Harry Potter. Go watch Harry Potter!");
            }
        }
        else {
            System.out.println("You need to watch Harry Potter.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enjoy your sandwich with toppings "+StringMethods.toSeparatedString(toppings, ", ")+".");
        birds.add("robin");
        birds.add("mistle-thrush");
        birds.add("guillemot");
        birds.add(0,"hobby"); // birds is now hobby, robin, mistle-thrush, guillemot
        System.out.println(birds.toString());
        System.out.println("Printing random numbers:");
        printRandoms(5,50,10);
        printFilms();
        printFoods();
        filmCheck();
    }
}
