package com.example.online_cafe.mapper;

import com.example.online_cafe.products.UserPaymentDataClass;

import java.util.HashMap;

public class UserPaymentDataMapper {
    public static UserPaymentDataClass mapToModel(HashMap<String , Object> map){
        return new UserPaymentDataClass((String) map.get("userNameAndSurname"),(Long) map.get("totalAmount"),(boolean) map.get("isQrRead"));
    }
}

