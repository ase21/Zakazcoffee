package ru.zakazcoffee.shop.data.models;

public class Rules {

    private String title;

    private String message;

    public Rules(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
