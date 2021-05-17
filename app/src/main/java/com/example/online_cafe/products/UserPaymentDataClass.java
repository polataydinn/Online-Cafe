package com.example.online_cafe.products;

public class UserPaymentDataClass {
    private String userNameAndSurname;
    private Long totalAmount;

    public UserPaymentDataClass() {
    }

    public String getUserNameAndSurname() {
        return userNameAndSurname;
    }

    public void setUserNameAndSurname(String userNameAndSurname) {
        this.userNameAndSurname = userNameAndSurname;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public UserPaymentDataClass(String userNameAndSurname, Long totalAmount) {
        this.userNameAndSurname = userNameAndSurname;
        this.totalAmount = totalAmount;
    }

}
