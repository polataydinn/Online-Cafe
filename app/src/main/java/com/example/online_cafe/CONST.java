package com.example.online_cafe;

import com.example.online_cafe.authentication.Authentication;
import com.example.online_cafe.products.ProductData;
import com.example.online_cafe.products.UserPaymentDataClass;

import java.util.ArrayList;
import java.util.List;

public abstract class CONST {
    public static String userType = "";
    public static Long totalAmount = 0L;
    public static List<ProductData> listOfOrders = new ArrayList<ProductData>();
    public static Boolean isProductSelected = false;
    public static String UUID = "";
    public static String qrResult = "";
    public static UserPaymentDataClass usersNameAndSurname = new UserPaymentDataClass();
    public static ArrayList<ProductData> orderListToFinish = new ArrayList<>();
    public static ArrayList<UserPaymentDataClass> userListToFinish = new ArrayList<>();
    public static Long waiterTotalAmount = 0L;
    public static String waiterUserName = "";
}
