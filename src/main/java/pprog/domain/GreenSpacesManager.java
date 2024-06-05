package pprog.domain;

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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GreenSpacesManager gsm = (GreenSpacesManager) o;
        return email.equals(gsm.email);
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format(email);
    }
}
