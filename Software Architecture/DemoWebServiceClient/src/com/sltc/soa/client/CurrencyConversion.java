package com.sltc.soa.client;

import com.sltc.soa.client.stub.CurrencyConversionWs;
import com.sltc.soa.client.stub.CurrencyConversionWsService;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        CurrencyConversionWsService currencyConversionWsService = new CurrencyConversionWsService();
        CurrencyConversionWs currencyConversionWs = currencyConversionWsService.getCurrencyConversionWsPort();

        int flag = 0;
        System.out.println("\n------------WELCOME TO CURRENCY CONVERTER--------------");

        do {
            Scanner a = new Scanner(System.in);
            System.out.print("\nEnter Source Currency Type : ");
            String SourceCurrency = a.next();
            System.out.print("Enter Source Currency Amount : ");
            double SourceCurrencyAmount = a.nextDouble();
            System.out.print("Enter Target Currency Type : ");
            String TargetCurrency = a.next();
            double ans = currencyConversionWs.convert(SourceCurrencyAmount, SourceCurrency, TargetCurrency);
            System.out.println("\n------------------------------------");
            System.out.println(SourceCurrency + " " + SourceCurrencyAmount + " to " + TargetCurrency + "  =  " + TargetCurrency + " " + ans);//Display the Converted Amount
            System.out.println("------------------------------------");
            boolean z = false;

            do {
                System.out.println("\n\n1. Try Again( Enter 1 )\n2. Exit( Enter 0 )\n");
                System.out.print("Enter Your Selection :");
                int x = a.nextInt();
                if (x == 0) {
                    flag = 1;
                    break;
                } else if (x == 1) {
                    flag = 0;
                    break;
                } else {
                    System.out.println("Invalid Selection");
                    z = true;
                }
            } while (z);
        } while (flag == 0);

    }
}