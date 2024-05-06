package pprog.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a vehicle check-up.
 */
public class CheckUp {

    private Vehicle vehicle;
    private Date date;
    private int KMS;

    public CheckUp(Date date, Vehicle vehicle, int KMS) {
        this.date = date;
        this.vehicle = vehicle;
        this.KMS = KMS;
    }

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
    public Date getDate() {
        return date;
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

    public CheckUp clone() {
        return new CheckUp(this.date, this.vehicle, this.KMS);
    }

    @Override
    public String toString(){ return date + " " + vehicle + " " + KMS; }
}