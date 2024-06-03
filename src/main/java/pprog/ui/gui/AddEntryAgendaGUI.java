package pprog.ui.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pprog.controller.entry.AddEntryAgendaController;
import pprog.domain.todolist.Task;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AddEntryAgendaGUI implements Initializable {

    @FXML
    private TextField dateField;
    @FXML
    private TextField taskField;

    private final AddEntryAgendaController controller;

    public AddEntryAgendaGUI() {
        controller = new AddEntryAgendaController();
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void handleSubmitButtonAction() {

        String dateText = dateField.getText().trim();
        String taskText = taskField.getText();

        if (dateText.isEmpty() || taskText.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        Date date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            date = dateFormat.parse(dateText);
        } catch (ParseException e) {
            showAlert("Invalid date format. Please use dd/MM/yyyy format.");
            return;
        }

        int taskIndex;
        try {
            taskIndex = Integer.parseInt(taskText);
        } catch (NumberFormatException e) {
            showAlert("Invalid input. Please enter valid numbers.");
            return;
        }

        if (!isValidTask(taskIndex)) {
            return;
        }

        String result = controller.addEntryAgenda(date, taskIndex);
        if (result == null) {
            showSuccess("Entry successfully added!\n\n" + controller.getEntryAdded());
            changeScene((Stage) dateField.getScene().getWindow(), "/fxml/AddEntryAgenda.fxml");
        } else {
            showAlert(result + "\n\nEntry not added!");
        }
    }

    private boolean isValidTask(int index) {
        if (index < 1 || index > controller.getTasksList().size()) {
            showAlert("Invalid input. Please choose a valid option.");
            return false;
        }
        return true;
    }

    @FXML
    private void handleConsultGreenSpacesButtonAction() {
        List<Task> tasks = controller.getTasksList();
        if (tasks.isEmpty()) {
            showAlert("To-Do List is empty!");
        } else {
            StringBuilder sb = new StringBuilder("To-Do List:\n\n");
            int counter = 1;
            for (Task task : tasks) {
                sb.append(counter).append(":\n").append(task).append("\n");
                counter++;
            }
            showList(sb.toString());
        }
    }

    @FXML
    private void handleReturnButtonAction() {
        changeScene((Stage) dateField.getScene().getWindow(), "/fxml/GreenSpacesManager.fxml");
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
        alert.setTitle("To-Do List");
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

}
