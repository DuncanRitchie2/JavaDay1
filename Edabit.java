package com.duncanritchie;

import java.util.Arrays;

// I was doing some challenges on Edabit when the site suffered internal server errors.
// So I saved my code here.

public class Edabit {
    // Input two Strings, and the return is whether they are anagrams (boolean).
    public static boolean areAnagramsUsingStringMethod(String one, String two) {
        one = one.toLowerCase();
        two = two.toLowerCase();
        String[] array1 = one.split("");
        Arrays.sort(array1);
        String[] array2 = two.split("");
        Arrays.sort(array2);
        String sorted1 = StringMethods.toSeparatedString(array1,"");
        String sorted2 = StringMethods.toSeparatedString(array2,"");
        return sorted1.equals(sorted2);
    }

    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() == s2.length()) {
            s1 = s1.toLowerCase();
            s2 = s2.toLowerCase();
            String[] array1 = s1.split("");
            Arrays.sort(array1);
            String[] array2 = s2.split("");
            Arrays.sort(array2);
            String ss1 = "";
            String ss2 = "";
            for (int i = 0; i < s1.length(); i++) {
                ss1 += array1[i];
                ss2 += array2[i];
            }
            return ss1.equals(ss2);
        } else {
            return false;
        }
    }

    // Input a String, the return is In aLtErNaTiNg cApS.
    public static String alternatingCaps(String string) {
        String[] array = string.split("");
        for (int i = 0; i < array.length; i++) {
            if (i%2 == 0) {
                array[i] = array[i].toUpperCase();
            }
            else {
                array[i] = array[i].toLowerCase();
            }
        }
        return StringMethods.toSeparatedString(array,"");
    }

    public static int numDigits(int num) {
        int numberOfDigits = 1;
        while (num/10>1){
            num = num/10;
            numberOfDigits ++;
        }
        return numberOfDigits;
    }

    public static int multiplicativePersistence(int num) {
        int persistence = 0;
        int product = num;

        while (product >= 10) {
          String string = ""+product;
          String[] array = string.split("");
          int tempProduct = 1;
          for (String character : array) {
              int digit = 0;
              switch (character) {
                  case "9": digit ++;
                  case "8": digit ++;
                  case "7": digit ++;
                  case "6": digit ++;
                  case "5": digit ++;
                  case "4": digit ++;
                  case "3": digit ++;
                  case "2": digit ++;
                  case "1": digit ++;
                  default: digit += 0;
              }
              tempProduct *= digit;
          }
          product = tempProduct;
          persistence ++;
        }

        return persistence;
    }

    public static boolean isPalindrome(String str) {
        boolean bool = true;
        while (str.length() >1 && bool) {
            String[] array = str.split("");
            if (array[0].equals(array[array.length-1])) {
                str = str.substring(1,array.length-2);
            }
            else {
                bool = false;
            }
        }
        return bool;
    }

    public static boolean isPrime(int num) {
        boolean bool = num>1;
        int factorCeiling = (int)Math.sqrt(num)+1;
        for (int i = 2; i < factorCeiling && bool; i++) {
            if (num%i==0) {
                bool = false;
            }
        }
        return bool;
    }

    public static boolean isPerfect(int num) {
        int total = 0;
        for (int i = 1; i < num/2+1; i++) {
            if (num%i==0) {
                total+=i;
            }
        }
        return total==num && num!=0;
    }
}
