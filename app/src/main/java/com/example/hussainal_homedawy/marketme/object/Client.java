package com.example.hussainal_homedawy.marketme.object;

public class Client {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private boolean male;

    public Client(String firstName, String lastName, String phoneNumber, int age, boolean male) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.male = male;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
