package com.example.online_cafe.products;

public class UserPaymentDataClass {
    private String userNameAndSurname;
    private Long totalAmount;
    private boolean isQrRead ;

    public UserPaymentDataClass() {
    }

    public String getUserNameAndSurname() {
        return userNameAndSurname;
    }
    public boolean isQrRead(){return isQrRead;}

    public void setUserNameAndSurname(String userNameAndSurname) {
        this.userNameAndSurname = userNameAndSurname;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setQrRead(boolean isQrRead){this.isQrRead = isQrRead;}

    public UserPaymentDataClass(String userNameAndSurname, Long totalAmount,boolean isQrRead) {
        this.userNameAndSurname = userNameAndSurname;
        this.totalAmount = totalAmount;
        this.isQrRead = isQrRead;
    }

}
