package com.example.assignment6.model;

public class Geo {
    private String lat;
    private String lng;

    /**
     * constructor set the values of lat and lng while initialising
     *
     * @param lat
     * @param lng
     */
    public Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    /**
     * get the lat of location
     * @return
     */
    public String getLat() {
        return lat;
    }

    /**
     * get the lng of location
     * @return
     */
    public String getLng() {
        return lng;
    }


}
