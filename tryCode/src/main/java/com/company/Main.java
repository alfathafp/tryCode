package com.company;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String inputText = "Alfath febriadi pratama".
                toLowerCase(Locale.ROOT).replace(" ", "");
        char[] charInputText = inputText.toCharArray();
        HashMap<Character, Integer> charMap = new HashMap<>();

        for (char eachChar : charInputText) {
            if (charMap.containsKey(eachChar)) {
                charMap.put(eachChar, charMap.get(eachChar) + 1);
            } else {
                charMap.put(eachChar, 1);
            }
        }

        for (Map.Entry<Character, Integer>
                finalChar : charMap.entrySet()) {
            System.out.println(finalChar);
        }
    }

}


