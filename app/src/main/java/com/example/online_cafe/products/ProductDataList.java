package com.example.online_cafe.products;

import java.util.ArrayList;

public class ProductDataList {
    ArrayList<ProductData> list;

    public ProductDataList(ArrayList<ProductData> list) {
        this.list = list;
    }

    public ArrayList<ProductData> getList() {
        return list;
    }

    public void setList(ArrayList<ProductData> list) {
        this.list = list;
    }
}
