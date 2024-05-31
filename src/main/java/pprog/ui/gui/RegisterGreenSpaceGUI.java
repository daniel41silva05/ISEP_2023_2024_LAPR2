package pprog.ui.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pprog.controller.RegisterGreenSpaceController;
import pprog.domain.greenspace.GreenSpace;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterGreenSpaceGUI implements Initializable {

    @FXML
    private TextField nameField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField zipCodeField;

    @FXML
    private TextField cityField;

    @FXML
    private ComboBox<String> typeField;

    @FXML
    private TextField areaField;

    private final RegisterGreenSpaceController controller;

    public RegisterGreenSpaceGUI() {
        controller = new RegisterGreenSpaceController();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void handleSubmitButtonAction() {

        String name = nameField.getText().trim();
        String street = streetField.getText().trim();
        String zipCode = zipCodeField.getText().trim();
        String city = cityField.getText().trim();
        String areaText = areaField.getText().trim();
        int typeIndex = typeField.getSelectionModel().getSelectedIndex();

        if (name.isEmpty() || street.isEmpty() || zipCode.isEmpty() || city.isEmpty() || areaText.isEmpty() || typeIndex == -1) {
            showAlert("Please fill in all fields.");
            return;
        }

        int type = typeIndex + 1;
        double area;

        try {
            area = Double.parseDouble(areaText);
        } catch (NumberFormatException e) {
            showAlert("Invalid input. Please enter valid numbers for area.");
            return;
        }

        if (!isValidName(name) || !isValidStreet(street) || !isValidZipcode(zipCode) || !isValidCity(city) || !isValidType(type) || !isValidArea(area)) {
            return;
        }

        String[] address = new String[3];
        address[0] = street;
        address[1] = zipCode;
        address[2] = city;

        String result = controller.registerGreenSpace(name, address, type, area);
        if (result == null) {
            List<GreenSpace> greenSpaces = controller.getGreenSpaceRepository().getGreenSpacesList();
            GreenSpace lastGreenSpace = greenSpaces.get(greenSpaces.size() - 1);
            showSuccess("Green Space successfully registered!\n\n" + lastGreenSpace);
            changeScene((Stage) nameField.getScene().getWindow(), "/fxml/GreenSpacesManager.fxml");
        } else {
            showAlert(result + "\n\nGreen Space not registered!");
        }
    }

    @FXML
    private void handleReturnButtonAction() {
        changeScene((Stage) nameField.getScene().getWindow(), "/fxml/GreenSpacesManager.fxml");
    }

    private boolean isValidName(String name) {
        if (!name.matches("[a-zA-Z0-9\\s]+")) {
            showAlert("Invalid name. Please enter a valid name.");
            return false;
        }
        return true;
    }

    private boolean isValidStreet(String street) {
        if (!street.matches("[a-zA-Z0-9\\s]+")) {
            showAlert("Invalid street. Please enter a valid street.");
            return false;
        }
        return true;
    }

    private boolean isValidZipcode(String zipcode) {
        if (!zipcode.matches("\\d{4}-\\d{3}")) {
            showAlert("Invalid zipcode format. Please enter a valid zipcode (format: xxxx-xxx).");
            return false;
        }
        return true;
    }

    private boolean isValidCity(String city) {
        if (!city.matches("[a-zA-Z0-9\\s]+")) {
            showAlert("Invalid city. Please enter a valid city.");
            return false;
        }
        return true;
    }

    private boolean isValidType(int type) {
        if (type < 1 || type > 3) {
            showAlert("Invalid input. Please choose a valid option (1, 2, or 3) for type.");
            return false;
        }
        return true;
    }

    private boolean isValidArea(double area) {
        if (area < 0) {
            showAlert("Invalid area. Please introduce a positive area.");
            return false;
        }
        return true;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void changeScene(Stage stage, String resourceName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceName));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.setResizable(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
