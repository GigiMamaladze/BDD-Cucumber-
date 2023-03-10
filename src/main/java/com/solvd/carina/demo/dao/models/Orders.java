package com.solvd.carina.demo.dao.models;

public class Orders {

    private Long id;

    private String product;

    private float price;

    private Long userId;


    public Orders(Long id, String product, float price, Long userId) {
        this.id = id;
        this.product = product;
        this.price = price;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", userId=" + userId +
                '}';
    }
}
