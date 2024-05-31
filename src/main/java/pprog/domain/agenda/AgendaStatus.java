package pprog.domain.agenda;

import java.io.Serializable;

public enum AgendaStatus implements Serializable {
    PLANNED,
    POSTPONED,
    CANCELED,
    DONE;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}
