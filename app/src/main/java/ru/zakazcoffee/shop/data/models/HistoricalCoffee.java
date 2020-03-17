package ru.zakazcoffee.shop.data.models;

public class HistoricalCoffee {

    private int id;

    private String coffeeName;

    private String coffeeImageUrl;

    public HistoricalCoffee(int id, String coffeeName, String coffeeImageUrl) {
        this.id = id;
        this.coffeeName = coffeeName;
        this.coffeeImageUrl = coffeeImageUrl;
    }

    public int getId() {
        return id;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public String getCoffeeImageUrl() {
        return coffeeImageUrl;
    }
}
