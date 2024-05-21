package pprog.controller;

import pprog.domain.GreenSpace;
import pprog.repository.Repositories;
import pprog.repository.VehicleRepository;

import java.util.Date;


public class RegisterGreenSpaceController {

    private GreenSpaceRepository GreenSpaceRepository;

    public RegisterGreenSpaceController() {
        getGreenSpaceRepository();
    }

    public RegisterGreenSpaceController(GreenSpaceRepository GreenSpaceRepository) {
        this.GreenSpaceRepository = GreenSpaceRepository;
    }

    private VehicleRepository getVehicleRepository() {
        if (GreenSpaceRepository == null) {
            Repositories repositories = Repositories.getInstance();
            GreenSpaceRepository = repositories.getVehicleRepository();
        }
        return GreenSpaceRepository;
    }

    public boolean registerGreenSpace(String name, String address, int type, double area) {
        try {
            getVehicleRepository().registerVehicle(name, address, type, area);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }
}
