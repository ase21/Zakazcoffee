package ru.zakazcoffee.shop.data.models;

import java.util.List;

public class MainInformation {

    private List<Banner> banners;
    private List<CoffeeCategory> coffeeCategories;
    private List<Coffee> topCoffees;
    private List<News> news;
    private List<Coffee> lastSeenCoffees;

    public MainInformation(List<Banner> banners, List<CoffeeCategory> coffeeCategories, List<Coffee> topCoffees, List<News> news, List<Coffee> lastSeenCoffees) {
        this.banners = banners;
        this.coffeeCategories = coffeeCategories;
        this.topCoffees = topCoffees;
        this.news = news;
        this.lastSeenCoffees = lastSeenCoffees;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public List<CoffeeCategory> getCoffeeCategories() {
        return coffeeCategories;
    }

    public List<Coffee> getTopCoffees() {
        return topCoffees;
    }

    public List<News> getNews() {
        return news;
    }

    public List<Coffee> getLastSeenCoffees() {
        return lastSeenCoffees;
    }
}
