package pprog.ui.gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pprog.controller.ListGreenSpacesByGSMController;
import pprog.domain.GreenSpace;

import java.io.IOException;
import java.util.List;

public class ListGreenSpacesByGSMGUI {

    @FXML
    public Button loadGreenSpacesBtn;
    @FXML
    public Button returnBtn;
    @FXML
    private TableView<GreenSpace> greenSpacesTable;
    @FXML
    private TableColumn<GreenSpace, String> nameColumn;
    @FXML
    private TableColumn<GreenSpace, String> locationColumn;
    @FXML
    private TableColumn<GreenSpace, Double> areaColumn;

    private ListGreenSpacesByGSMController controller;

    public ListGreenSpacesByGSMGUI() {
        controller = new ListGreenSpacesByGSMController();
    }

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(cellData -> {
            GreenSpace gs = cellData.getValue();
            return new SimpleStringProperty(gs.getName() + "/" + gs.getType());
        });
        locationColumn.setCellValueFactory(cellData -> {
            GreenSpace gs = cellData.getValue();
            return new SimpleStringProperty(gs.getAddress().getStreet() + "/" + gs.getAddress().getZipcode() + "/" + gs.getAddress().getCity());
        });
        areaColumn.setCellValueFactory(new PropertyValueFactory<>("area"));
    }

    @FXML
    private void loadGreenSpaces() {
        List<GreenSpace> sortedGreenSpaces = controller.sortListByAlgorithm();

        if (!sortedGreenSpaces.isEmpty()) {
            greenSpacesTable.getItems().setAll(sortedGreenSpaces);
        } else {
            greenSpacesTable.getItems().clear();
            showAlert("No green spaces managed by the current GSM.");
        }
    }

    private void closeLoginStage(Event event) {
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        changeScene(stage, "/fxml/GreenSpacesManager.fxml", true);
    }

    public void doReturnToMenuAction(ActionEvent actionEvent) {
        closeLoginStage(actionEvent);
    }

    public void changeScene(Stage stage, String resourceName, Boolean rezizeble) {

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

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
