package com.example.xmltry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testes {
    public static void main(String[] args) throws IOException {
        try {
            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/USD");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            System.out.println(line);
            String wordToFind = "bid";
            Pattern word = Pattern.compile(wordToFind);
            Matcher match = word.matcher(line);
            int start =0;
            int end =0;
            while (match.find()) {

                System.out.println((match.end() - 1));
                end = (match.end() - 1);
            }
            System.out.println(end);
            String value = line.substring(end+3, end+9);
            System.out.println(value);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
}

