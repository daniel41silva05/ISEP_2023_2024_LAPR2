package pprog.domain.todolist;

import java.io.Serializable;

public enum TaskType implements Serializable {
    REGULAR,
    OCCASIONAL;

    public static TaskType fromInt(int value) {
        switch (value) {
            case 1:
                return REGULAR;
            case 2:
                return OCCASIONAL;
        }
        return null;
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}
