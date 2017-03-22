package com.luisbar.cleanarchitecturefornoobs.domain.saveproduct;

public class MainModel {

    private String Product;
    private int Quantity;
    private int Price;
    private int Discount;

    private String message;

    public MainModel(String product, int quantity, int price, int discount, String message) {
        Product = product;
        Quantity = quantity;
        Price = price;
        Discount = discount;
        this.message = message;
    }

    public MainModel(String product, int quantity, int price, int discount) {
        Product = product;
        Quantity = quantity;
        Price = price;
        Discount = discount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int discount) {
        Discount = discount;
    }
}
