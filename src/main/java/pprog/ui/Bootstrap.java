package pprog.ui;

import pprog.controller.authorization.AuthenticationController;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;

public class Bootstrap implements Runnable {
    public void run() {
        addUsers();
    }

    private void addUsers() {
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_HRM, AuthenticationController.ROLE_HRM);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_VFM, AuthenticationController.ROLE_VFM);

        authenticationRepository.addUserWithRole("Human Resources Manager", "hrm@this.app", "hrm",
                AuthenticationController.ROLE_HRM);

        authenticationRepository.addUserWithRole("Vehicle and Equipment Fleet Manager", "vfm@this.app", "vfm",
                AuthenticationController.ROLE_VFM);
    }
}
