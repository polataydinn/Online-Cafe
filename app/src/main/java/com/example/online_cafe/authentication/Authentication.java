package com.example.online_cafe.authentication;


public class Authentication {
    private String nameSurname;
    private String username;
    private String password;

    public Authentication(){}

    public Authentication(String nameSurname, String username, String password) {
        this.nameSurname = nameSurname;
        this.username = username;
        this.password = password;
    }
}
