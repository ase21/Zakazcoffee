package ru.zakazcoffee.shop.data.models;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("name")
    String name;

    @SerializedName("email")
    String email;

    @SerializedName("phone")
    String phone;

    @SerializedName("adress")
    String address;

    @SerializedName("photo")
    String photo;

    public User(String name, String email, String phone, String address, String photo) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
