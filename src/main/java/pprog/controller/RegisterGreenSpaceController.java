package pprog.controller;

import pprog.repository.GreenSpaceRepository;
import pprog.repository.Repositories;


public class RegisterGreenSpaceController {

    private GreenSpaceRepository greenSpaceRepository;

    public RegisterGreenSpaceController() {
        getGreenSpaceRepository();
    }

    public RegisterGreenSpaceController(GreenSpaceRepository greenSpaceRepository) {
        this.greenSpaceRepository = greenSpaceRepository;
    }

    private GreenSpaceRepository getGreenSpaceRepository() {
        if (greenSpaceRepository == null) {
            Repositories repositories = Repositories.getInstance();
            greenSpaceRepository = repositories.getGreenSpaceRepository();
        }
        return greenSpaceRepository;
    }

    public boolean registerGreenSpace(String name, String address, int type, double area) {
        try {
            getGreenSpaceRepository().registerGreenSpace(name, address, type, area);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }
}
