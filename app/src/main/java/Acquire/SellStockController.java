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
import java.util.ResourceBundle;

public class SellStockController {
    @FXML private Button cancelButton;
    @FXML private Label corpLabel;
    @FXML private Label costOfSharesLabel;
    @FXML private Label newBalanceLabel;
    @FXML private Button okButton;
    @FXML private Label oldBalanceLabel;
    @FXML private Label stockCostLabel;
    @FXML private Spinner<Integer> stockSpinner;
    @FXML private Label stocksHeldLabel;

    private Player cur;
    private Corporation corp;

    @FXML
    void cancelButtonClicked(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void okButtonClicked(ActionEvent event) {
        //sell the selected stocks
        for (int i=0; i<stockSpinner.getValue(); i++) {
            cur.removeStockByCorp(corp);
        }

        // close window
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    public void setup(Acquire acquire, Corporation sellable) {
        cur = acquire.getBoard().getCurrentTurn();
        this.corp = sellable;

        // configure spinner
        SpinnerValueFactory<Integer> stockValFac = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,
                cur.getNumStockFromCorp(sellable),0);
        stockValFac.valueProperty().addListener((obs, oldValue, newValue) ->
                {
                costOfSharesLabel.setText(Integer.toString(newValue * 800));
                newBalanceLabel.setText(Integer.toString(cur.getMoney() + (newValue * 800)));
                });  // NEED TO FIX
        this.stockSpinner.setValueFactory(stockValFac);

        //configure labels
        oldBalanceLabel.setText(Integer.toString(cur.getMoney()));
        newBalanceLabel.setText("0");
        costOfSharesLabel.setText("0");

        corpLabel.setText(sellable.getName());
        stocksHeldLabel.setText(Integer.toString(cur.getNumStockFromCorp(sellable)));
        stockCostLabel.setText("NEED TO FIX");
    }
}