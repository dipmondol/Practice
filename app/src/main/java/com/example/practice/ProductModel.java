package com.example.practice;

public class ProductModel {

    String imgUrl, productName, productCategory, tagPrice, salePrice, brand ,description;

    public ProductModel(){

    }

    public ProductModel(String imgUrl, String productName, String productCategory, String tagPrice, String salePrice, String brand, String description) {
        this.imgUrl = imgUrl;
        this.productName = productName;
        this.productCategory = productCategory;
        this.tagPrice = tagPrice;
        this.salePrice = salePrice;
        this.brand = brand;
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getTagPrice() {
        return tagPrice;
    }

    public void setTagPrice(String tagPrice) {
        this.tagPrice = tagPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
