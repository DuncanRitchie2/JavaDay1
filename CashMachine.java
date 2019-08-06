package com.duncanritchie;
import java.util.Scanner;

public class CashMachine {
    static int pin = 1234;
    static float balance = 1000;

    public static void announce(Scanner scan) {
        System.out.println(String.format("You have £%s in your account.",balance));
        if (balance == 0) {
            System.out.println("You're bankrupt!");
        }
        else {
            System.out.println("Please enter an amount to withdraw:");
            float withdrawal = scan.nextFloat();
            withdraw(withdrawal, scan);
        }
    }

    public static void withdraw(float withdrawal, Scanner scan) {
        if (withdrawal>balance) {
            System.out.println(String.format("Insufficient funds! You cannot withdraw £%s when you have only £%s.",withdrawal,balance));
        }
        else {
            balance -= withdrawal;
            System.out.println(String.format("You have withdrawn £%s.",withdrawal));
        }
        announce(scan);
    }

    public static void pinPrompt(Scanner scan) {
        System.out.println("Please type your PIN!");
        int enteredPin = scan.nextInt();
        pinCheck(enteredPin,scan);
    }

    public static void pinCheck(int enteredPin, Scanner scan) {
        if(enteredPin==pin) {
            System.out.println("Correct PIN!");
            announce(scan);
        }
        else {
            System.out.println("Wrong PIN!");
            pinPrompt(scan);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the cash machine!");
        pinPrompt(scan);
    }
}