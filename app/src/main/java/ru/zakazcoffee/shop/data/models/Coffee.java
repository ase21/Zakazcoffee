package ru.zakazcoffee.shop.data.models;

public class Coffee {

    private int coffeeId;

    private String coffeeName;

    private String coffeeImageUrl;

    private String coffeeConsist;

    private String coffeeWeight;

    private String coffeePrice;

    public Coffee(int coffeeId, String coffeeName, String coffeeImageUrl, String coffeeConsist, String coffeeWeight, String coffeePrice) {
        this.coffeeId = coffeeId;
        this.coffeeName = coffeeName;
        this.coffeeImageUrl = coffeeImageUrl;
        this.coffeeConsist = coffeeConsist;
        this.coffeeWeight = coffeeWeight;
        this.coffeePrice = coffeePrice;
    }

    public int getCoffeeId() {
        return coffeeId;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public String getCoffeeImageUrl() {
        return coffeeImageUrl;
    }

    public String getCoffeeConsist() {
        return coffeeConsist;
    }

    public String getCoffeeWeight() {
        return coffeeWeight;
    }

    public String getCoffeePrice() {
        return coffeePrice;
    }
}
