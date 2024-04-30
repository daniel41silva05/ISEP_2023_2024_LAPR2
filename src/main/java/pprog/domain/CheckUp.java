package pprog.domain;

import java.util.Objects;

/**
 * Represents a vehicle check-up.
 */
public class CheckUp {

    private String plate; // The plate number of the vehicle
    private Date date; // The date of the check-up
    private double KMS; // The kilometers covered by the vehicle at the time of the check-up

    /**
     * Constructs a CheckUp object with the specified date, plate number, and kilometers.
     *
     * @param date The date of the check-up
     * @param plate The plate number of the vehicle
     * @param KMS The kilometers covered by the vehicle
     */
    public CheckUp(Date date, String plate, double KMS) {
        this.date = date;
        this.plate = plate;
        this.KMS = KMS;
    }

    /**
     * Gets the kilometers covered by the vehicle at the time of the check-up.
     *
     * @return The kilometers covered
     */
    public double getKMS() {
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

    /**
     * Gets the plate number of the vehicle.
     *
     * @return The plate number
     */
    public String getPlate() {
        return plate.toString();
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
    public void setKMS(double KMS) {
        this.KMS = KMS;
    }

    /**
     * Sets the plate number of the vehicle.
     *
     * @param plate The plate number
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * Returns a string representation of the CheckUp object.
     *
     * @return A string representation of the object
     */
    @Override
    public String toString(){ return date + " " + plate + " " + KMS; }

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
        return Double.compare(KMS, checkUp.KMS) == 0 && Objects.equals(plate, checkUp.plate) && Objects.equals(date, checkUp.date);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(plate, date, KMS);
    }
}
