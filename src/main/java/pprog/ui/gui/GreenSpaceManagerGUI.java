package pprog.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GreenSpaceManagerGUI implements Initializable {

    private final AuthenticationRepository authenticationRepository= Repositories.getInstance().getAuthenticationRepository();

    @FXML
    private Button btnRegisterGreenSpace;
    @FXML
    private Button btnAddEntryToDoList;
    @FXML
    private Button btnAddEntryAgenda;
    @FXML
    private Button btnAssignTeam;
    @FXML
    private Button btnPostponeEntry;
    @FXML
    private Button btnCancelEntry;
    @FXML
    private Button btnAssignVehicles;
    @FXML
    private Button btnListManagedGreenSpaces;
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

    public void registerGreenSpace(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/RegisterGreenSpace.fxml",true);
    }

    public void addEntryToDoList(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/AddEntryToDoList.fxml",true);
    }

    public void addEntryAgenda(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/AddEntryAgenda.fxml",true);
    }

    public void assignTeam(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/AssignTeam.fxml",true);
    }

    public void postponeEntry(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/PostponeEntry.fxml",true);
    }

    public void cancelEntry(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/CancelEntry.fxml",true);
    }

    public void assignVehicles(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/AssignVehicles.fxml",true);
    }

    public void listManagedGreenSpaces(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/ListGreenSpacesByGSM.fxml",true);
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

}
