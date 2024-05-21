package pprog.domain;

import java.util.Date;

public class GreenSpace {

    private String name;

    private String address;

    private int type;

    private double area;

    public GreenSpace(String name, String address, int type, double area) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return String.format("Vehicle\nName: %s\nAddress: %s\nType: %d\nArea: %.2f", name, address, type, area);
    }
}


