package pprog.domain.agenda;

import java.io.Serializable;

public enum TaskStatus implements Serializable {
    PENDING,
    PROCESSED;

    public static TaskStatus fromInt(int value) {
        switch (value) {
            case 1:
                return PENDING;
            case 2:
                return PROCESSED;
        }
        return null;
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}
