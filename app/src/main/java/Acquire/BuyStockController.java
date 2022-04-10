package Acquire;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.*;

import java.net.URL;
import java.util.ArrayList;
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
    private Label moneyAvailable;
    @FXML
    private Label costOfShares;
    @FXML
    private Label moneyAfter;
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

    private ArrayList<Spinner<Integer>> spinners = new ArrayList<>();
    private int totalShareCost;
    private int playerMoney; // playerMoney = Acquire.getTurn().getPlayer.getMoney() or something like that
    private int sharesToBuy = 0;

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
        spinners.add(continentalSpinner);
        spinners.add(sacksonSpinner);
        spinners.add(festivalSpinner);
        spinners.add(imperialSpinner);
        spinners.add(towerSpinner);
        spinners.add(americanSpinner);
        spinners.add(worldwideSpinner);

        for (Spinner<Integer> spinner : spinners) {
            spinner.valueProperty().addListener((observable, oldValue, newValue) -> {
                if (oldValue < newValue) {
                    sharesToBuy += 1;
                    if (sharesToBuy >= 3) {
                        for (Spinner<Integer> spinner1 : spinners) {
                            if (spinner1.getValue() == 0) {
                                spinner1.setDisable(true);
                            }
                        }
                    }
                } else {
                    sharesToBuy -= 1;
                    for (Spinner<Integer> spinner1 : spinners) {
                        spinner1.setDisable(false);
                    }
                }
                costOfShares.setText(computeTotalSharesCost());
            });
        }

        continentalCost.setText("Stock Cost: $500");
        continentalShares.setText("Shares Left: 25");
        moneyAvailable.setText("$6000");
        costOfShares.setText(computeTotalSharesCost());
        moneyAfter.setText("" + (playerMoney - totalShareCost));
    }


    public String computeTotalSharesCost() {
        totalShareCost = 0;
        String returnString = "";
        totalShareCost += continentalSpinner.getValue() + sacksonSpinner.getValue() + festivalSpinner.getValue() + imperialSpinner.getValue();
        totalShareCost += towerSpinner.getValue() + americanSpinner.getValue() + worldwideSpinner.getValue();
        return returnString + totalShareCost;
    }
}
