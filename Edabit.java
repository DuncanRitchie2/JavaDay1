package com.duncanritchie;

public class Edabit {
    public boolean areAnagrams(String one, String two) {
        return
    }

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
