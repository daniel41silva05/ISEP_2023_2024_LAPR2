package pprog.domain;

import java.io.Serializable;

/**
 * Represents a green space.
 */
public class GreenSpace implements Serializable {

    private String name;

    private Address address;

    private GreenSpaceType type;

    private double area;

    private GreenSpacesManager greenSpacesManager;

    /**
     * Constructs a GreenSpace object.
     *
     * @param name              the name of the green space
     * @param address           the address of the green space
     * @param type              the type of the green space
     * @param area              the area of the green space
     * @param greenSpacesManager the manager of the green space
     */
    public GreenSpace(String name, String[] address, int type, double area, GreenSpacesManager greenSpacesManager) {
        this.name = name;
        this.address = new Address(address);
        this.type = GreenSpaceType.fromInt(type);
        this.area = area;
        this.greenSpacesManager = greenSpacesManager;
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        GreenSpace outroGreenSpace = (GreenSpace) outroObjeto;
        return name.equalsIgnoreCase(outroGreenSpace.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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

    public GreenSpacesManager getGreenSpacesManager() {
        return greenSpacesManager;
    }

    public void setGreenSpacesManager(GreenSpacesManager greenSpacesManager) {
        this.greenSpacesManager = greenSpacesManager;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAddress: %s\nType: %s\nArea: %.2f\nManaged by: %s\n", name, address, type, area, greenSpacesManager);
    }
}
