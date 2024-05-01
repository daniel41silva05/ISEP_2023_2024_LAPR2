package pprog.domain;

import java.util.Objects;

/**
 * Represents a vehicle check-up.
 */
public class CheckUp {

    private Vehicle vehicle;
    private Date date; // The date of the check-up
    private int KMS; // The kilometers covered by the vehicle at the time of the check-up

    public CheckUp(Date date, Vehicle vehicle, int KMS) {
        this.date = date;
        this.vehicle = vehicle;
        this.KMS = KMS;
    }

    /**
     * Gets the kilometers covered by the vehicle at the time of the check-up.
     *
     * @return The kilometers covered
     */
    public int getKMS() {
        return KMS;
    }

    /**
     * Gets the date of the check-up.
     *
     * @return The date of the check-up
     */
    public String getDate() {
        return date.toString();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Sets the date of the check-up.
     *
     * @param date The date of the check-up
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Sets the kilometers covered by the vehicle.
     *
     * @param KMS The kilometers covered
     */
    public void setKMS(int KMS) {
        this.KMS = KMS;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Returns a string representation of the CheckUp object.
     *
     * @return A string representation of the object
     */
    @Override
    public String toString(){ return date + " " + vehicle + " " + KMS; }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (! ( o instanceof CheckUp))) return false;
        CheckUp checkUp = (CheckUp) o;
        return Double.compare(KMS, checkUp.KMS) == 0 && Objects.equals(vehicle, checkUp.vehicle) && Objects.equals(date, checkUp.date);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(date, vehicle, KMS);
    }

    public CheckUp clone() {
        return new CheckUp(this.date, this.vehicle, this.KMS);
    }
}