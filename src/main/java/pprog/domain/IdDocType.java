package pprog.domain;

/**
 * Enum representing different types of identification documents.
 */
public enum IdDocType {
    /** Taxpayer number. */
    TAXPAYER_NUMBER,

    /** Citizen card. */
    CITIZEN_CARD,

    /** Passport. */
    PASSPORT;

    /**
     * Returns a string representation of the identification document type.
     * The first letter is capitalized, and underscores are replaced with spaces.
     *
     * @return The string representation of the identification document type.
     */
    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}



