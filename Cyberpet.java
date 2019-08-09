package com.duncanritchie;

import java.util.Scanner;

public class Cyberpet {

    private static void animalPrompt(Scanner scan) {
        System.out.println("Please type the kind of animal you want:");
        String animal = scan.nextLine();
        System.out.println("Please type your "+animal+"'s name:");
        String name = scan.nextLine();
        System.out.println("Please type "+name+" the "+animal+"'s gender:");
        String gender = scan.nextLine();
        Pet cyberPet = new Pet(animal, name, gender);
        System.out.println("Your pet is "+cyberPet.getName()+"; "+cyberPet.getSubjectPronoun()+" is "+cyberPet.getIndefiniteArticleForGender()+" "+cyberPet.getGender()+" "+cyberPet.getAnimal()+".");
        announcePetInfo(cyberPet,scan);
    }

    public static void announcePetInfo(Pet pet, Scanner scan) {
        String hardshipsString = "hunger "+pet.getHunger()+", thirst "+pet.getThirst()+", boredom "+pet.getBoredom()+", restlessness "+pet.getRestlessness()+", and illness "+pet.getIllness()+".";
        if (pet.isAlive()) {
            System.out.println(pet.getName()+" now has "+hardshipsString);
            promptForCare(pet, scan);
        }
        else {
            System.out.println(pet.getName()+" died with "+hardshipsString);
        }
    }

    public static void promptForCare(Pet pet, Scanner scan) {
        System.out.println("To feed "+pet.getName()+", enter 1; to give "+pet.getObjectPronoun()+" water, enter 2; to play with "+pet.getObjectPronoun()+", enter 3; to take "+pet.getObjectPronoun()+" for a walk, enter 4; to give "+pet.getObjectPronoun()+" medicine, enter 5; to immediately kill "+pet.getObjectPronoun()+", enter 6.");
        int selection = scan.nextInt();
        careForPet(selection,pet,scan);
    }

    public static void careForPet(int selection, Pet pet, Scanner scan) {
        switch (selection) {
            case 1:
                pet.giveFood();
                announcePetInfo(pet,scan);
                break;
            case 2:
                pet.giveWater();
                announcePetInfo(pet,scan);
                break;
            case 3:
                pet.givePlay();
                announcePetInfo(pet,scan);
                break;
            case 4:
                pet.giveExercise();
                announcePetInfo(pet,scan);
                break;
            case 5:
                pet.giveMedicine();
                announcePetInfo(pet,scan);
                break;
            case 6:
                System.out.println("You have killed your pet.");
                pet.kill(6);
                break;
            default:
                System.out.println("Invalid selection! Try again.");
                promptForCare(pet,scan);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Let's create your pet!");
        animalPrompt(scan);
    }
}
