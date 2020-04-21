package ru.zakazcoffee.shop.data.models;

import com.google.gson.annotations.SerializedName;

public class News {
    @SerializedName(value = "id")
    private int newsId;

    @SerializedName(value = "image")
    private String newsTitle;

    @SerializedName(value = "logo")
    private String newsBody;

    public News(int newsId, String newsTitle, String newsBody) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsBody = newsBody;
    }

    public int getNewsId() {
        return newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsBody() {
        return newsBody;
    }
}
