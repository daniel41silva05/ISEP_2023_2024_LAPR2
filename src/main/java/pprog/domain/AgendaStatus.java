package pprog.domain;

import java.io.Serializable;

public enum AgendaStatus implements Serializable {
    PLANNED,
    POSTPONED,
    CANCELED,
    DONE;
}
