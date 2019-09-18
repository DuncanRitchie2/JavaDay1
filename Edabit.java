package com.duncanritchie;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

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

    // The same function but alternation pauses when a space is encountered, so result is "AlTeRnAtInG cApS", not "AlTeRnAtInG CaPs".
    public static String alternatingCapsNotingSpaces(String s) {
        String output = "";
        boolean toggle = false;
        for (int i = 0; i < s.length(); i++) {
            String letter = s.substring(i,i+1);
            if (letter.equals(" ")) {
                output += letter;
                toggle = !toggle;
            }
            else if (i%2 == 0 ^ toggle) {
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

    // onlyEvens() takes an array of ints and returns the array with only the even numbers.
    public static int[] onlyEvens(int[] nums) {
        int numEvens = 0;
        int[] evens = nums;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2 == 0) {
                evens[numEvens] = nums[i];
                numEvens++;
            }
        }
        int[] output = Arrays.copyOf(evens, numEvens);
        System.out.println();
        return output;
    }

    // sortDigitsDescending() sorts the digits of an int in descending order, e.g. 23230289231 -> 98333222210.
    public static int sortDigitsDescending(final int num) {
        String string = Integer.toString(num);
        String[] array = string.split("");
        Arrays.sort(array, Collections.reverseOrder());
        String sortedString = "";
        for (String digit : array) {
            sortedString += digit;
        }
        return Integer.parseInt(sortedString);
    }

    // sortLettersAlph() sorts the characters of a String, e.g. "Welcome to Code Nation!" -> "   !CNWacdeeeilmnoooott".
    public static String sortLettersAlph(String s) {
        String[] array = s.split("");
        Arrays.sort(array);
        String output = "";
        for (String letter : array) {
            output += letter;
        }
        return output;
    }

    // doCirclesTouch() takes two arrays of the form [radius, X position, Y position] and returns true if those two circles intersect or touch, false otherwise.
    public static boolean doCirclesTouch(int[] c1, int[] c2) {
        // c1 = eg. [r 10, x 0, y 0];
        // c2 = eg. [r 10, x 10, y 10];
        // horizontal distance between centres
        int diffCentresX = c2[1] - c1[1];
        // vertical distance between centres
        int diffCentresY = c2[2] - c1[2];
        // Pythagoras theorem to find the diagonal distance
        double hypotenuse = Math.sqrt(Math.pow(diffCentresX,2) + Math.pow(diffCentresY,2));
        // If hypotenuse is greater than the sum of the radii,
        // the circles do not touch.
        int sumOfRadii = c1[0] + c2[0];
        return (hypotenuse <= sumOfRadii);
    }

    // highestCommonDivisor() is some weird algorithm Euclid came up with for finding the highest common divisor of two ints.
    public static int highestCommonDivisor(int a, int b) {
        // If a is less than b, swap them.
        if (a<b) {
            int temp = b;
            b = a;
            a = temp;
        }
        // Set r as the modulus.
        int r = a%b;
        // If a is divisible by b, return b.
        if (r == 0) {
            return b;
        }
        // Otherwise, recurse with a = b and b = r.
        else {
            return highestCommonDivisor(b, r);
        }
    }

    // containsDoubleLetters() returns whether the String contains a double letters.
    public static boolean containsDoubleLetters(String word) {
        boolean bool = false;
        for (int i = 1; i < word.length(); i++) {
            // This compares every letter (except the first) to the one before it.
            if (word.substring(i-1,i).equals(word.substring(i,i+1))) {
                bool = true;
            }
        }
        return bool;
    }

    // cumulativeSum() changes every item of an int[] to the sum of it and all preceding items.
    public static int[] cumulativeSum(int[] nums) {
        if (nums.length>1) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i-1];
            }
        }
        return nums;
    }

    // filterStateNames() takes two parameters.
    // The first param is an array of US state names and two-letter postal codes (eg. ["Arizona","Idaho","FL","CA","New Jersey"]).
    // If the second parameter is "post", it filters to just the postal codes, otherwise, it filters to just the names.
    public static String[] filterStateNames(String[] arr, String type) {
        int count = 0;
        String[] filtered = arr;
        for (int i = 0; i < arr.length; i++) {
            if (type.equals("post") ^ arr[i].length()==2) {
                filtered[count] = arr[i];
                count++;
            }
        }
        return Arrays.copyOf(filtered, count);
    }

    // Returns whether the String is a palindrome (ignoring basic punctuation).
    public static boolean isPalindromeNonRecursive(String str) {
        boolean bool = true;
        String raw = str.replaceAll("[,;.!?/ -]", "").toLowerCase();
        int length = raw.length();
        for (int i = 0; i < length / 2; i++) {
            String leftChar = raw.substring(i, i + 1);
            String rightChar = raw.substring(length - i - 1, length - i);
            if (!leftChar.equals(rightChar)) {
                System.out.println(leftChar + " is not the same as " + rightChar);
                bool = false;
            }
        }
        return bool;
    }

    // countVowels() counts the number of letters AEIOU (case-insensitive) in the input String. Uses recursion.
    public static int countVowels(String str) {
        if (str.equals("")) {
            return 0;
        }
        else {
            str = str.toLowerCase();
            String firstLetter = str.substring(0,1);
            int isVowel = 0;
            if (firstLetter.equals("a")
                    || firstLetter.equals("e")
                    || firstLetter.equals("i")
                    || firstLetter.equals("o")
                    || firstLetter.equals("u")) {
                isVowel = 1;
            }
            return isVowel + countVowels(str.substring(1,str.length()));
        }
    }

    // xCountEqualsOCount() returns whether the letter X appears in a String as many tines as the letter O.
    public static boolean xCountEqualsOCount (String str) {
        // diff will equal number of X - number of O.
        int diff = 0;
        // array is an array of letters.
        String[] array = str.toLowerCase().split("");
        // For every letter, we increment diff if X, and decrement if O.
        for (String letter : array) {
            if (letter.equals("x")) {
                diff++;
            }
            else if (letter.equals("o")) {
                diff--;
            }
        }
        // diff will equal 0 if the X and O counts are equal.
        return diff==0;
    }

    // hashPlusCount() returns an array where the first value is the count of the # character in a String,
    // and the second value is the count of the + character in a String.
    public static int[] hashPlusCount(String s) {
        int[] output = new int[2];
        String[] letters = s.split("");
        for (String letter : letters) {
            if (letter.equals("#")) {
                output[0]++;
            }
            else if (letter.equals("+")) {
                output[1]++;
            }
        }
        return output;
    }

    // areAllLettersInString() returns whether all the characters in the second param are in the first param.
    // Case-insensitive, but punctuation-sensitive.
    // "Code Nation", "noted" => true
    // "CodeNation", "no ted" => false (because the space in "noted" is not in "CodeNation")
    // "Code Nation", "denoted" => false (because there's only one D and only one E in "Code Nation")
    public static boolean areAllLettersInString(String superString, String subString) {
        String[] superArray = superString.toLowerCase().split("");
        String[] subArray = subString.toLowerCase().split("");
        boolean bool = true;
        for (int i = 0; i < subArray.length; i++) {
            boolean letterIsInSuperArray = false;
            for (int j = 0; j < superArray.length; j++) {
                if (subArray[i].equals(superArray[j])) {
                    letterIsInSuperArray = true;
                    superArray[j] = "hello";
                    break;
                }
            }
            if (!letterIsInSuperArray) {
                bool = false;
            }
        }
        return bool;
    }

    // getMiddle() returns the middle character of a String if its length is odd;
    // or the middle two characters if the length is even. Recursive.
    public static String getMiddle(String word) {
        if (word.length() <= 2) {
            return word;
        }
        else {
            String withoutFirstAndLastLetter = word.substring(1,word.length()-1);
            return getMiddle(withoutFirstAndLastLetter);
        }
    }

    // maskify() replaces every character of a String except the last four with a # sign.
    // E.g. "My_secret_password123" => "#################d123"
    public static String maskify(String s) {
        int numCharsShown = 4;
        String maskChar = "#";
        String[] array = s.split("");
        for (int i = 0; i < array.length - numCharsShown; i++) {
            array[i] = maskChar;
        }
        String output = "";
        for (String letter : array) {
            output += letter;
        }
        return output;
    }

    // minMax() returns an array containing the minimum and the maximum of an array of doubles.
    public static double[] minMax(double[] arr) {
        double min = arr[0];
        double max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        double[] output = {min, max};
        return output;
    }

    // firstVowel() returns the index of the first letter AEIOU in the String, or -1 if there is no vowel.
    public static int firstVowel(String str) {
        String[] array = str.toLowerCase().split("");
        for (int i = 0; i < array.length; i++) {
            String letter = array[i];
            if (letter.equals("a")
                || letter.equals("e")
                || letter.equals("i")
                || letter.equals("o")
                || letter.equals("u")) {
                return i;
            }
        }
        return -1;
    }

