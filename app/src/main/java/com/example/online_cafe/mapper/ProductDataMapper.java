package com.example.online_cafe.mapper;

import com.example.online_cafe.products.ProductData;

import java.util.HashMap;

public class ProductDataMapper {
    public static ProductData mapToModel(HashMap<String , Object> map){
        return new ProductData(((Long) map.get("productPicturePath")).intValue(), (String) map.get("productName"),(Long) map.get("productPrice"));
    }
}
