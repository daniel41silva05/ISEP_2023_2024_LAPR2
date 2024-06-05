package pprog.domain;

import java.io.Serializable;

/**
 * Represents a human resources manager.
 */
public class HumanResourcesManager implements Serializable {

    private final String email;

    public HumanResourcesManager(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HumanResourcesManager hrm = (HumanResourcesManager) o;
        return email.equals(hrm.email);
    }

    public String getEmail() {
        return email;
    }

    /**
     * Clone method.
     *
     * @return A clone of the current instance.
     */
    public HumanResourcesManager clone() {
        return new HumanResourcesManager(this.email);
    }

    /**
     * Returns a string representation of the human resources manager.
     * @return A string representation containing the name of the human resources manager.
     */
    @Override
    public String toString() {
        return String.format("Human Resources Manager: %s\n", email);
    }
}
