package ru.zakazcoffee.shop.data.models;

import com.google.gson.annotations.SerializedName;

public class CoffeeCategory {

    @SerializedName(value = "category_id")
    private int categoryId;

    @SerializedName(value = "parent_id")
    private String parentId;

    @SerializedName(value = "image")
    private String categoryImageUrl;

    @SerializedName(value = "status")
    private String status;

    @SerializedName(value = "top")
    private String top;

    @SerializedName(value = "name")
    private String categoryName;

    @SerializedName(value = "description")
    private String categoryDescription;

    public int getCategoryId() {
        return categoryId;
    }

    public String getParentId() {
        return parentId;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public String getStatus() {
        return status;
    }

    public String getTop() {
        return top;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }
}
