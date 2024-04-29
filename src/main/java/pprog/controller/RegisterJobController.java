package pprog.controller;

import pprog.domain.Job;
import pprog.repository.JobRepository;
import pprog.repository.Repositories;

public class RegisterJobController {

    private JobRepository jobRepository;

    // Método para registrar um novo cargo
    public void registerJob(String name, String description) {
        // Obter instância do repositório de cargos
        jobRepository = Repositories.getInstance().getJobRepository();

        // Criar um novo objeto de cargo
        Job job = new Job(name, description);

        // Adicionar o cargo ao repositório
        jobRepository.addJob(job);
    }
}