//    removeStringsFromArray() removes the Strings from a heterogeneous array.
    public static Object[] removeStringsFromArray(Object[] array) {
        int newLength = 0;
        for (Object item : array) {
            if (!item.getClass().getName().equals("java.lang.String")) {
                array[newLength] = item;
                newLength++;
            }
        }
        return Arrays.copyOf(array, newLength);
    }

    // removeSpecial() returns a String without any characters other than letters, digits, space, underscore, hyphen.
    public static String removeSpecial(String s) {
        String allowed = "abcdefghijklmnopqrstuvwxyz0123456789 _-";
        String[] array = s.split("");
        String output = "";
        for (String character : array) {
            if (allowed.contains(character.toLowerCase())) {
                output += character;
            }
        }
        return output;
    }

    // removeSpecialUsingRegex() does the same as removeSpecial() but uses a regex internally.
    public static String removeSpecialUsingRegex(String s) {
        String output = s.replaceAll("(?i)[^abcdefghijklmnopqrstuvwxyz0123456789 _-]","");
        return output;
    }

    // doesNotContainDistractions() returns true if any "distraction" string is found.
    public static boolean doesNotContainDistractions(String string) {
        String[] distractions = {"anime","meme","vine","roasts","Danny Devito"};
        for (String word : distractions) {
            if (string.contains(word)) {
                return false;
            }
        }
        return true;
    }

    // capNames() returns an array with the first character of every string converted to upper case and all other characters converted to lower case.
    public static String[] capNames(String[] s) {
        for (int i = 0; i < s.length; i++) {
            String initial = s[i].substring(0,1).toUpperCase();
            String rest = s[i].substring(1,s[i].length()).toLowerCase();
            s[i] = initial + rest;
        }
        return s;
    }


    // isSquareMagic() takes any array int[n][n] and returns whether the "rows", "columns", and "main diagonals" sum to the same total.
    public static boolean isSquareMagic(int[][] square) {
        int size = square.length;
        // Let's calculate the target sum.
        int firstRowSum = 0;
        for (int num : square[0]) {
            firstRowSum += num;
        }
        // firstRowSum is now the target sum.
        // Let's check the other rows.
        for (int i = 1; i < size; i++) {
            int rowSum = 0;
            for (int num : square[i]) {
                rowSum += num;
            }
            if (rowSum != firstRowSum) {
                return false;
            }
        }
        // Let's check the columns.
        for (int i = 0; i < size; i++) {
            int colSum = 0;
            for (int j = 0; j < size; j++) {
                colSum += square[i][j];
            }
            if (colSum != firstRowSum) {
                return false;
            }
        }
        // Let's check the top-left-bottom-right diag.
        int diagSum = 0;
        for (int i = 0; i < size; i++) {
            diagSum += square[i][i];
        }
        if (diagSum != firstRowSum) {
            return false;
        }
        // Let's check the top-right-bottom-left diag.
        diagSum = 0;
        for (int i = 0; i < size; i++) {
            diagSum += square[i][size-i-1];
        }
        if (diagSum != firstRowSum) {
            return false;
        }
        // If we still haven't returned false, we return true.
        return true;
    }

    // stringLengthRecursive() returns the length of a String. Recursive.
    public static int stringLengthRecursive(String str) {
        if (str.equals("")) {
            return 0;
        }
        else {
            return 1 + stringLengthRecursive(str.substring(1));
        }
    }

    // isNumSquare() returns whether a double is a square number (0,1,4,9,16,..).
    public static boolean isNumSquare(double num) {
        return ((int)Math.sqrt(num) == Math.sqrt(num));
    }

    // isPlural() returns whether a String ends in "s".
    public static boolean isPlural(String word) {
        return word.substring(word.length()-1).equals("s");
    }

    // evensBelow() produces an array of even numbers (>1) less than the parameter.
    public static int[] evensBelow(int num) {
        int length = (int)num/2;
        int[] evens = new int[length];
        for (int i = 0; i < length; i++) {
            evens[i] = 2*i+2;
        }
        return evens;
    }

    // Returns the capitalised initials of the strings given, sorted alphabetically.
    // e.g. initialism(["Joey Tribbiani", "Rachel Green", "phoebe buffay, "Chandler", "Monica Geller"]) => "CJMPR".
    public static String initialism(String[] friends) {
        Arrays.sort(friends);
        String output = "";
        for (String friend : friends) {
            output += friend.substring(0, 1).toUpperCase();
        }
        return output;
    }

    // Returns true if the String consists of only 4 or 6 digits, otherwise false.
    public static boolean validatePIN(String s) {
        return Pattern.matches("\\b(\\d{4}|\\d{6})\\b", s);
    }

    // uniqueSort() returns array of ints, sorted and with duplicates removed.
    public static int[] uniqueSort(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return Arrays.copyOf(nums, count);
    }

    // sumTwoSmallestNums() returns the sum of the two smallest positive numbers in an array, or 0 if that's not applicable.
    public static int sumTwoSmallestNums(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > 0) {
                return arr[i] + arr[i+1];
            }
        }
        return 0;
    }

    // makeTitle() returns a String with the initial of every word uppercased.
    public static String makeTitle(String s) {
        String[] array = s.split(" ");
        String output = "";
        for (int i = 0; i < array.length; i++) {
            output += array[i].substring(0,1).toUpperCase();
            output += array[i].substring(1);
            if (i!=array.length-1) {
                output += " ";
            }
        }
        return output;
    }

    // mean() returns the mean of an array of integers. Below is the polymorph for doubles.
    public static double mean(int[] nums) {
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        double mean = (double)Math.round(100*sum/nums.length)/100;
        return mean;
    }

    public static double mean(double[] nums) {
        double sum = 0;
        for (double num : nums) {
            sum += num;
        }
        double mean = Math.round(100*sum/nums.length)/100;
        return mean;
    }

    // swapCharPairs() reverses the order of every pair of characters in a String.
    // E.g. "Duncan Ritchie" => "uDcnnaR tihcei".
    public static String swapCharPairs(String str) {
        String output = "";
        for (int i = 0; i < str.length()/2; i++) {
            output += str.substring(2*i+1,2*i+2);
            output += str.substring(2*i,2*i+1);
        }
        if (str.length()%2==1) {
            output += str.substring(str.length()-1);
        }
        return output;
    }
}

