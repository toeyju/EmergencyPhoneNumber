package com.example.emergencyphonenumber.model;


/**
 * Created by RTA on 11/26/2017.
 */

public class PhoneItem {

    public final  int id;
    public final String title;
    public  final String number;
    public final String picture;

    public PhoneItem(int id, String title, String number, String picture) { // สร้าง constructor กด ctrl+o
        this.id = id;
        this.title = title;
        this.number = number;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return title;
    }
}
