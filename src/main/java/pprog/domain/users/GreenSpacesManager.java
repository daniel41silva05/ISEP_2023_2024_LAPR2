package pprog.domain.users;

import java.io.Serializable;

/**
 * Represents a green spaces manager.
 */
public class GreenSpacesManager implements Serializable {

    private final String email;

    public GreenSpacesManager(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GreenSpacesManager)) {
            return false;
        }
        GreenSpacesManager gsm = (GreenSpacesManager) o;
        return email.equals(gsm.email);
    }

    public boolean hasEmail(String email) {
        return this.email.equals(email);
    }

    public String getEmail() {
        return email;
    }

    /**
     * Clone method.
     *
     * @return A clone of the current instance.
     */
    public GreenSpacesManager clone() {
        return new GreenSpacesManager(this.email);
    }

    /**
     * Returns a string representation of the fleet manager.
     * @return A string representation containing the name of the fleet manager.
     */
    @Override
    public String toString() {
        return String.format(email);
    }
}
