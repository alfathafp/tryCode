package com.company;

import org.apache.poi.ss.formula.functions.Finance;
import org.junit.Test;

public class installmentThings {


    @Test
    public void getMonthlyInstallmentPL() {

        String tenure = "3";
        Double amount = 600000.0;
        Double adminFeeMerchant = (2.0/100.0) * amount;
        Double adminFeeKredivo = null;

        if (tenure.equals("30")){
            adminFeeKredivo = (amount + adminFeeMerchant)*(1.0/100.0);
        } else if (tenure.equals("3")){
            adminFeeKredivo = (amount + adminFeeMerchant)*(3.0/100.0);
        }

        System.out.println(adminFeeKredivo + adminFeeMerchant + amount);

//        double juml = amount+adminFeeKredivo+adminFeeMerchant;

//        int term = Integer.parseInt(tenure);
//        double yearlyInterest = 46.85;
//        double rate = 0.0;
//        Double monthlyInstallment = 0.0;
//        if (term == 6) {
//            rate = yearlyInterest / 100 / 12;
//            monthlyInstallment = Math.abs(Finance.pmt(rate, term, amount, 0, 0));
//        } else if (term == 12) {
//            rate = yearlyInterest / 100 / 12;
//            monthlyInstallment = Math.abs(Finance.pmt(rate, term, amount, 0, 0));
//        } else if (term == 3) {
//            rate = yearlyInterest / 100 / 12;
//            monthlyInstallment = Math.abs(Finance.pmt(rate, term, amount, 0, 0));
//        } else{
//            monthlyInstallment = amount;
//        }
//        System.out.println("monthlyInstallment : " + monthlyInstallment);
//        System.out.println("totalInstallment: " + roundNumberToHighestOnUI(monthlyInstallment));

//        int hasil =  roundNumberToHighestOnUI(monthlyInstallment);
//        System.out.println(hasil);
    }

    public static Integer roundNumberToHighestOnUI(Double value){
        Integer value2 = value.intValue();
        return (value2 + 9) / 10 * 10;
    }

}
