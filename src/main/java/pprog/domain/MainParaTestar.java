package pprog.domain;

import pprog.repository.CollaboratorRepository;
import pprog.repository.JobRepository;
import java.util.List;

public class MainParaTestar {
    public static void main(String[] args) {

        // TESTAR US3:

        CollaboratorRepository collaboratorRepository = new CollaboratorRepository();
        JobRepository jobRepository = new JobRepository();

        HRM hrm = new HRM("Daniel");

        Job job = new Job("Desenvolvedor");
        Collaborator collaborator = new Collaborator("João", "hh", "aa", "ola", 77, "ada", Collaborator.IdDocType.citizenCard, 56, job);

        List<Collaborator> collaborators = collaboratorRepository.getAllCollaborators();

        for (Collaborator c : collaborators) {
            System.out.println(c);
        }

        // TESTAR - US6:


    }
}
