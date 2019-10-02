package com.example.xmltry;

public enum Currency {
    USD("USD"),
    PLN("PLN"),
    JPY("JPY"),
    EUR("EUR"),
    GBP("GBP"),
    RUB("RUB"),
    CZK("CZK"),
    CHF("CHF"),
    CAD("CAD"),
    AUD("AUD");



    private String name;

    Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
