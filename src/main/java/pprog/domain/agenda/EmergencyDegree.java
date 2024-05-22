package pprog.domain.agenda;

import java.io.Serializable;

public enum EmergencyDegree implements Serializable {
    HIGH,
    MEDIUM,
    LOW;

    public static EmergencyDegree fromInt(int value) {
        switch (value) {
            case 1:
                return HIGH;
            case 2:
                return MEDIUM;
            case 3:
                return LOW;
        }
        return null;
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}
