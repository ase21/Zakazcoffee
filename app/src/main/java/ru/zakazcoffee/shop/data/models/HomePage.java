package ru.zakazcoffee.shop.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Locale;

public class HomePage {

    @SerializedName(value = "logo")
    String logo;

    @SerializedName(value = "category")
    List<CoffeeCategory> coffeeCategories;

    @SerializedName(value = "news")
    News news;
//
//    @SerializedName(value = "logo")
//    String logo;
//
//    @SerializedName(value = "logo")
//    String logo;
}
