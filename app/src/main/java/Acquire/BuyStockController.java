package Acquire;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BuyStockController implements Initializable {
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
    private ArrayList<Label> shareLabels = new ArrayList<>();
    private ArrayList<Label> costLabels = new ArrayList<>();
    private int totalShareCost;
    private int playerMoney; // playerMoney = Acquire.getTurn().getPlayer.getMoney() or something like that
    private int sharesToBuy = 0;
    private String stockCostMsg = "Share Cost: ";
    private String sharesLeftMsg = "Shares Left: ";

    @FXML
    void okayButtonClicked(MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        Window exitWindow = node.getScene().getWindow();

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Buy Stock Confirmation");
        a.setContentText("Are you sure you want to buy the chosen stock?");
        a.showAndWait().filter(r -> r == ButtonType.OK).ifPresent(r -> exitWindow.hide());
    }

    @FXML
    void cancelButtonClicked(MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        Window exitWindow = node.getScene().getWindow();
        exitWindow.hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addSpinners();
        addLabels();

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

        moneyAvailable.setText("$6000");
        costOfShares.setText(computeTotalSharesCost());
        moneyAfter.setText("" + (playerMoney - totalShareCost));
    }

    public void addSpinners() {
        spinners.add(continentalSpinner);
        spinners.add(sacksonSpinner);
        spinners.add(festivalSpinner);
        spinners.add(imperialSpinner);
        spinners.add(towerSpinner);
        spinners.add(americanSpinner);
        spinners.add(worldwideSpinner);
    }

    public void addLabels() {
        shareLabels.add(continentalShares);
        shareLabels.add(sacksonShares);
        shareLabels.add(festivalShares);
        shareLabels.add(imperialShares);
        shareLabels.add(towerShares);
        shareLabels.add(americanShares);
        shareLabels.add(worldwideShares);

        for (Label shareLabel : shareLabels) {
            shareLabel.setText(sharesLeftMsg);
        }

        costLabels.add(continentalCost);
        costLabels.add(sacksonCost);
        costLabels.add(festivalCost);
        costLabels.add(imperialCost);
        costLabels.add(towerCost);
        costLabels.add(americanCost);
        costLabels.add(worldwideCost);

        for (Label costLabel : costLabels) {
            costLabel.setText(stockCostMsg);
        }
    }

    public String computeTotalSharesCost() {
        totalShareCost = 0;
        String returnString = "";
        totalShareCost += continentalSpinner.getValue() + sacksonSpinner.getValue() + festivalSpinner.getValue() + imperialSpinner.getValue();
        totalShareCost += towerSpinner.getValue() + americanSpinner.getValue() + worldwideSpinner.getValue();
        return returnString + totalShareCost;
    }

}
