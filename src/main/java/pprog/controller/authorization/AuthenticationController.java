package pprog.controller.authorization;

import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.util.List;

public class AuthenticationController {

    public static final String ROLE_HRM = "Human Resources Manager";
    public static final String ROLE_VFM = "Vehicle and Equipment Fleet Manager";

    //private final ApplicationSession applicationSession;
    private final AuthenticationRepository authenticationRepository;

    public AuthenticationController() {
        this.authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
    }

    public boolean doLogin(String email, String pwd) {
        try {
            return authenticationRepository.doLogin(email, pwd);
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public List<UserRoleDTO> getUserRoles() {
        if (authenticationRepository.getCurrentUserSession().isLoggedIn()) {
            return authenticationRepository.getCurrentUserSession().getUserRoles();
        }
        return null;
    }

    public void doLogout() {
        authenticationRepository.doLogout();
    }
}
