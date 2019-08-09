package com.duncanritchie;

public class Pet {
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
    private int illness = 50;

    public Pet(String animal, String name, String gender) {
        this.setAnimal(animal);
        this.setName(name);
        this.setGender(gender);
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
}
