package com.duncanritchie;

public class Bird {
    private String name = "particular bird";
    private String species = "particular species";
    private boolean haveISeenIt;
    private String beakColour;
    private float beakLength;
    private String comment = "This bird is really awesome!";
    private String noise = "cheep cheep";

    public Bird(String name, String species, boolean haveISeenIt, String beakColour, float beakLength, String comment, String noise) {
        this.name = name;
        this.species = species;
        this.haveISeenIt = haveISeenIt;
        this.beakColour = beakColour;
        this.beakLength = beakLength;
        this.comment = comment;
        this.noise = noise;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        if (species.split(" ").length == 2) {
            this.species = species;
        }
        else {
            System.out.println("Species cannot be "+species+" because it must be two words!");
        }
    }

    public void setHaveISeenIt(boolean bool) {
        this.haveISeenIt = bool;
    }

    public void setBeakColour(String colour) {
        this.beakColour = colour;
    }

    public void setBeakLength(float length) {
        this.beakLength = length;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void printDesc() {
        String haveSeen;
        if (this.haveISeenIt) {
            haveSeen = "have seen";
        }
        else {
            haveSeen = "have not seen";
        }
        System.out.println(String.format("I %s a %s; its species is %s and it has a %s-centimetre %s beak. %s",haveSeen,this.name,this.species,this.beakLength,this.beakColour,this.comment));
    }

    public void makeNoise() {
        System.out.println("The "+this.name+" goes "+this.noise+".");
    }

    public String getName() {
        return this.name;
    }

    public float getBeakLength() {
        return beakLength;
    }

    public String getBeakColour() {
        return beakColour;
    }

    public String getComment() {
        return comment;
    }

    public String getNoise() {
        return noise;
    }

    public String getSpecies() {
        return species;
    }
}
