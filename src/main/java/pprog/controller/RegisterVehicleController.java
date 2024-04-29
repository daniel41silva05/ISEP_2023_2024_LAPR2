package pprog.controller;

import pprog.domain.Date;
import pprog.domain.Vehicle;
import pprog.domain.VehicleType;
import pprog.repository.Repositories;
import pprog.repository.VehicleRepository;

import java.util.Optional;

public class RegisterVehicleController {

    private VehicleRepository vehicleRepository;

    public RegisterVehicleController() {
        getVehicleRepository();
    }

    public RegisterVehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    private VehicleRepository getVehicleRepository() {
        if (vehicleRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehicleRepository = repositories.getVehicleRepository();
        }
        return getVehicleRepository();
    }

    public Optional<Vehicle> registerVehicle(String brand, String model, int tare, int grossWeight, int currentKm, Date registerDate, Date acquisitionDate, int maintenanceCheckUpFrequency, String plateNumber, VehicleType type) {

        Optional<Vehicle> newVehicle = Optional.empty();
        Vehicle vehicle = new Vehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitionDate, maintenanceCheckUpFrequency, plateNumber, type);
        newVehicle = Optional.of(vehicle);

        return newVehicle;
    }
}
