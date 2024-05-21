package pprog.ui;

import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;
import pprog.ui.menu.MainMenuUI;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File f = new File("src\\main\\resources\\config.properties.xml");
        Repositories.getInstance().loadSystemStateFromBinary(f);
        pprog.ui.Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();

        try {
            MainMenuUI menu = new MainMenuUI();
            menu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Repositories.getInstance().saveSystemStateToBinary(f);

    }
}
