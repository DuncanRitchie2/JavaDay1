package com.duncanritchie;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Pet {

    // Initialising all variables.
    private boolean petIsAlive = true;
    private String animal;
    private String animalLatin;
    private String name;
    private String gender;
    private String subjectPronoun = "they";
    private String objectPronoun = "them";
    private String possessiveAdjective = "their";
    private String possessivePronoun = "theirs";
    private String indefiniteArticle = "a";
    private String indefiniteArticleForGender = "a";
    private int hunger = 50;
    private int thirst = 50;
    private int boredom = 50;
    private int restlessness = 50;
    private int illness = 0;
    private int age = 0;

    private Timer timer = new Timer();
    // The timer simulates ageing by changing the hardship values
    // and announces the new values, every two seconds.
    private TimerTask changeAfterInterval = new TimerTask() {
        public void run() {
            hunger += Math.floor(Math.random() * 10 - 2);
            thirst += Math.floor(Math.random() * 10 - 2);
            boredom += Math.floor(Math.random() * 10 - 2);
            restlessness += Math.floor(Math.random() * 10 - 2);
            illness += Math.floor(Math.random() * 20 - 4);
            age += 2;
        }
    };
    // trackAge will be iterated every second.
    private TimerTask trackAge = new TimerTask() {
        public void run() {
            age++;
        }
    };

    public Pet(String animal, String name, String gender) {
        this.setAnimal(animal);
        this.setName(name);
        this.setGender(gender);
        timer.scheduleAtFixedRate(trackAge,0,1000);
        timer.scheduleAtFixedRate(changeAfterInterval,2000,2000);
    }

    public void setAnimal(String animal) {
        this.animal = animal;
        String firstLetter = animal.substring(0,1).toLowerCase();
        if (firstLetter.equals("a")  || firstLetter.equals("e")  || firstLetter.equals("i")  || firstLetter.equals("o")  || firstLetter.equals("u")) {
            this.indefiniteArticle = "an";
        }
    }

    public void setAnimalLatin(String animalLatin) {
        this.animalLatin = animalLatin;
        System.out.println("Animal tibi est "+animalLatin);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        if (gender.toLowerCase().equals("m")) {
            gender = "male";
        }
        else if (gender.toLowerCase().equals("f")) {
            gender = "female";
        }
        this.gender = gender;
        if (gender.equals("male")) {
            this.subjectPronoun = "he";
            this.objectPronoun = "him";
            this.possessivePronoun = "his";
            this.possessiveAdjective = "his";
        }
        else if (gender.equals("female")) {
            this.subjectPronoun = "she";
            this.objectPronoun = "her";
            this.possessivePronoun = "hers";
            this.possessiveAdjective = "her";
        }
        String firstLetter = animal.substring(0,1).toLowerCase();
        if (firstLetter.equals("a")  || firstLetter.equals("e")  || firstLetter.equals("i")  || firstLetter.equals("o")  || firstLetter.equals("u")) {
            this.indefiniteArticleForGender = "an";
        }
    }

    public boolean isAlive() {
        return petIsAlive;
    }

    public String getAnimal() {
        return animal;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getIndefiniteArticle() {
        return indefiniteArticle;
    }

    public String getIndefiniteArticleForGender() {
        return indefiniteArticleForGender;
    }

    public String getObjectPronoun() {
        return objectPronoun;
    }

    public String getPossessiveAdjective() {
        return possessiveAdjective;
    }

    public String getPossessivePronoun() {
        return possessivePronoun;
    }

    public String getSubjectPronoun() {
        return subjectPronoun;
    }

    public String getAnimalLatin() {
        return animalLatin;
    }

    public int getAge() {
        return age;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getIllness() {
        return illness;
    }

    public int getHunger() {
        return hunger;
    }

    public int getRestlessness() {
        return restlessness;
    }

    public int getThirst() {
        return thirst;
    }

    public void giveFood() {
        System.out.println("You have given "+this.name+" food.");
        this.hunger -= 10;
        this.thirst += 3;
        this.restlessness += 9;
        this.illness -= 1;
        this.boredom -= 4;
        this.flattenValues();
    }

    public void giveWater() {
        System.out.println("You have given "+this.name+" water.");
        this.thirst -= 10;
        this.hunger -= 1;
        this.restlessness += 2;
        this.boredom += 7;
        this.illness -= 6;
        this.flattenValues();
    }

    public void givePlay() {
        System.out.println("You have played with "+this.name+".");
        this.boredom -= 10;
        this.restlessness -= 8;
        this.hunger += 5;
        this.thirst += 5;
        this.illness += 2;
        this.flattenValues();
    }

    public void giveExercise() {
        System.out.println("You have taken "+this.name+" for a walk.");
        this.restlessness -= 10;
        this.hunger += 6;
        this.thirst += 12;
        this.illness -= 3;
        this.flattenValues();
    }

    public void giveMedicine() {
        System.out.println("You have given "+this.name+" medicine.");
        this.illness -= 10;
        this.hunger -= 2;
        this.thirst += 1;
        this.boredom += 2;
        this.restlessness += 8;
        this.flattenValues();
    }

    public void kill(int selection) {
        this.timer.cancel();
        this.petIsAlive = false;
        String[] causesOfDeath = {
            "You have starved %s the %s to death.",
            "You have not given %s the %s enough water, so %s's dead.",
            "You have bored %s the %s to death.",
            "You have made %s the %s so restless %s died.",
            "You did not give %s the %s enough medicine, so %s died.",
            "You have deliberately killed %s the %s. You bastard."
        };
        System.out.println(String.format(causesOfDeath[selection-1],this.name,this.animal,this.subjectPronoun));
    }

    public void flattenValues() {
        if (this.hunger < 0) {
            this.hunger = 0;
        } else if (this.hunger > 99) {
            this.kill(1);
        }
        if (this.thirst < 0) {
            this.thirst = 0;
        } else if (this.thirst > 99) {
            this.kill(2);
        }
        if (this.boredom < 0) {
            this.boredom = 0;
        } else if (this.boredom > 99) {
            this.kill(3);
        }
        if (this.restlessness < 0) {
            this.restlessness = 0;
        } else if (this.restlessness > 99) {
            this.kill(4);
        }
        if (this.illness < 0) {
            this.illness = 0;
        } else if (this.illness > 99) {
            this.kill(5);
        }
    }

    public void announcePetInfo() {
        String hardshipsString = "hunger "+this.getHunger()+", thirst "+this.getThirst()+", boredom "+this.getBoredom()+", restlessness "+this.getRestlessness()+", and illness "+this.getIllness()+".";
        if (this.isAlive()) {
            System.out.println(this.getName()+" now has "+hardshipsString);
            promptForCare();
        }
        else {
            System.out.println(this.getName()+" died with "+hardshipsString);
            System.out.println("Age at death: "+this.getAge()+" seconds.");
        }
    }

    public void promptForCare() {
        Scanner scan = new Scanner(System.in);
        System.out.println("To feed "+this.getName()+", enter 1; to give "+this.getObjectPronoun()+" water, enter 2; to play with "+this.getObjectPronoun()+", enter 3; to take "+this.getObjectPronoun()+" for a walk, enter 4; to give "+this.getObjectPronoun()+" medicine, enter 5; to immediately kill "+this.getObjectPronoun()+", enter 6.");
        int selection = scan.nextInt();
        careForPet(selection);
    }

    public void careForPet(int selection) {
        switch (selection) {
            case 1:
                this.giveFood();
                announcePetInfo();
                break;
            case 2:
                this.giveWater();
                announcePetInfo();
                break;
            case 3:
                this.givePlay();
                announcePetInfo();
                break;
            case 4:
                this.giveExercise();
                announcePetInfo();
                break;
            case 5:
                this.giveMedicine();
                announcePetInfo();
                break;
            case 6:
                System.out.println("You have killed your pet.");
                this.kill(6);
                break;
            default:
                System.out.println("Invalid selection! Try again.");
                promptForCare();
        }
    }

}
