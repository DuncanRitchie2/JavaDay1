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
    public static String alternatingCapsUsingArray(String string) {
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

    // The same function but not using an array or StringMethods.
    public static String alternatingCaps(String s) {
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            String letter = s.substring(i,i+1);
            if (i%2==0) {
                output += letter.toUpperCase();
            }
            else {
                output += letter.toLowerCase();
            }
        }
        return output;
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
                str = str.substring(1,array.length-1);
                System.out.println("New string is "+str);
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

    public static int countPrimesUpTo(int num) {
        int numPrimes = 0;
        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                numPrimes++;
            }
        }
        return numPrimes;
    }

    public static int countPrimesUpToNotUsingOwnFunction(int num) {
        int numPrimes = 0;
        for (int i = 2; i <= num; i++) {
            boolean isPrime = true;
            int factorCeiling = (int)Math.sqrt(i)+1;
            for (int j = 2; j < factorCeiling && isPrime; j++) {
                if (num%j==0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                numPrimes++;
            }
        }
        return numPrimes;
    }

    public static int[][] returnSquarePatch(int n) {
        int[][] square = new int[n][n];
        for (int i = 0; i<n; i++) {
            int[] row = new int[n];
            for (int j = 0; j<n; j++) {
                row[j] = n;
            }
            square[i] = row;
        }
        return square;
    }

    public static void printSquarePatch(int n) {
        for (int i = 0; i<n; i++) {
            String row = "";
            for (int j = 0; j<n; j++) {
                row += n;
            }
            System.out.println(row);
        }
    }

    public static String[] getExtensions(String[] arr){
        String[] extensions = new String[arr.length];
        for (int i = 0; i<arr.length; i++) {
            String extension = arr[i].substring(arr[i].indexOf(".")+1);
            extensions[i] = extension;
        }
        return extensions;
    }

    public static int[] timeSum(String[] s) {
        int hrsTotal = 0;
        int minsTotal = 0;
        int secsTotal = 0;
        for (String string : s) {
            String[] timeAsArray = string.split(":");
            hrsTotal += Integer.parseInt(timeAsArray[0]);
            minsTotal += Integer.parseInt(timeAsArray[1]);
            secsTotal += Integer.parseInt(timeAsArray[2]);
        }
        if (secsTotal>59) {
            minsTotal += Math.floor(secsTotal/60);
            secsTotal = secsTotal%60;
        }
        if (minsTotal>59) {
            hrsTotal += Math.floor(minsTotal/60);
            minsTotal = minsTotal%60;
        }
        int[] output = new int[3];
        output[0] = hrsTotal;
        output[1] = minsTotal;
        output[2] = secsTotal;
        return output;
    }

    // Takes an array of ints, and returns the first int that appears an odd number of times.
    // e.g. findOdd(1,6,2,6,22,7,1,7,2) = 22 because 22 appears once and the other numbers appear twice.
    public static int findOdd(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int numCopies = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i]==arr[j]) {
                    numCopies++;
                }
            }
            if (numCopies%2!=0) {
                return arr[i];
            }
        }
        return -1;
    }

    public static boolean validateEmail(String s) {
        int posAt = s.indexOf("@",1);
        int posDot = s.indexOf(".",posAt+1);
        if (posAt!=-1 && posDot!=-1 && posDot!=posAt+1 && posDot!=s.length()-1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static String reverseWordsLongerThan(String s) {
        String[] array = s.split(" ");
        int threshold = 5;
        String newString = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() < threshold) {
                newString += array[i];
            } else {
                String reversedWord = "";
                for (int j = 0; j < array[i].length(); j++) {
                    reversedWord += array[i].substring(array[i].length() - j - 1, array[i].length() - j);
                }
                newString += reversedWord;
            }
            if (i < array.length - 1) {
                newString += " ";
            }
        }
        return newString;
    }

    // This is my first recursive function!
    public static String reverseRecursive(String str) {
        String substring;
        if (str.length()<2) {
            substring = str;
        }
        else {
            substring = reverseRecursive(str.substring(1))+str.substring(0,1);
        }
        return substring;
    }

    // This is a recursive function to reduce int[] to its sum.
    public static int sumRecursive(int[] arr) {
        int output;
        if (arr.length==0) {
            output = 0;
        }
        else if (arr.length == 1) {
            output = arr[0];
        }
        else {
            output = arr[0]+sumRecursive(Arrays.copyOfRange(arr, 1, arr.length));
        }
        return output;
    }

    // This is a function to perform a binary search on an array of integers sorted in ascending order.
    // It uses recursion, which is why we have the left & right parameters.
    // There is a version with only the arr & elem parameters after this version.
    public static boolean binarySearch(int[] arr, int left, int right, int elem) {
        boolean bool;
        if (left>right) {
            bool = false;
        }
        else {
            int middle = (int)Math.floor((left+right)/2);
            if (arr[middle] < elem) {
                bool = binarySearch(arr, middle+1, right, elem);
            }
            else if (arr[middle] > elem) {
                bool = binarySearch(arr, left, middle-1, elem);
            }
            else {
                bool = true;
            }
        }
        return bool;
    }

    public static boolean binarySearch(int[] arr, int elem) {
        int left = 0;
        int right = arr.length-1;
        return binarySearch(arr, left, right, elem);
    }

    public static int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }
        else {
            int posCount = 0;
            int negSum = 0;
            for (int num : input) {
                if (num > 0) {
                    posCount++;
                } else if (num < 0) {
                    negSum += num;
                }
            }
            int[] output = {posCount, negSum};
            return output;
        }
    }

    // flipCase() flips the case of every letter in a string - upper to lower, lower to upper.
    public static String flipCase(String str) {
        String[] letters = str.split("");
        String newString = "";
        for (String letter : letters) {
            String newLetter;
            if (letter == letter.toLowerCase()) {
                newLetter = letter.toUpperCase();
            }
            else {
                newLetter = letter.toLowerCase();
            }
            newString += newLetter;
        }
        return newString;
    }
}
