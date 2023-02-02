package com.company;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testCode {
    public static void main(String[] args) throws ParseException {
        testCode tc = new testCode();
        tc.comparsionDate("2022-12-31");
    }


    public boolean comparsionDate(String d1) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date dated1 = formatter.parse(d1);
        Date dateToday = new Date(System.currentTimeMillis());

        if (dated1.equals(dateToday)){
            System.out.println("date equals");
            return true;
        } else if (dated1.after(dateToday)){
            System.out.println("day after");
            return false;
        } else {
            System.out.println("day before");
            return true;
        }
    }
}
