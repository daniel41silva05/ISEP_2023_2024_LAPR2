package pprog.domain;

/**
 * Represents the type of a vehicle.
 */
public class VehicleType {

    /**
     * Enum representing types of transport.
     */
    public enum TypeTransport {
        PASSENGERS, MIXED;

        /**
         * Overrides the toString method to provide a formatted string representation.
         * @return The formatted string representation of the enum.
         */
        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
        }
    }

    /**
     * Enum representing package weight.
     */
    public enum PackageWeight {
        LIGHT, HEAVY;

        /**
         * Overrides the toString method to provide a formatted string representation.
         * @return The formatted string representation of the enum.
         */
        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
        }
    }

    /**
     * Enum representing types of transport.
     */
    public enum Transport {
        OPEN_BOX, CLOSED_VANS, TRUCKS;

        /**
         * Overrides the toString method to provide a formatted string representation.
         * @return The formatted string representation of the enum.
         */
        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
        }
    }

    /**
     * The type of transport associated with the package.
     */
    private TypeTransport typeTransport;

    /**
     * The weight category of the package.
     */
    private PackageWeight packageWeight;

    /**
     * The transport information for the package.
     */
    private Transport transport;

    /**
     * Constructs a VehicleType object.
     *
     * @param typeTransport The type of transport.
     * @param packageWeight The package weight.
     * @param transport The transport type.
     */
    public VehicleType(TypeTransport typeTransport, PackageWeight packageWeight, Transport transport) {
        this.typeTransport = typeTransport;
        this.packageWeight = packageWeight;
        this.transport = transport;
    }

    /**
     * Gets the type of transport.
     * @return The type of transport.
     */
    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    /**
     * Sets the type of transport.
     * @param typeTransport The type of transport to set.
     */
    public void setTypeTransport(TypeTransport typeTransport) {
        this.typeTransport = typeTransport;
    }

    /**
     * Gets the package weight.
     * @return The package weight.
     */
    public PackageWeight getPackageWeight() {
        return packageWeight;
    }

    /**
     * Sets the package weight.
     * @param packageWeight The package weight to set.
     */
    public void setPackageWeight(PackageWeight packageWeight) {
        this.packageWeight = packageWeight;
    }

    /**
     * Gets the transport type.
     * @return The transport type.
     */
    public Transport getTransport() {
        return transport;
    }

    /**
     * Sets the transport type.
     * @param transport The transport type to set.
     */
    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    /**
     * Overrides the toString method to provide a formatted string representation.
     * @return The formatted string representation of the VehicleType object.
     */
    @Override
    public String toString() {
        return String.format("Type Transport: %s\nPackage Weight: %s\nTransport: %s",
                typeTransport, packageWeight, transport);
    }
}

