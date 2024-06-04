package pprog.domain;

import java.io.Serializable;

/**
 * Represents a fleet manager.
 */
public class FleetManager implements Serializable {

    private final String email;

    public FleetManager(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HumanResourcesManager)) {
            return false;
        }
        FleetManager fm = (FleetManager) o;
        return email.equals(fm.email);
    }

    public String getEmail() {
        return email;
    }

    /**
     * Clone method.
     *
     * @return A clone of the current instance.
     */
    public FleetManager clone() {
        return new FleetManager(this.email);
    }

    /**
     * Returns a string representation of the fleet manager.
     * @return A string representation containing the name of the fleet manager.
     */
    @Override
    public String toString() {
        return String.format("Fleet Manager: %s\n", email);
    }
}
