package pprog.domain.gs;

import java.io.Serializable;

public enum GreenSpaceType implements Serializable {
    GARDEN,
    MEDIUM_SIZED_PARK,
    LARGE_SIZED_PARK;

    public static GreenSpaceType fromInt(int value) {
        switch (value) {
            case 1:
                return GARDEN;
            case 2:
                return MEDIUM_SIZED_PARK;
            case 3:
                return LARGE_SIZED_PARK;
        }
        return null;
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}
