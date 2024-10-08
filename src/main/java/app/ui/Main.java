package app.ui;

import app.repository.Repositories;
import app.ui.console.menu.MainMenuUI;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File f = new File("src\\main\\resources\\config.properties.xml");
        Repositories.getInstance().loadSystemStateFromBinary(f);
        app.ui.Bootstrap bootstrap = new Bootstrap();
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
