package pprog.ui.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pprog.controller.entry.ConsultTasksController;
import pprog.domain.agenda.Entry;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ConsultAssignedTaskGUI implements Initializable {

    @FXML
    TextField startDateField;

    @FXML
    TextField endDateField;

    @FXML
    Button submitBtn;

    @FXML
    Button returnBtn;

    ConsultTasksController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public ConsultAssignedTaskGUI() {
        controller = new ConsultTasksController();
    }

    @FXML
    private StringBuilder loadEntries(List<Entry> entries) {
            StringBuilder sb = new StringBuilder("Entries list:\n\n");
            int counter = 1;
            for (Entry entry : entries) {
                sb.append(counter).append(":\n").append(entry).append("\n\n");
                counter++;
            }
            sb.toString();
        return sb;
    }

    @FXML
    private void handleSubmit() {
        String startDateText = startDateField.getText().trim();
        String endDateText = endDateField.getText().trim();

        if (startDateText.isEmpty() || endDateText.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        Date startDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            startDate = dateFormat.parse(startDateText);
        } catch (ParseException e) {
            showAlert("Invalid date format. Please use dd/MM/yyyy format.");
            return;
        }

        Date endDate;
        dateFormat.setLenient(false);
        try {
            endDate = dateFormat.parse(endDateText);
        } catch (ParseException e) {
            showAlert("Invalid date format. Please use dd/MM/yyyy format.");
            return;
        }

        List<Entry> result = controller.getTasksForCollaboratorBetweenDates(startDate, endDate);
        if (result != null) {
            showSuccess("\n" + loadEntries(result));
        } else {
            showAlert("No tasks were assigned to you during this period.");
        }
    }

    @FXML
    private void handleReturnButtonAction() {
        changeScene((Stage) startDateField.getScene().getWindow(), "/fxml/Collaborator.fxml");
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
