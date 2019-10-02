package com.example.xmltry;

import java.util.HashMap;
import java.util.Map;

public class ExchangeOffice {

    //Klucz - waluta,wartosc - ilosc waluty
    private Map<Currency,Double> availableFunds = new HashMap<>();

    public ExchangeOffice(double startWith) {
        for (Currency currency : Currency.values()) {
            availableFunds.put(currency,startWith);
        }
    }

    public void showFunds() {
        System.out.print("Current funds: ");
        for (Currency currency : availableFunds.keySet()) {
            Double value = availableFunds.get(currency);
            System.out.print(value+" "+ currency.getName()+"   ");
        }
        System.out.println();
    }

//    public void exchange(double amount, Currency from, Currency to) {
//        double available = availableFunds.get(to);
//        double needed = amount*CurrencyConverter.convert(from,to)*0.8;
//
//        if (available<needed) {
//            System.out.println("Cannot exchange");
//        }
//        else {
//            availableFunds.put(from,availableFunds.get(from)+amount);
//            availableFunds.put(to,availableFunds.get(to)-needed);
//        }
//        System.out.println("Exchanging "
//                +amount+" "
//                + from.getName()+" to "
//                + needed + " "+ to.getName());
//    }
}
