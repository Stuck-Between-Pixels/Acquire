package Acquire;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MergerController {

    @FXML
    void buyStock(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(App.class.getResource("BuyStock.FXML"));

        Scene scene = new Scene(loader.load());
        stage.setResizable(true);
        stage.setTitle("Buy Stock");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void endTurn(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void sellStock(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(App.class.getResource("SellStock.FXML"));

        Scene scene = new Scene(loader.load());
        stage.setResizable(true);
        stage.setTitle("Sell Stock");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void tradeStock(ActionEvent event) {

    }

}
