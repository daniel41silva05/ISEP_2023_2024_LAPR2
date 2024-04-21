package pprog.domain;

import pprog.repository.Repositories;
import pprog.repository.VehicleRepository;

public class FM {

    private String name;
    private VehicleRepository vehicleRepository;

    public FM (String name) {
        this.name = name;
        Repositories repositories = Repositories.getInstance();
        vehicleRepository = repositories.getVehicleRepository();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void registerVehicle (Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public String toString() {
        return String.format("Fleet Manager: %s\n", name);
    }
}
