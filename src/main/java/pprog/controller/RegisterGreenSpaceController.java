package pprog.controller;

import pprog.domain.greenspace.GreenSpace;
import pprog.domain.users.GreenSpacesManager;
import pprog.repository.AuthenticationRepository;
import pprog.repository.GreenSpaceRepository;
import pprog.repository.Repositories;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RegisterGreenSpaceController {

    private GreenSpaceRepository greenSpaceRepository;
    private AuthenticationRepository authenticationRepository;

    public RegisterGreenSpaceController() {
        getGreenSpaceRepository();
        getAuthenticationRepository();
    }

    public RegisterGreenSpaceController(GreenSpaceRepository greenSpaceRepository, AuthenticationRepository authenticationRepository) {
        this.greenSpaceRepository = greenSpaceRepository;
        this.authenticationRepository = authenticationRepository;
    }

    public GreenSpaceRepository getGreenSpaceRepository() {
        if (greenSpaceRepository == null) {
            Repositories repositories = Repositories.getInstance();
            greenSpaceRepository = repositories.getGreenSpaceRepository();
        }
        return greenSpaceRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public String registerGreenSpace(String name, String address, int type, double area) {
        try {
            getGreenSpaceRepository().registerGreenSpace(name, address, type, area, getGSMFromSession());
            return null;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    private GreenSpacesManager getGSMFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new GreenSpacesManager(email.getEmail());
    }



    public GreenSpace getGreenSpaceByName(String greenSpaceName) {
        return getGreenSpaceRepository().getGreenSpaceByName(greenSpaceName);
    }

    public List<GreenSpace> getGreenSpaceListByGSM() {
        List<GreenSpace> greenSpacesListByGSM = new ArrayList<>();

        GreenSpacesManager gsm = getGSMFromSession();
        for (GreenSpace gs: getGreenSpaceRepository().getGreenSpacesList()) {
            if (gs.getGreenSpacesManager().equals(gsm)) {
                greenSpacesListByGSM.add(gs);
            }
        }
        return greenSpacesListByGSM;
    }

}
