package com.wit.ie.doolysv2.model;


public class Food {

    private String name;
    private String imageLink;
    private String price;
    private String description;


    public Food(String name, String imageLink, String price, String description) {

        this.name = name;
        this.imageLink = imageLink;
        this.price = price;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageLink() {

        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
