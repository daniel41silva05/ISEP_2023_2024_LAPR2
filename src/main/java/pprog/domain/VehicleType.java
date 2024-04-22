package pprog.domain;

public class VehicleType {

    public enum PassengersOrMixed {
        PASSENGERS, MIXED
    }
    public enum LightOrHeavy {
        LIGHT, HEAVY
    }
    public enum OpenBoxOrClosedVansOrTrucks {
        OPEN_BOX, CLOSED_VANS, TRUCKS
    }

    private PassengersOrMixed passengersOrMixed;
    private LightOrHeavy lightOrHeavy;
    private OpenBoxOrClosedVansOrTrucks openBoxOrClosedVansOrTrucks;

    public VehicleType(PassengersOrMixed passengersOrMixed, LightOrHeavy lightOrHeavy, OpenBoxOrClosedVansOrTrucks openBoxOrClosedVansOrTrucks) {
        this.passengersOrMixed = passengersOrMixed;
        this.lightOrHeavy = lightOrHeavy;
        this.openBoxOrClosedVansOrTrucks = openBoxOrClosedVansOrTrucks;
    }

    public PassengersOrMixed getPassengersOrMixed() {
        return passengersOrMixed;
    }

    public void setPassengersOrMixed(PassengersOrMixed passengersOrMixed) {
        this.passengersOrMixed = passengersOrMixed;
    }

    public LightOrHeavy getLightOrHeavy() {
        return lightOrHeavy;
    }

    public void setLightOrHeavy(LightOrHeavy lightOrHeavy) {
        this.lightOrHeavy = lightOrHeavy;
    }

    public OpenBoxOrClosedVansOrTrucks getOpenBoxOrClosedVansOrTrucks() {
        return openBoxOrClosedVansOrTrucks;
    }

    public void setOpenBoxOrClosedVansOrTrucks(OpenBoxOrClosedVansOrTrucks openBoxOrClosedVansOrTrucks) {
        this.openBoxOrClosedVansOrTrucks = openBoxOrClosedVansOrTrucks;
    }

    @Override
    public String toString() {
        return String.format("Passengers/Mixed: %s\nLight/Heavy: %s\nOpenBox/ClosedVans/Trucks: %s",
                passengersOrMixed, lightOrHeavy, openBoxOrClosedVansOrTrucks);
    }
}

