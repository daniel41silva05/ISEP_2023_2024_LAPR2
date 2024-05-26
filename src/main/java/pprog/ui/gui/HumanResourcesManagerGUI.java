package pprog.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;
import pprog.ui.classesUI.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HumanResourcesManagerGUI implements Initializable {

    private final AuthenticationRepository authenticationRepository= Repositories.getInstance().getAuthenticationRepository();

    @FXML
    private Button btnRegisterSkill;
    @FXML
    private Button btnRegisterJob;
    @FXML
    private Button btnRegisterCollaborator;
    @FXML
    private Button btnAssignSkill;
    @FXML
    private Button btnGenerateTeam;
    @FXML
    private Button btnLogOut;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void logOutAction(ActionEvent actionEvent) {
        authenticationRepository.doLogout();
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/MainMenuScene.fxml",true);
    }

    public void changeScene(Stage stage, String resourceName,Boolean rezizeble){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceName));
            Parent root = loader.load();

            stage.setScene(new Scene(root));
            stage.setResizable(rezizeble);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void registerSkill(ActionEvent actionEvent) {
        startingAlert();
        RegisterSkillUI u = new RegisterSkillUI();
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        stage.setIconified(true);
        u.run();
        stage.setIconified(false);
        completedAlert();

    }

    public void registerJob(ActionEvent actionEvent) {
        startingAlert();
        RegisterJobUI u = new RegisterJobUI();
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        stage.setIconified(true);
        u.run();
        stage.setIconified(false);
        completedAlert();
    }

    public void registerCollaborator(ActionEvent actionEvent) {
        startingAlert();
        RegisterCollaboratorUI u = new RegisterCollaboratorUI();
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        stage.setIconified(true);
        u.run();
        stage.setIconified(false);
        completedAlert();
    }

    public void assignSkills(ActionEvent actionEvent) {
        startingAlert();
        AssignSkillUI u = new AssignSkillUI();
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        stage.setIconified(true);
        u.run();
        stage.setIconified(false);
        completedAlert();
    }

    public void generateTeam(ActionEvent actionEvent) {
        startingAlert();
        GenerateTeamUI u = new GenerateTeamUI();
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        stage.setIconified(true);
        u.run();
        stage.setIconified(false);
        completedAlert();
    }

    public void completedAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operation Sucess");
        alert.setHeaderText(null);
        alert.setContentText("Console operation terminated");
        alert.showAndWait();

    }
    public void startingAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Console Operation");
        alert.setHeaderText(null);
        alert.setContentText("Console operation starting");
        alert.showAndWait();

    }

}
