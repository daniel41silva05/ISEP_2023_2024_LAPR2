package pprog.ui;

import java.util.ArrayList;
import java.util.List;

import pprog.controller.RegisterJobController;
import pprog.domain.Job;

public class RegisterJobUI {
    private RegisterJobController controller;

    // Método para criar um novo cargo
    public void create() {
        // Criar instância do controlador
        controller = new RegisterJobController();

        // Solicitar dados do usuário
        String name = ""; // Obter nome do cargo do usuário
        String description = ""; // Obter descrição do cargo do usuário

        // Chamar método do controlador para registrar o cargo
        controller.registerJob(name, description);

        // Exibir mensagem de sucesso para o usuário
        System.out.println("Job registered successfully!");
    }
}
