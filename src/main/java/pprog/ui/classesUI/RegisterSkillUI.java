package pprog.ui.classesUI;

import pprog.controller.RegisterSkillController;

import java.util.Scanner;

public class RegisterSkillUI implements Runnable {
    private RegisterSkillController controller;

    private String name;

    public RegisterSkillUI() {
        controller = new RegisterSkillController();
    }

    private RegisterSkillController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Register a Skill ------------------------");

        requestData();
        submitData();

    }

    private void submitData() {
        boolean sucess = controller.registerSkill(name);
        if (sucess) {
            System.out.println("\nSkill successfully registed!");
        } else {
            System.out.println("\nSkill not registed!");
        }

    }

    private void requestData() {
        name = requestName();
    }

    private String requestName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Name: ");
        return input.nextLine();
    }

}
