package com.example.xmltry;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.xmltry.Currency.*;

public class Main {

    public static void main(String[] args) {
        CurrencyConverter item = new CurrencyConverter();


        item.performAnalysis(EUR,USD);
        item.performAnalysis(USD,JPY);
        item.performAnalysis(GBP,CHF);
        item.performAnalysis(AUD,USD);
        item.performAnalysis(USD,CHF);
        item.performAnalysis(GBP,USD);





    }

}
