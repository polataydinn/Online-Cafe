package com.example.online_cafe.products;

public class ProductData {
    public int productPicturePath = 0;
    public String productName = "";
    public Long productPrice = 0L;

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

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public ProductData(int productPicturePath, String productName, Long productPrice) {
        this.productPicturePath = productPicturePath;
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
