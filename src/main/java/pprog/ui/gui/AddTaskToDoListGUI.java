package pprog.ui.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pprog.controller.AddTaskToDoListController;
import pprog.domain.greenspace.GreenSpace;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddTaskToDoListGUI implements Initializable {

    @FXML
    private TextField titleField;
    @FXML
    private TextField descriptionField;
    @FXML
    private ComboBox<String> degreeOfUrgencyComboBox;
    @FXML
    private TextField expectedDurationField;
    @FXML
    private ComboBox<String> taskTypeComboBox;
    @FXML
    private TextField greenSpaceField;

    private final AddTaskToDoListController controller;

    public AddTaskToDoListGUI() {
        controller = new AddTaskToDoListController();
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void handleSubmitButtonAction() {

        String title = titleField.getText().trim();
        String description = descriptionField.getText().trim();
        int degreeOfUrgencyIndex = degreeOfUrgencyComboBox.getSelectionModel().getSelectedIndex();
        String expectedDurationText = expectedDurationField.getText();
        int taskTypeIndex = taskTypeComboBox.getSelectionModel().getSelectedIndex();
        String greenSpace = greenSpaceField.getText();

        if (title.isEmpty() || description.isEmpty() || degreeOfUrgencyIndex == -1 || expectedDurationText.isEmpty() || taskTypeIndex == -1 || greenSpace.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        int degreeOfUrgency = degreeOfUrgencyIndex + 1;
        int taskType = taskTypeIndex + 1;

        int expectedDuration;
        try {
            expectedDuration = Integer.parseInt(expectedDurationText);
        } catch (NumberFormatException e) {
            showAlert("Invalid input. Please enter valid numbers.");
            return;
        }

        if (!isValidTitle(title) || !isValidDescription(description) || !isValidDegreeOfUrgency(degreeOfUrgency) || !isValidExpectedDuration(expectedDuration) || !isValidType(taskType) || !isValidGreenSpace(greenSpace)) {
            return;
        }

        String result = controller.addTaskToDoList(title, description, degreeOfUrgency, expectedDuration, taskType, greenSpace);
        if (result == null) {
            showSuccess("Task successfully added!\n\n" + controller.getTaskAdded());
            changeScene((Stage) titleField.getScene().getWindow(), "/fxml/AddTaskToDoList.fxml");
        } else {
            showAlert(result + "\n\nTask not added!");
        }
    }

    private boolean isValidTitle(String name) {
        if (!name.matches("[a-zA-Z0-9\\s]+")) {
            showAlert("Invalid title. Please enter a valid title.");
            return false;
        }
        return true;
    }

    private boolean isValidDescription(String description) {
        if (!description.matches("[a-zA-Z0-9\\s]+")) {
            showAlert("Invalid description. Please enter a valid description.");
            return false;
        }
        return true;
    }

    private boolean isValidDegreeOfUrgency(int degreeOfUrgency) {
        if (degreeOfUrgency < 1 || degreeOfUrgency > 3) {
            showAlert("Invalid input. Please choose a valid option (1, 2 or 3).");
            return false;
        }
        return true;
    }

    private boolean isValidExpectedDuration(double duration) {
        if (duration < 0) {
            showAlert("Invalid input. Please insert a valid duration (greater than 0).");
            return false;
        }
        return true;
    }

    private boolean isValidType(int type) {
        if (type < 1 || type > 2) {
            showAlert("Invalid input. Please choose a valid option (1 or 2).");
            return false;
        }
        return true;
    }

    private boolean isValidGreenSpace(String greenSpace) {
        if (!greenSpace.matches("[a-zA-Z0-9\\s]+")) {
            showAlert("Invalid name. Please enter a valid name.");
            return false;
        }
        return true;
    }

    @FXML
    private void handleReturnButtonAction() {
        changeScene((Stage) titleField.getScene().getWindow(), "/fxml/GreenSpacesManager.fxml");
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

    private void showList(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Green Spaces");
        alert.setHeaderText(null);

        TextArea textArea = new TextArea(message);
        textArea.setWrapText(true);
        textArea.setEditable(false);

        ScrollPane scrollPane = new ScrollPane(textArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setPrefHeight(400);
        scrollPane.setPrefWidth(600);
        scrollPane.setMaxHeight(600);

        alert.getDialogPane().setContent(scrollPane);
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

    @FXML
    private void handleConsultGreenSpacesButtonAction() {
        List<GreenSpace> greenSpaces = controller.getGreenSpacesList();
        if (greenSpaces.isEmpty()) {
            showAlert("No Green Spaces found!");
        } else {
            StringBuilder sb = new StringBuilder("List of green spaces:\n\n");
            int counter = 1;
            for (GreenSpace greenSpace : greenSpaces) {
                sb.append("Name:").append(greenSpace.getName()).append("\nManaged By: ").append(greenSpace.getGreenSpacesManager()).append("\n\n");
                counter++;
            }
            showList(sb.toString());
        }
    }


}



