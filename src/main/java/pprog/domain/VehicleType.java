package pprog.domain;

public class VehicleType {

    public enum TypeTransport {
        PASSENGERS, MIXED;
        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
        }
    }
    public enum PackageWeight {
        LIGHT, HEAVY;
        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
        }
    }
    public enum Transport {
        OPEN_BOX, CLOSED_VANS, TRUCKS;
        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
        }
    }

    private TypeTransport typeTransport;
    private PackageWeight packageWeight;
    private Transport transport;

    public VehicleType(TypeTransport typeTransport, PackageWeight packageWeight, Transport transport) {
        this.typeTransport = typeTransport;
        this.packageWeight = packageWeight;
        this.transport = transport;
    }

    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(TypeTransport typeTransport) {
        this.typeTransport = typeTransport;
    }

    public PackageWeight getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(PackageWeight packageWeight) {
        this.packageWeight = packageWeight;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return String.format("Type Transport: %s\nPackage Weight: %s\nTransport: %s",
                typeTransport, packageWeight, transport);
    }
}

