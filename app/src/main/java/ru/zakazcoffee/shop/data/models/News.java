package ru.zakazcoffee.shop.data.models;

public class News {

    private int newsId;

    private String newsTitle;

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
