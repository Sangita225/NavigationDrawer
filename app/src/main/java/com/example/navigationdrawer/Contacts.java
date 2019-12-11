package com.example.navigationdrawer;

public class Contacts {

private  String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    private  String Phone;
    private  int imgId;

    public Contacts(String name, String phone, int imgId) {
        Name = name;
        Phone = phone;
        this.imgId = imgId;
    }





}
