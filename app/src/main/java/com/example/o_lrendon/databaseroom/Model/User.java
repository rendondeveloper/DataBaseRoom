package com.example.o_lrendon.databaseroom.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class User
{
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String email;
    private String nameAndLastName;
    private String Address;

    public User() {
    }

    public User(String email, String nameAndLastName, String address) {
        this.email = email;
        this.nameAndLastName = nameAndLastName;
        Address = address;
    }

    public User(int uid,String email, String nameAndLastName, String address) {
        this.uid = uid;
        this.email = email;
        this.nameAndLastName = nameAndLastName;
        Address = address;
    }


    @NonNull
    public int getUid() {
        return uid;
    }

    public void setUid(@NonNull int uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameAndLastName() {
        return nameAndLastName;
    }

    public void setNameAndLastName(String nameAndLastName) {
        this.nameAndLastName = nameAndLastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
