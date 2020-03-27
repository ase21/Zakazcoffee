package ru.zakazcoffee.shop.data.models;

import com.google.gson.annotations.SerializedName;

public class TokenResponse {
    @SerializedName(value = "access_token")
    private String accessToken;

    @SerializedName(value = "refresh_token")
    private String refreshToken;

    @SerializedName(value = "expires")
    private String expires;

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getExpires() {
        return expires;
    }
}
