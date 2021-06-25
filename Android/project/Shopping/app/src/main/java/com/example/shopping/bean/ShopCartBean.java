package com.example.shopping.bean;

public class ShopCartBean {

    private String imageURL;
    private String name;
    private String price;
    private String id;

    @Override
    public String toString() {
        return "ShopCartBean{" +
                "imageURL='" + imageURL + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public ShopCartBean(String imageURL, String name, String price, String id){
        this.imageURL = imageURL;
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
