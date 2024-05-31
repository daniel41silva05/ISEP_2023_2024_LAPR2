package pprog.domain;

import java.io.Serializable;

public class Address implements Serializable {

    private String street;
    private String zipcode;
    private String city;

    public Address (String[] addressArray) {
        this.street = addressArray[0];
        this.zipcode = addressArray[1];
        this.city = addressArray[2];
    }
    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", street, zipcode, city);
    }
}
