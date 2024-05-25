package pprog.ui.gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import pprog.controller.authorization.AuthenticationController;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.*;

public class AuthenticationGUI implements Initializable {
    @FXML
    private CheckBox checkButton;
    @FXML
    private TextField txtShowPwd;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPwd;
    @FXML
    private Button btnReturn;
    @FXML
    private Button btnLogIn;

    private int maxAttemps = 2;
    private final AuthenticationController controller = new AuthenticationController();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void doLoginActionButton(ActionEvent actionEvent) throws IOException {
        if (maxAttemps >0){

            boolean success = doLogin();
            if (!success){
                maxAttemps--;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Credentials");
                alert.setHeaderText("Invalid Email and/or Password");
                int temp = maxAttemps;
                alert.setContentText("You have "+(temp + 1)+" attempts remainig");
                alert.showAndWait();
                txtPwd.clear();
            }else {
                maxAttemps = 3;
                List<UserRoleDTO> roles = this.controller.getUserRoles();
                if ((roles == null) || (roles.isEmpty())) {
                    System.out.println("No role assigned to user.");
                } else {
                    UserRoleDTO role = roles.get(0);
                    if (!Objects.isNull(role)) {
                        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
                        switch (role.getId()){
                            case AuthenticationController.ROLE_HRM:
                                changeScene(stage,"/fxml/ClientUIFX.fxml",false);
                                break;
                            case AuthenticationController.ROLE_VFM:
                                changeScene(stage,"/fxml/SystemAdimUIFX.fxml",false);
                                break;
                            case AuthenticationController.ROLE_GSM:
                                changeScene(stage,"/fxml/AgentUIFx.fxml",false);
                                break;
                            case  AuthenticationController.ROLE_COLLABORATOR:
                                changeScene(stage,"/fxml/NetworkManagerUIFX.fxml",false);
                                break;
                        }
                    } else {
                        System.out.println("No role selected.");
                    }
                }
            }

        }else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Max Attemps reached");
            alert.setHeaderText("Maximum number of attempts reached");
            alert.setContentText("You will be redirected to the main menu");
            alert.showAndWait();
            closeLoginStage(actionEvent);

        }
        //this.logout();
    }
    public void doLoginActionKey(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (maxAttemps > 0) {

                boolean success = doLogin();
                if (!success) {
                    maxAttemps--;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Credentials");
                    alert.setHeaderText("Invalid Email and/or Password");
                    int temp = maxAttemps;
                    alert.setContentText("You have "+(temp + 1)+" attempts remainig");
                    alert.showAndWait();
                    txtPwd.clear();
                } else {
                    maxAttemps = 3;
                    List<UserRoleDTO> roles = this.controller.getUserRoles();
                    if ((roles == null) || (roles.isEmpty())) {
                        System.out.println("No role assigned to user.");
                    } else {
                        UserRoleDTO role = roles.get(0);
                        if (!Objects.isNull(role)) {
                            Stage stage = (Stage) ((Node) keyEvent.getTarget()).getScene().getWindow();

                            switch (role.getId()) {
                                case AuthenticationController.ROLE_HRM:
                                    changeScene(stage,"/fxml/ClientUIFX.fxml",false);
                                    break;
                                case AuthenticationController.ROLE_VFM:
                                    changeScene(stage,"/fxml/SystemAdimUIFX.fxml",false);
                                    break;
                                case AuthenticationController.ROLE_GSM:
                                    changeScene(stage,"/fxml/AgentUIFx.fxml",false);
                                    break;
                                case  AuthenticationController.ROLE_COLLABORATOR:
                                    changeScene(stage,"/fxml/NetworkManagerUIFX.fxml",false);
                                    break;
                            }

                        } else {
                            System.out.println("No role selected.");
                        }
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Max Attemps reached");
                alert.setHeaderText("Maximum number of attempts reached");
                alert.setContentText("You will be redirected to the main menu");
                alert.showAndWait();
                closeLoginStage(keyEvent);
            }

        }
    }

    private void closeLoginStage(Event event) {
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        changeScene(stage,"/fxml/MainMenuScene.fxml",true);
    }

    private boolean doLogin() {

        boolean success = false;
        String id = txtEmail.getText();
        String pwd = txtPwd.getText();

        try {
            success = controller.doLogin(id, pwd);

        }catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Format");
            alert.setHeaderText("Invalid Format Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }

        return success;
    }

//    private void logout() {
//        controller.doLogout();
//    }

    public void doReturnToMenuAction(ActionEvent actionEvent) {
        closeLoginStage(actionEvent);
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


    public void darEnterLoginAction(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            try {
                doLoginActionKey(keyEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void unHidePwdField(ActionEvent actionEvent) {
        if (checkButton.isSelected()){
            txtShowPwd.setVisible(true);
            txtPwd.setManaged(false);
            txtShowPwd.textProperty().bindBidirectional(txtPwd.textProperty());
        }else {
            txtShowPwd.setVisible(false);
            txtPwd.setManaged(true);
            txtShowPwd.textProperty().bindBidirectional(txtPwd.textProperty());
        }

    }
}
