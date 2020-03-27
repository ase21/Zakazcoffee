package ru.zakazcoffee.shop.data.models;

import com.google.gson.annotations.SerializedName;

public class Code {

    @SerializedName(value = "code")
    private String code;

    public String getCode() {
        return code;
    }
}
