package pprog.domain;

/**
 * Represents a date.
 */
public class Date {
    /** The day of the date. */
    private int day;

    /** The month of the date. */
    private int month;

    /** The year of the date. */
    private int year;

    /**
     * Constructs a Date object with the given day, month, and year.
     * @param day The day of the date.
     * @param month The month of the date.
     * @param year The year of the date.
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Gets the day of the date.
     * @return The day of the date.
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the day of the date.
     * @param day The new day of the date.
     * @throws IllegalArgumentException if the day is not between 1 and 31.
     */
    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid day");
        }
    }

    /**
     * Gets the month of the date.
     * @return The month of the date.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets the month of the date.
     * @param month The new month of the date.
     * @throws IllegalArgumentException if the month is not between 1 and 12.
     */
    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Invalid month");
        }
    }

    /**
     * Gets the year of the date.
     * @return The year of the date.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of the date.
     * @param year The new year of the date.
     * @throws IllegalArgumentException if the year is not between 0 and 10000.
     */
    public void setYear(int year) {
        if (year >= 0 && year <= 10000) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid year");
        }
    }

    /**
     * Returns a string representation of the date.
     * @return The string representation of the date in the format "day/month/year".
     */
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

}
