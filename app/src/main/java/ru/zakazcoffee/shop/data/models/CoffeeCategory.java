package ru.zakazcoffee.shop.data.models;

public class CoffeeCategory {

    private int categoryId;

    private String categoryName;

    private String categoryImageUrl;

    public CoffeeCategory(int categoryId, String categoryImageUrl, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryImageUrl = categoryImageUrl;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }
}
