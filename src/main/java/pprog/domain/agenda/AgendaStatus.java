package pprog.domain.agenda;

import java.io.Serializable;

public enum AgendaStatus implements Serializable {
    PLANNED,
    POSTPONED,
    CANCELED,
    DONE;
}
