package com.company;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMinimumFractionDigits(1);


        double monthlyPayment = 100;
        System.out.println("Monthly Payment: "+ monthlyPayment);
        System.out.println();



        String table = "       ";
        for (double rate = 5.0; rate < 7.0; rate += .5){
            table += percent.format(rate/100)+ "\t" + "\t";


        }
        table += "\n";

        for(int years =4;years >1; years--){


            String row = years+ "  ";
            for ( double rate = 5.0; rate<7.0; rate += .5){

                int months = years*12;

                double monthlyInterestRate = rate/12/100;
                double futureValue = 0.0;
                for (int i =1;i<= months;i++){
                    futureValue =
                            (futureValue + monthlyPayment) * (1 + monthlyInterestRate) ;


                }
                row += currency.format(futureValue)+"   ";
            }
            table +=row + "\n";
        }
        System.out.println(table);

    }
}


