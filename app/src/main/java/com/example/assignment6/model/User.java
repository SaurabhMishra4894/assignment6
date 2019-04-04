package com.example.assignment6.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Class User defines a User and its features such as Name/Roll Number/Class
 */

public class User {


    private int id;
    private String name;
    private String username;
    private String email;
    private UserAddress address;
    private String phone;
    private String website;
    private Company company;

    /**
     * Constructor user which fetches data from the Api and set the details of the user
     *
     * @param id
     * @param name
     * @param username
     * @param email
     * @param address
     * @param phone
     * @param website
     * @param company
     */
    public User(int id, String name, String username, String email, UserAddress address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    /**
     * get the id of the user
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return address
     */
    public UserAddress getAddress() {
        return address;
    }

    /**
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @return website
     */
    public String getWebsite() {
        return website;
    }

    /**
     *
     * @return company
     */
    public Company getCompany() {
        return company;
    }
}

