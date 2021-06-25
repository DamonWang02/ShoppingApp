package com.example.shopping.bean;

public class RecyclerviewItemBean {

    private String imageURL;
    private String name;
    private String price;
    private String id;

    public RecyclerviewItemBean(){

    }

    public RecyclerviewItemBean(String imageURL, String name, String price, String id){
        this.imageURL = imageURL;
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public RecyclerviewItemBean(String imageURL, String name, String id){
        this.imageURL = imageURL;
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
