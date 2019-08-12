package com.duncanritchie;

import java.util.Arrays;

// I was doing some challenges on Edabit when the site suffered internal server errors.
// So I saved my code here.

public class Edabit {
    // Input two Strings, and the return is whether they are anagrams (boolean).
    public boolean areAnagrams(String one, String two) {
        String[] array1 = one.split("");
        Arrays.sort(array1);
        String[] array2 = two.split("");
        Arrays.sort(array2);
        return array1.toString().equals(array2.toString());
    }

    // Input a String, the return is In aLtErNaTiNg cApS.
    public String alternatingCaps(String s) {
        String[] array = s.split("");
        for (int i = 0; i < array.length; i++) {
            if (i%2 == 0) {
                array[i] = array[i].toUpperCase();
            }
            else {
                array[i] = array[i].toLowerCase();
            }
        }
        return array.toString();
    }
}
