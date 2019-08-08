package com.duncanritchie;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayPractice {

    // This is the same as stringWithSeparator(), but for doubles.
    public static String stringOfDoublesWithSeparator(double[] array, String separator) {
        String string = "";
        for (int i = 0; i < array.length; i++) {
            string += array[i];
            if (i<array.length-1) {
                string += separator;
            }
        }
        return string;
    }

    // returns the sum of the doubles in an array.
    public static double arraySum(double[] array) {
        double sum = 0;
        for (double number : array) {
            sum += number;
        }
        return sum;
    }

    // prints a pattern with the given text motif, height, and width.
    public static void printGrid(String motif, int height, int width) {
        for (int i = 0; i < height; i++) {
            String line = "";
            for (int j = 0; j <  width; j++) {
                line += motif;
            }
            System.out.println(line);
        }
    }

    // returns the mean of an array of doubles.
    public static double arrayMean(double[] array) {
        return arraySum(array)/array.length;
    }

    // returns true if the array contains the search, returns false otherwise.
    public static boolean contains(double[] array, double search) {
        for (double number : array) {
            if (number == search) {
                return true;
            }
        }
        return false;
    }

    // returns the index of the search value within the array, or -1 if the value is not found.
    public static int indexOf(double[] array, double search) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == search) {
                return i;
            }
        }
        return -1;
    }

    // returns the given array (of doubles) with the given value removed.
    public static double[] removeDouble(double[] array, double toRemove) {
        int indexToRemove = indexOf(array,toRemove);
        // n will be the length of the new array.
        int n;
        // if the value to remove is not actually in the array, we will be returning an array with the same length as the original.
        if (indexToRemove == -1) {
            n = array.length;
        }
        // if the value to remove is in the array, we will be returning an array of length one less than the original.
        else {
            n = array.length - 1;
        }
        // Now we make an array with the correct length.
        double[] result = new double[n];
        for (int i = 0; i < array.length; i++) {
            // If we are at the value to remove, we skip.
            if (i == indexToRemove) {
                continue;
            }
            // If we have passed the value to remove, the current value of the start array will become the value of the result with position one less.
            else if (i > indexToRemove) {
                result[i-1] = array[i];
            }
            // If we have not reached the value to remove, the value of the start array becomes the same-positioned value of the return array.
            else {
                result[i] = array[i];
            }
        }
        return result;
    }

    // returns the given array (of doubles) with the given value inserted at the given position.
    public static double[] insertDouble(double[] array, double toInsert, int position) {
        // n will be the length of the new array.
        int n = array.length + 1;
        // Now we make an array with the correct length.
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            // If we are at the value to remove, we skip.
            if (i == position) {
                result[i] = toInsert;
            }
            // If we have passed the value to remove, the current value of the start array will become the value of the result with position one less.
            else if (i > position) {
                result[i] = array[i-1];
            }
            // If we have not reached the value to remove, the value of the start array becomes the same-positioned value of the return array.
            else {
                result[i] = array[i];
            }
        }
        return result;
    }

    public static double max(double[] array) {
        double temp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > temp) {
                temp = array[i];
            }
        }
        return temp;
    }

    public static double min(double[] array) {
        double temp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < temp) {
                temp = array[i];
            }
        }
        return temp;
    }

    public static double[] reverseDoubles(double[] array) {
        int n = array.length;
        double[] temp = new double[n];
        for (int i = 0; i < n; i++) {
            temp[i] = array[n-i-1];
        }
        return temp;
    }

    public static double[] findRepeatedDoubles(double[] array) {
        // We initially set temp to the length of the entire array.
        // We will create an array with the correct length later.
        double[] temp = new double[array.length];
        int tempn = 0;
        for (int i = 0; i < array.length -1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    temp[tempn] = array[i];
                    tempn++;
                    break;
                }
            }
        }
        // Now we've found the duplicates, we put them in a new array with correct length (tempn).
        double[] result = new double[tempn];
        for (int i = 0; i < tempn; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public static String[] findRepeatedStrings(String[] array) {
        // We initially set temp to the length of the entire array.
        // We will create an array with the correct length later.
        String[] temp = new String[array.length];
        // tempn will increment whenever a duplicate is found, so it will be finally the number of duplicates -1.
        int tempn = 0;
        // array[i] is any value in the array.
        // array[j] is any value after array[i].
        for (int i = 0; i < array.length -1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    temp[tempn] = array[i];
                    tempn++;
                    // If a duplicate for array[i] is found, we don't check more than one value of array[j].
                    break;
                }
            }
        }
        // Now we've found the duplicates, we put them in a new array with correct length (tempn).
        String[] result = new String[tempn];
        for (int i = 0; i < tempn; i++) {
            result[i] = temp[i];
        }
        // Alternatively, we could have used Arrays.copyOf(temp,tempn), which is the approach in findInBothArrays().
        return result;
    }

    public static String[] findInBothArrays(String[] array1, String[] array2) {
        String[] temp = new String[Math.min(array1.length,array2.length)];
        int tempn = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    temp[tempn] = array1[i];
                    tempn++;
                }
            }
        }
        String[] result = Arrays.copyOf(temp,tempn);
        return result;
    }

    public static String[] removeDuplicateStrings(String[] array) {
        String[] temp = new String[array.length];
        // tempn will be the length of the return.
        int tempn = 0;
        for (int i = 0; i < array.length; i++) {
            // toAdd determines whether we should add array[i] to temp.
            boolean toAdd = true;
            for (int j = i+1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    toAdd = false;
                    break;
                }
            }
            if (toAdd) {
                temp[tempn] = array[i];
                tempn++;
            }
        }
        return Arrays.copyOf(temp,tempn);
    }

    public static ArrayList stringArrayToArrayList(String[] array) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string :  array) {
            arrayList.add(string);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        // Numbers in brackets refer to puzzles from here: https://www.w3resource.com/java-exercises/array/index.php
        // Questions from that list referring to integers have been answered for doubles.
        double[] doubles = {29.25, 34, 19, 43, 19, 13.13, -35, 1};
        System.out.println("(2) The sum of the array of doubles is...       "+arraySum(doubles));
        System.out.println("(3) Grid made from a repeated motif:");
        printGrid("O",7,5);
        System.out.println("(4) The mean of the array of doubles is...      "+arrayMean(doubles));
        System.out.println("(5) Does the array contain 19?                  "+contains(doubles,19));
        System.out.println("(5) Does the array contain 23?                  "+contains(doubles,23));
        System.out.println("(6) The index of 19 in the array is...          "+indexOf(doubles, 19));
        System.out.println("(6) The index of 190 in the array is...         "+indexOf(doubles, 190));
        System.out.println("(7) The array with 13.13 removed is...          "+stringOfDoublesWithSeparator(removeDouble(doubles, 13.13)," "));
        System.out.println("(9) The array with 140 inserted is...           "+stringOfDoublesWithSeparator(insertDouble(doubles, 140,3)," "));
        System.out.println("(10) The maximum of the array is...             "+max(doubles));
        System.out.println("(10) The minimum of the array is...             "+min(doubles));
        System.out.println("(11) The array reversed is...                   "+stringOfDoublesWithSeparator(reverseDoubles(doubles)," "));
        System.out.println("(12) The duplicates in the doubles are...       "+stringOfDoublesWithSeparator(findRepeatedDoubles(doubles)," "));
        String[] strings = {"robin","robin","fulmar","blackbird","lesser black-backed gull","canada goose","blue tit","Canada goose","fulmar","carrion crow","lammergeier","robin","carrion crow"};
        System.out.println("(13) The duplicates in the first String[] are..."+StringArraySortOrToString.stringWithSeparator(findRepeatedStrings(strings)," "));
        String[] moreStrings = {"fulmar","blackbird","honey buzzard","hooded crow"};
        System.out.println("(14) The duplicates in two String[] arrays are.."+StringArraySortOrToString.stringWithSeparator(findInBothArrays(strings,moreStrings)," "));
        System.out.println("(16) The first String[] with duplicates removed "+StringArraySortOrToString.stringWithSeparator(removeDuplicateStrings(strings)," - "));
        System.out.println("(20) The first String[] as an ArrayList...      "+stringArrayToArrayList(strings).toString());
    }
}
