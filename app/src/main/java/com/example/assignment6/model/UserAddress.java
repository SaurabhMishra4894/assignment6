package com.example.assignment6.model;

public class UserAddress {
    private String street;
    private String suite ;
    private String city;
    private String zipcode;

    /**
     * constructor to get the address of the user
     *
     * @param street
     * @param suite
     * @param city
     * @param zipcode
     */
    public UserAddress(String street, String suite, String city, String zipcode) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
    }

    /**
     *
     * @return street of address
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @return suite of address
     */
    public String getSuite() {
        return suite;
    }

    /**
     *
     * @return city of address
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @return zipcode of address
     */
    public String getZipcode() {
        return zipcode;
    }
}
