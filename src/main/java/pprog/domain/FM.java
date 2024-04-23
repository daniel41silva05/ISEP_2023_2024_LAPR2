package pprog.domain;

import pprog.repository.Repositories;
import pprog.repository.VehicleRepository;

public class FM {

    private String name;

    public FM (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Fleet Manager: %s\n", name);
    }
}
