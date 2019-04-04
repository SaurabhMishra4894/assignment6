package com.example.assignment6.model;

public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    /**
     * Constructor company set the values while initialising
     *
     * @param name
     * @param catchPhrase
     * @param bs
     */
    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    /**
     * get the name of the Company
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * get the name of the catchphrase
     *
     * @return
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     * get the name of the Bs
     *
     * @return
     */
    public String getBs() {
        return bs;
    }
}
