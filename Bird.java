package com.duncanritchie;

public class Bird {
    private String name;
    private String species;
    private boolean haveISeenIt;
    private String comment;
    private String noise;

    public Bird(String name, String species, boolean haveISeenIt, String comment, String noise) {
        this.name = name;
        this.species = species;
        this.haveISeenIt = haveISeenIt;
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
        System.out.println(String.format("I %s a %s of species %s. %s",haveSeen,this.name,this.species,this.comment));
    }

    public void makeNoise() {
        System.out.println("The "+this.name+" goes "+this.noise+".");
    }

    public String getName() {
        return this.name;
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
