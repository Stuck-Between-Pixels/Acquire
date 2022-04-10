package Acquire;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class SellStockController implements Initializable {

    @FXML
    private Label americanCost;

    @FXML
    private Label americanShares;

    @FXML
    private Spinner<Integer> americanSpinner;

    @FXML
    private Button cancelButton;

    @FXML
    private Label continentalCost;

    @FXML
    private Label continentalShares;

    @FXML
    private Spinner<Integer> continentalSpinner;

    @FXML
    private Label costOfShares;

    @FXML
    private Label festivalCost;

    @FXML
    private Label festivalShares;

    @FXML
    private Spinner<Integer> festivalSpinner;

    @FXML
    private Label imperialCost;

    @FXML
    private Label imperialShares;

    @FXML
    private Spinner<Integer> imperialSpinner;

    @FXML
    private Label moneyAfter;

    @FXML
    private Label moneyAvailable;

    @FXML
    private Button okButton;

    @FXML
    private Label sacksonCost;

    @FXML
    private Label sacksonShares;

    @FXML
    private Spinner<Integer> sacksonSpinner;

    @FXML
    private Label towerCost;

    @FXML
    private Label towerShares;

    @FXML
    private Spinner<Integer> towerSpinner;

    @FXML
    private Label worldwideCost;

    @FXML
    private Label worldwideShares;

    @FXML
    private Spinner<Integer> worldwideSpinner;

//    Player player;
//    Corporation[] corps;
//
//    public SellStockController(Player player, Corporation[] corps) {
//        this.player = player;
//        this.corps = corps;
//    }

    @FXML
    void cancelButtonClicked(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void okButtonClicked(ActionEvent event) {
        // sell the selected stocks
//        for (int i=0; i<americanSpinner.getValue(); i++) {
//            player.removeStockByCorp(corps[1]);
//        }
//        for (int i=0; i<continentalSpinner.getValue(); i++) {
//            player.removeStockByCorp(corps[2]);
//        }
//        for (int i=0; i<festivalSpinner.getValue(); i++) {
//            player.removeStockByCorp(corps[3]);
//        }
//        for (int i=0; i<imperialSpinner.getValue(); i++) {
//            player.removeStockByCorp(corps[4]);
//        }
//        for (int i=0; i<sacksonSpinner.getValue(); i++) {
//            player.removeStockByCorp(corps[5]);
//        }
//        for (int i=0; i<towerSpinner.getValue(); i++) {
//            player.removeStockByCorp(corps[6]);
//        }
//        for (int i=0; i<worldwideSpinner.getValue(); i++) {
//            player.removeStockByCorp(corps[7]);
//        }

        // close window
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // configure spinner
        SpinnerValueFactory<Integer> americanValFac = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,0);
        this.americanSpinner.setValueFactory(americanValFac);

        SpinnerValueFactory<Integer> continentalValFac = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,0);
        this.continentalSpinner.setValueFactory(continentalValFac);

        SpinnerValueFactory<Integer> festivalValFac = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,0);
        this.festivalSpinner.setValueFactory(festivalValFac);

        SpinnerValueFactory<Integer> imperialValFac = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,0);
        this.imperialSpinner.setValueFactory(imperialValFac);

        SpinnerValueFactory<Integer> sacksonValFac = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,0);
        this.sacksonSpinner.setValueFactory(sacksonValFac);

        SpinnerValueFactory<Integer> towerValFac = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,0);
        this.towerSpinner.setValueFactory(towerValFac);

        SpinnerValueFactory<Integer> worldWideValFac = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,0);
        this.worldwideSpinner.setValueFactory(worldWideValFac);
    }
}