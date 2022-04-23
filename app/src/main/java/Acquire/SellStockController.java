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
    private Corporation[] corps;
    private int ndx;

    @FXML
    void cancelButtonClicked(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void okButtonClicked(ActionEvent event) {
        //sell the selected stocks
        for (int i=0; i<stockSpinner.getValue(); i++) {
            cur.removeStockByCorp(corps[ndx]);
        }

        if ((ndx + 1) == corps.length) {
            // close window
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.close();
        }
        else {
            ndx++;
            nextCorp();
        }
    }

    /**
     * Sets up the sell stock screen
     * @param acquire object for the game
     * @param sellables array of corporations that have sellable stock
     */
    public void setup(Acquire acquire, Corporation[] sellables) {
        if (sellables.length == 0) return;
        cur = acquire.getTurn();
        this.corps = sellables;
        this.ndx = 0;
        nextCorp();
    }

    private void nextCorp() {
        // configure spinner
        SpinnerValueFactory<Integer> stockValFac = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,
                cur.getNumStockFromCorp(corps[ndx]),0);
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

        corpLabel.setText(corps[ndx].getName());
        stocksHeldLabel.setText(Integer.toString(cur.getNumStockFromCorp(corps[ndx])));
        stockCostLabel.setText("NEED TO FIX");

        if ((ndx + 1) == corps.length) okButton.setText("OK");
        else okButton.setText("NEXT");
    }
}