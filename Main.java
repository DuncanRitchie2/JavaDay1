package com.duncanritchie;

// This prints a random integer (1-10) and creates a new Bird.
public class Main {

    public static void main(String[] args) {
//        System.out.println("Here's a random integer from 1 to 10: "+(int)Math.ceil(Math.random()*10));
//
//        System.out.println("Are Duncanus Richardus and Durans Ac Hinc Durus anagrams?   "+Edabit.areAnagrams("Duncanus Richardus","Durans Ac Hinc Durus"));
//        System.out.println("Are DuncanusRichardus and DuransAcHincDurus anagrams?       "+Edabit.areAnagrams("DuncanusRichardus","DuransAcHincDurus"));
//
//        System.out.println("My name in alternating caps:                                "+Edabit.alternatingCaps("Duncan Ritchie"));
//        System.out.println("Carmen Buranum in alternating caps:                         "+Edabit.alternatingCaps("o fortuna, velut luna tu es variabilis. semper crescens aut decrescens vita detestabilis."));
//
//        System.out.println("Persistence of 999                                          "+Edabit.multiplicativePersistence(999));
//        System.out.println("Persistence of 25                                           "+Edabit.multiplicativePersistence(25));
//        System.out.println("Persistence of 4                                            "+Edabit.multiplicativePersistence(4));
//        System.out.println("Persistence of 39                                           "+Edabit.multiplicativePersistence(39));

//        System.out.println("Is naan a palindrome?                                       "+Edabit.isPalindrome("naan"));
//        System.out.println("Is fulmar a palindrome?                                     "+Edabit.isPalindrome("fulmar"));
//        System.out.println("Is racecar a palindrome?                                    "+Edabit.isPalindrome("racecar"));
//        System.out.println("Is the empty string a palindrome?                           "+Edabit.isPalindrome(""));
//        System.out.println("Is me a palindrome?                                         "+Edabit.isPalindrome("me"));
//        System.out.println("Is hat a palindrome?                                        "+Edabit.isPalindrome("hat"));
//        System.out.println("Is A a palindrome?                                          "+Edabit.isPalindrome("A"));

//        System.out.println("How many digits does 999 have?                              "+Edabit.numDigits(999));
//        System.out.println("How many digits does 25 have?                               "+Edabit.numDigits(25));
//        System.out.println("How many digits does 4 have?                                "+Edabit.numDigits(4));
//        System.out.println("How many digits does 39 have?                               "+Edabit.numDigits(39));
        System.out.println("Prime numbers up to 1000:");
        for (int i = 0; i < 1000; i++) {
            if (Edabit.isPrime(i)) {
                System.out.println(i);
            }
        }


//        Bird fulmar = new Bird("fulmarr","Fulmarus glacialis",true,"It roosts on cliffs.","squawk");
//        fulmar.setName("fulmar");
//        fulmar.makeNoise();
//        fulmar.setSpecies("Fulmarus");
//        fulmar.setSpecies("Fulmarus glacialis");
//        fulmar.setHaveISeenIt(true);
//        fulmar.printDesc();
    }
}
