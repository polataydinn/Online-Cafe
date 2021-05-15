package com.example.online_cafe.products;

public class ProductData {
    public int productPicturePath = 0;
    public String productName = "";
    public int productPrice = 0;

    public int getProductPicturePath() {
        return productPicturePath;
    }

    public void setProductPicturePath(int productPicturePath) {
        this.productPicturePath = productPicturePath;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public ProductData(int productPicturePath, String productName, int productPrice) {
        this.productPicturePath = productPicturePath;
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
