package com.duncanritchie;

public class Corvid extends Bird {
    private int intelligenceOutOfFive;

    public Corvid(String name, String species, boolean haveISeenIt, String comment, String noise, int intelligenceOutOfFive) {
        super(name,species,haveISeenIt,comment,noise);
        this.intelligenceOutOfFive = intelligenceOutOfFive;
    }

    public void setIntelligenceOutOfFive(int intelligenceOutOfFive) {
        this.intelligenceOutOfFive = intelligenceOutOfFive;
    }

    public int getIntelligenceOutOfFive() {
        return intelligenceOutOfFive;
    }
}
