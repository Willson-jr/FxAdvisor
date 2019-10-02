package com.example.xmltry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CurrencyConverter {
    private static CurrencyConverter item;

    public String tests() {
        try {
            URL url = new URL("http://www.floatrates.com/daily/eur.xml");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            System.out.println(line);
            String wordToFind = "bid";
            Pattern word = Pattern.compile(wordToFind);
            Matcher match = word.matcher(line);
            int start = 0;
            int end = 0;
            while (match.find()) {
                end = (match.end() - 1);
            }
            String value = line.substring(end + 3, end + 9);
            return "poop";
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static double todayCourseNbpBid(Currency it) {
        try {
            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/" + it.getName());
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            String wordToFind = "bid";

            Pattern word = Pattern.compile(wordToFind);
            Matcher match = word.matcher(line);
            int start = 0;
            int end = 0;
            while (match.find()) {
                end = (match.end() - 1);
            }
            String value = line.substring(end + 3, end + 9);


            return Double.parseDouble(value);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public static double yesterdayCourseNbpBid(Currency it) {
        try {
            LocalDate today = LocalDate.now();
            LocalDate yesterday = today.minus(Period.ofDays(1));
            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/" + it.getName()+"/"+yesterday);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            String wordToFind = "bid";
            Pattern word = Pattern.compile(wordToFind);
            Matcher match = word.matcher(line);
            int start = 0;
            int end = 0;
            while (match.find()) {
                end = (match.end() - 1);
            }
            String value = line.substring(end + 3, end + 9);
            return Double.parseDouble(value);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public static double todayCourseNbpAsk(Currency it) {
        try {
            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/" + it.getName());
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            String wordToFind = "ask";
            Pattern word = Pattern.compile(wordToFind);
            Matcher match = word.matcher(line);
            int start = 0;
            int end = 0;
            while (match.find()) {
                end = (match.end() - 1);
            }
            String value = line.substring(end + 3, end + 9);
            return Double.parseDouble(value);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public static double yesterdayCourseNbpAsk(Currency it) {
        try {
            LocalDate today = LocalDate.now();
            LocalDate yesterday = today.minus(Period.ofDays(1));
            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/" + it.getName()+"/"+yesterday);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            String wordToFind = "ask";
            Pattern word = Pattern.compile(wordToFind);
            Matcher match = word.matcher(line);
            int start = 0;
            int end = 0;
            while (match.find()) {
                end = (match.end() - 1);
            }
            String value = line.substring(end + 3, end + 9);

            return Double.parseDouble(value);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static double pairTodayNbpBid(Currency first, Currency second){
        double result = todayCourseNbpBid(first)/todayCourseNbpBid(second);
        double number2 = (int)(Math.round(result * 10000))/10000.0000;
        return number2;
    }
    public static double pairTodayNbpAsk(Currency first, Currency second){
        double result = todayCourseNbpAsk(first)/todayCourseNbpAsk(second);
        double number2 = (int)(Math.round(result * 10000))/10000.0000;
        return number2;
    }
    public static double pairTodayNbpAvg(Currency first, Currency second){
        return ((pairTodayNbpAsk(first, second)+pairTodayNbpBid(first, second))/2);
    }

    public static double pairYesterdayNbpBid(Currency first, Currency second){
        double result = yesterdayCourseNbpBid(first)/yesterdayCourseNbpBid(second);
        double number2 = (int)(Math.round(result * 10000))/10000.0000;
        return number2;
    }
    public static double pairYesterdayNbpAsk(Currency first, Currency second){
        double result = yesterdayCourseNbpAsk(first)/yesterdayCourseNbpAsk(second);
        double number2 = (int)(Math.round(result * 10000))/10000.0000;
        return number2;
    }
    public static double pairYesterdayNbpAvg(Currency first, Currency second){
        return ((pairYesterdayNbpAsk(first, second)+pairYesterdayNbpBid(first, second))/2);
    }

    public static double todayEurope(Currency first, Currency second){
        try {
            URL url = new URL("https://api.exchangeratesapi.io/latest?base="+first.getName());
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();

            String wordToFind = String.valueOf(second.getName());
            Pattern word = Pattern.compile(wordToFind);
            Matcher match = word.matcher(line);
            int start = 0;
            int end = 0;
            while (match.find()) {
                end = (match.end() - 1);
            }
            String value = line.substring(end + 3, end + 9);


            return Double.parseDouble(value);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public static double yesterdayEurope(Currency first, Currency second){
        try {
            LocalDate today = LocalDate.now();
            LocalDate yesterday = today.minus(Period.ofDays(1));
            URL url = new URL("https://api.exchangeratesapi.io/"+yesterday+"?base="+first.getName());
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            String wordToFind = String.valueOf(second);
            Pattern word = Pattern.compile(wordToFind);
            Matcher match = word.matcher(line);
            int start = 0;
            int end = 0;
            while (match.find()) {
                end = (match.end() - 1);
            }
            String value = line.substring(end + 3, end + 9);


            return Double.parseDouble(value);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static double allTodayAvg(Currency first, Currency second){
        double averageBanks = (todayEurope(first, second)+pairTodayNbpAvg(first, second))/2;
        return averageBanks;
    }
    public static double allYesterdayAvg(Currency first,Currency second){
        double averageBanks = (yesterdayEurope(first, second)+pairYesterdayNbpAvg(first, second))/2;
        return averageBanks;
    }


    public static void compareNbp(Currency first, Currency second){
        System.out.println(first +"/" +second+" NBP info:");
        double today = pairTodayNbpAvg(first, second);
        System.out.println("Today course: "+ today);
        double yesterday = pairYesterdayNbpAvg(first, second);
        System.out.println("Yesterday course: "+ yesterday);
        double diff = today - yesterday;
        System.out.println("Differnce: "+diff);
        if (diff>0) System.out.println("Buy. Take Profit: "+(today+0.0004));
        else System.out.println("Sell. Take Profit: "+(today-0.0004));
    }
    public static void compareEurope(Currency first, Currency second){
        System.out.println(first +"/" +second+" Europe info:");
        double today = todayEurope(first, second);
        System.out.println("Today course: "+ today);
        double yesterday = yesterdayEurope(first, second);
        System.out.println("Yesterday course: "+ yesterday);
        double diff = today - yesterday;
        System.out.println("Differnce: "+diff);
        if (diff>0) System.out.println("Buy. Take Profit: "+(today+0.0004));
        else System.out.println("Sell. Take Profit: "+(today-0.0004));
    }
    public static void compareAvg(Currency first,Currency second){
        System.out.println(first +"/" +second+" AVG info:");
        double today = allTodayAvg(first, second);
        System.out.println("Today course: "+ today);
        double yesterday = allYesterdayAvg(first, second);
        System.out.println("Yesterday course: "+ yesterday);
        double diff = today - yesterday;
        System.out.println("Differnce: "+diff);
        if (diff>0) System.out.println("Buy. Take Profit: "+(today+0.0004));
        else System.out.println("Sell. Take Profit: "+(today-0.0004));
    }

    public static void performAnalysis(Currency first, Currency second){
        compareNbp(first, second);
        System.out.println("-------------------");
        compareEurope(first, second);
        System.out.println("-------------------");
        compareAvg(first, second);
        System.out.println("********************************************************");
    }



}

