package com.duncanritchie;

// This prints a random integer (1-10) and creates a new Bird.
public class Main {

    public static void main(String[] args) {
        System.out.println("Here's a random integer from 1 to 10: "+(int)Math.ceil(Math.random()*10));
        Bird fulmar = new Bird("fulmarr","Fulmarus glacialis",true,"It roosts on cliffs.","squawk");
        fulmar.setName("fulmar");
        fulmar.makeNoise();
        fulmar.setSpecies("Fulmarus");
        fulmar.setSpecies("Fulmarus glacialis");
        fulmar.setHaveISeenIt(true);
        fulmar.printDesc();
    }
}
