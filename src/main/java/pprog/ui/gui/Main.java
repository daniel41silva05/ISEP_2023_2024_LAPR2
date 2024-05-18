package pprog.ui.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando o rótulo
        Label rotulo = new Label("Olá, mundo!");

        // Criando o layout e adicionando o rótulo
        StackPane root = new StackPane();
        root.getChildren().add(rotulo);

        // Criando a cena
        Scene scene = new Scene(root, 400, 300);

        // Configurando o palco (janela)
        primaryStage.setTitle("Minha Interface Gráfica");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
