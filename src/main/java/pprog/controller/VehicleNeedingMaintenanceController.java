package pprog.controller;

import pprog.repository.CheckUpRepository;
import pprog.repository.Repositories;
import pprog.repository.VehicleNeedingMaintenanceRepository;
import pprog.repository.VehicleRepository;

import java.util.List;

public class VehicleNeedingMaintenanceController {

    private VehicleNeedingMaintenanceRepository vehicleNeedingMaintenanceRepository;

    private CheckUpRepository checkUpRepository;

    private VehicleRepository vehicleRepository;

    public VehicleNeedingMaintenanceController() {
        getCheckUpRepository();
        getVehicleRepository();
        getVehicleNeedingMaintenanceRepository();
    }

    public VehicleNeedingMaintenanceController(VehicleNeedingMaintenanceRepository vehicleNeedingMaintenanceRepository, CheckUpRepository checkUpRepository, VehicleRepository vehicleRepository) {
        this.vehicleNeedingMaintenanceRepository = vehicleNeedingMaintenanceRepository;
        this.checkUpRepository = checkUpRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleNeedingMaintenanceRepository getVehicleNeedingMaintenanceRepository() {
        if (vehicleNeedingMaintenanceRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehicleNeedingMaintenanceRepository = repositories.getVehicleNeedingMaintenanceRepository();
        }
        return vehicleNeedingMaintenanceRepository;
    }

    private CheckUpRepository getCheckUpRepository() {
        if (checkUpRepository == null) {
            Repositories repositories = Repositories.getInstance();
            checkUpRepository = repositories.getCheckUpRepository();
        }
        return checkUpRepository;
    }

    private VehicleRepository getVehicleRepository () {
        if (vehicleRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehicleRepository = repositories.getVehicleRepository();
        }
        return vehicleRepository;
    }

    public List<String> getVehiclesNeedingMaintenanceList() {
        return getVehicleNeedingMaintenanceRepository().getVehiclesNeedingMaintenanceList(getVehicleRepository().getVehiclesList(), getCheckUpRepository().getCheckUpList());
    }

}
