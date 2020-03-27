package ru.zakazcoffee.shop.data.models;

public class RequestToken {

    private String grant_type;

    private String code;

    private String client_id;

    private String client_secret;

    private String redirect_uri;

    public RequestToken(String grant_type, String code, String client_id, String client_secret, String redirect_uri) {
        this.grant_type = grant_type;
        this.code = code;
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.redirect_uri = redirect_uri;
    }
}
