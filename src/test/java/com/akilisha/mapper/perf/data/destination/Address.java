package com.akilisha.mapper.perf.data.destination;

import java.util.Objects;

public class Address {

    private String street;
    private String city;
    private String postalCode;
    private String country;

    public Address() {
    }

    public Address(String street, String city, String postalCode, String country) {

        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() == Address.class) {
            Address address =
                    (Address) o;
            return Objects.equals(street, address.getStreet()) &&
                    Objects.equals(city, address.getCity()) &&
                    Objects.equals(postalCode, address.getPostalCode()) &&
                    Objects.equals(country, address.getCountry());
        }
        if (o.getClass() != getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) &&
                Objects.equals(city, address.city) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {

        return Objects.hash(street, city, postalCode, country);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
