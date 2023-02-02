package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class tryprop {

    @Test
    public static void main(String[] args) {
//        int harga = 600000;
//        Locale myIndonesianLocale = new Locale("in", "ID");
//        NumberFormat formater = NumberFormat.getCurrencyInstance(myIndonesianLocale);
//
//        System.out.println(formater.format(harga).replace(",00", ""));

        final String EDC_INSTALLMENT_RADIO_BUTTON= "//android.widget.RadioButton[contains(@text, '%s')]";
        String days30 = "Bayar dalam 30 hari (bunga 0%)";

        System.out.println(String.format(EDC_INSTALLMENT_RADIO_BUTTON, days30));


    }

    @Test
    private static Double CalculateMonthlyPayment(Double installment, Double tenure, Double interest){
        Double monthlyInterest = 0.00;
        if(interest != 0.00){
            monthlyInterest = installment * interest / 100;
        }
        Double monthlyPayment 	= CeilingNumber((installment / tenure) + monthlyInterest);
        return monthlyPayment;
    }

    private static Double CeilingNumber(Double input){
        Double output= Math.ceil(input/10) * 10;
        return output;
    }
}
