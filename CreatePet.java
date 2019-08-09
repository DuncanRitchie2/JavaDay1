package com.duncanritchie;

import java.util.Scanner;

public class CreatePet {

    private static void animalPrompt() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please type the kind of animal you want:");
        String animal = scan.nextLine();
        System.out.println("Please type your "+animal+"'s name:");
        String name = scan.nextLine();
        System.out.println("Please type "+name+" the "+animal+"'s gender:");
        String gender = scan.nextLine();
        Pet pet = new Pet(animal, name, gender);
        System.out.println("Your pet is "+pet.getName()+"; "+pet.getSubjectPronoun()+" is "+pet.getIndefiniteArticleForGender()+" "+pet.getGender()+" "+pet.getAnimal()+".");
        pet.announcePetInfo();
    }

    public static void main(String[] args) {
        System.out.println("Let's create your pet!");
        animalPrompt();
    }
}
