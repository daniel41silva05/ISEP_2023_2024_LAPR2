package pprog.domain.gs;

import java.io.Serializable;

public class GreenSpace implements Serializable {

    private String name;

    private String address;

    private GreenSpaceType type;

    private double area;

    public GreenSpace(String name, String address, int type, double area) {
        this.name = name;
        this.address = address;
        this.type = GreenSpaceType.fromInt(type);
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

    public GreenSpaceType getType() {
        return type;
    }

    public void setType(GreenSpaceType type) {
        this.type = type;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public GreenSpace clone() {
        return new GreenSpace(this.name, this.address, this.type.ordinal(), this.area);
    }

    @Override
    public String toString() {
        return String.format("Vehicle\nName: %s\nAddress: %s\nType: %s\nArea: %.2f", name, address, type, area);
    }
}


