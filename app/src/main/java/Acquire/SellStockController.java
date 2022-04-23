package Acquire;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
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

    private void loadMerge(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("Merge.FXML"));

        Scene scene = new Scene(loader.load());
        stage.setResizable(true);
        stage.setTitle("Merge Stock");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cancelButtonClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();

        loadMerge(stage);
    }

    @FXML
    void okButtonClicked(ActionEvent event) throws IOException {
        //sell the selected stocks
        for (int i=0; i<stockSpinner.getValue(); i++) {
            cur.removeStockByCorp(corps[ndx]);
        }

        if ((ndx + 1) == corps.length) {
            // close window
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.close();

            loadMerge(stage);
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