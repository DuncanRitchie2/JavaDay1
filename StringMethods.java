package com.duncanritchie;
import java.util.Arrays;

public class StringMethods {

    // This method concatenates String[] arrays into a single String with a given separator.
    // For example, stringWithSeparator(["a","b","c"],"~") = "a~b~c"
    public static String toSeparatedString(String[] array, String separator) {
        String string = "";
        for (int i = 0; i < array.length; i++) {
            string += array[i];
            if (i<array.length-1) {
                string += separator;
            }
        }
        return string;
    }

    // This method concatenates String[] arrays into a single String with a given separator.
    // For example, stringWithSeparator(["a","b","c"],"~") = "a~b~c"
    public static String intsToSeparatedString(int[] array, String separator) {
        String string = "";
        for (int i = 0; i < array.length; i++) {
            string += array[i];
            if (i<array.length-1) {
                string += separator;
            }
        }
        return string;
    }

    // This method returns an array of Strings sorted alphabetically.
    // It ignores case unless two pairs of Strings differ only in their case.
    public static String[] sortAlph(String[] unsorted) {
        String[] array = unsorted;
//        array[i] is any item in the array.
//        array[j] is any item after array[i]
//        If array[i] is alphabetically after array[j], they swap position.
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].toLowerCase().compareTo(array[j].toLowerCase())>0) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                // If array[i] and array[j] are the same except for case:
                else if (array[i].toLowerCase().equals(array[j].toLowerCase())
                        && array[i].compareTo(array[j]) > 0) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    // This main method demonstrates my custom sort function and the native sort function from java.utils.
    public static void main(String[] args) {
        String[] unsorted = {"robin","fulmar","blackbird","lesser black-backed gull","canada goose","blue tit","Canada goose","lapwing","carrion crow","lammergeier"};
        System.out.println("The unsorted array is...                         "+ toSeparatedString(unsorted," - "));
        System.out.println("The array sorted with my custom function is...   "+ toSeparatedString(sortAlph(unsorted)," - "));
        String[] sorted = unsorted;
        Arrays.sort(sorted);
        System.out.println("The array sorted with the native sort is...      "+ toSeparatedString(sorted," - "));
    }
}
