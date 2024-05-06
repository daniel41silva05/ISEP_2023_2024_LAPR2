package pprog.ui;

import pprog.ui.menu.MainMenuUI;

public class Main {

    public static void main(String[] args) {
        pprog.ui.Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();

        try {
            MainMenuUI menu = new MainMenuUI();
            menu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
