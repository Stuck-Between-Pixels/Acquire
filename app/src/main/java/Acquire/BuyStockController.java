package Acquire;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.*;

import java.net.URL;
import java.util.ResourceBundle;

public class BuyStockController implements Initializable {
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label continentalCost;
    @FXML
    private Label continentalShares;
    @FXML
    private Label sacksonCost;
    @FXML
    private Label sacksonShares;
    @FXML
    private Label festivalCost;
    @FXML
    private Label festivalShares;
    @FXML
    private Label imperialCost;
    @FXML
    private Label imperialShares;
    @FXML
    private Label towerCost;
    @FXML
    private Label towerShares;
    @FXML
    private Label americanCost;
    @FXML
    private Label americanShares;
    @FXML
    private Label worldwideCost;
    @FXML
    private Label worldwideShares;
    @FXML
    private Spinner<Integer> continentalSpinner;
    @FXML
    private Spinner<Integer> sacksonSpinner;
    @FXML
    private Spinner<Integer> festivalSpinner;
    @FXML
    private Spinner<Integer> imperialSpinner;
    @FXML
    private Spinner<Integer> towerSpinner;
    @FXML
    private Spinner<Integer> americanSpinner;
    @FXML
    private Spinner<Integer> worldwideSpinner;
    @FXML
    private Label moneyAvailable;
    @FXML
    private Label costOfShares;
    @FXML
    private Label moneyAfter;

    @FXML
    void okButtonClicked() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    void cancelButtonClicked() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
