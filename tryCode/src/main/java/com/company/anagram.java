package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class anagram {

    @Test
    public void anagram() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("input your anagram text 1 here: ");
        String str1 = scanner.nextLine();
        System.out.print("input your anagram text 2 here: ");
        String str2 = scanner.nextLine();

        anagram mn = new anagram();
        boolean result = mn.anagramMethod(str1, str2);

        System.out.println((result) ? "Anagram" : "not anagram");

//        int a = 0;
//        int b = 2;
//        int n = 10;
//
//
//        int result = 0;
//        System.out.println(result);
//
//        for (int i = 0; i < n; i++) {
//            result = a + 1 * b;
//        }
//
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int n = scanner.nextInt();
//
//        int calc = a;
//        for(int j=0;j<n;j++)
//        {
//            calc+=(Math.pow(2,j)*b);
//            System.out.print(calc+" ");
//        }
//        System.out.println();
//        scanner.close();

    }

    public boolean anagramMethod(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        } else {
            char[] ch1 = str1.toCharArray();
            char[] ch2 = str2.toCharArray();

            Arrays.sort(ch1);
            Arrays.sort(ch2);

            return Arrays.equals(ch1, ch2);
        }

    }
}
