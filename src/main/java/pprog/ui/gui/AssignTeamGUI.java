package pprog.ui.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pprog.controller.team.AssignTeamController;
import pprog.domain.Team;
import pprog.domain.agenda.Entry;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AssignTeamGUI implements Initializable {

    @FXML
    private TextField entryField;

    @FXML
    private TextField teamField;

    private final AssignTeamController controller;

    public AssignTeamGUI() {
        controller = new AssignTeamController();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void loadEntries() {
        List<Entry> entries = controller.getEntriesList();
        if (entries.isEmpty()) {
            showAlert("Entries list is empty!");
        } else {
            StringBuilder sb = new StringBuilder("Entries list:\n\n");
            int counter = 1;
            for (Entry entry : entries) {
                sb.append(counter).append(":\n").append(entry).append("\n");
                counter++;
            }
            showList(sb.toString());
        }
    }

    @FXML
    private void loadTeams() {
        List<Team> teams = controller.getTeamsList();
        if (teams.isEmpty()) {
            showAlert("Teams list is empty!");
        } else {
            StringBuilder sb = new StringBuilder("Teams list:\n\n");
            int counter = 1;
            for (Team team : teams) {
                sb.append(counter).append(":\n").append(team).append("\n");
                counter++;
            }
            showList(sb.toString());
        }
    }

    @FXML
    private void handleAssignTeam() {
        String taskText = entryField.getText().trim();
        String teamText = teamField.getText().trim();

        if (taskText.isEmpty() || teamText.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        int entryIndex;
        int teamIndex;
        try {
            entryIndex = Integer.parseInt(taskText);
            teamIndex = Integer.parseInt(teamText);
        } catch (NumberFormatException e) {
            showAlert("Please enter valid numbers for task and team.");
            return;
        }

        List<Entry> entries = controller.getEntriesList();
        List<Team> teams = controller.getTeamsList();

        if (entryIndex < 1 || entryIndex > entries.size()) {
            showAlert("Invalid entry number.");
            return;
        }


        if (teamIndex < 1 || teamIndex > teams.size()) {
            showAlert("Invalid team number.");
            return;
        }

        String result = controller.assignTeamToEntry(entryIndex, teamIndex);
        if (result == null) {
            showSuccess("Team assigned successfully!");
        } else {
            showAlert(result + "\n\nTeam not assigned!");
        }
    }

    @FXML
    private void handleReturnButtonAction() {
        changeScene((Stage) entryField.getScene().getWindow(), "/fxml/GreenSpacesManager.fxml");
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
        alert.setTitle("List");
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
