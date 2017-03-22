package com.luisbar.cleanarchitecturefornoobs.presentation.scene.main;

public class MainModel {

    private String Product;
    private int Quantity;
    private int Price;
    private int Discount;
    private int priceWithDiscount;

    private String message;

    public MainModel(String product, int quantity, int price, int discount, int priceWithDiscount, String message) {
        Product = product;
        Quantity = quantity;
        Price = price;
        Discount = discount;
        this.priceWithDiscount = priceWithDiscount;
        this.message = message;
    }

    public MainModel(String product, int quantity, int price, int discount, int priceWithDiscount) {
        Product = product;
        Quantity = quantity;
        Price = price;
        Discount = discount;
        this.priceWithDiscount = priceWithDiscount;
    }

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

    public MainModel(String message) {
        this.message = message;
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

    public int getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(int priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
