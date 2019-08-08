package com.duncanritchie;

public class Bird {
    private String name;
    private String species;
    private boolean haveISeenIt;
    private String beakColour;
    private float beakLength;
    private String comment = "This bird is really awesome!";
    private String noise = "cheep cheep";

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
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
    public void makeNoise() {
        System.out.println("The "+this.name+" goes "+this.noise+".");
    }
}
