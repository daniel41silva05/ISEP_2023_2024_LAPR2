package pprog.controller;

import pprog.domain.Date;
import pprog.repository.CheckUpRepository;
import pprog.domain.CheckUp;

public class RegisterCheckUpController {

    private CheckUpRepository checkUpRepository;

    public RegisterCheckUpController(CheckUpRepository checkUpRepository) {
        this.checkUpRepository = checkUpRepository;
    }

    public void registerCheckUp(Date date,String plate, double KMS) {
        // Validação dos dados, se necessário
        CheckUp checkUp = new CheckUp(date,plate,KMS);
        checkUpRepository.addCheckUp(checkUp);
    }
}
