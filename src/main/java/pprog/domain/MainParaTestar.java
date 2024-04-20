package pprog.domain;

import pprog.repository.CollaboratorRepository;
import pprog.repository.JobRepository;
import java.util.List;

public class MainParaTestar {
    public static void main(String[] args) {

        CollaboratorRepository collaboratorRepository = new CollaboratorRepository();
        JobRepository jobRepository = new JobRepository();

        HRM hrm = new HRM("Daniel", collaboratorRepository, jobRepository);

        Job job = new Job("Desenvolvedor");
        Collaborator collaborator = new Collaborator("João", "hh", "aa", "ola", 77, "ada", "asd", 56, job);

        hrm.registerCollaborator(collaborator, job);

        List<Collaborator> collaborators = collaboratorRepository.getAllCollaborators();

        for (Collaborator c : collaborators) {
            System.out.println(c);
        }

    }
}
