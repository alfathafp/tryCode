package com.company;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class cobacode {

    @Test
    public void cobain(){
        String kalimat = "hari ini saya test di finaccel";
        HashMap<Character, Integer> hmap = new HashMap<>();
        char[] coba = kalimat.replace(" ", "").toCharArray();
        
        for (char hasilhchar: coba) {
            if (hmap.containsKey(hasilhchar)) {
                hmap.put(hasilhchar, hmap.get(hasilhchar)+1);
            } else {
                hmap.put(hasilhchar, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : hmap.entrySet()) {
            System.out.println(entry);
        }
    }

    @Test
    public void cobain2(){

        String kalimat = "apakahiyainipalindrome";
        char[] hasil2 = kalimat.toCharArray();
        int left = 0;
        int right = hasil2.length-1;
        String hasil = "";

        while (left < right){
            if (String.valueOf(Array.get(hasil2, left)).equals(String.valueOf(Array.get(hasil2, right)))){
                hasil = "palindrome";
            } else {
                hasil = "bukan paindrome";
                break;
            }
            left++;
            right--;
        }

        System.out.println(hasil);
    }

    @Test
    public void cobaStringFormat(){
        String merchant = "Farmer Market";
        String keyMerchant = String.format("%s_admin_fee", merchant).replace(" ", "_");

        System.out.println(keyMerchant);
    }

    @Test
    public void perhitungan(){
        Double persenan = 2.0;
        Double amount = 600000.0;
        Double hasilHitung = persenan/100 * amount;

        System.out.println(hasilHitung);
    }


}
