package Acquire;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Window;

import java.util.*;

public class GameOverController {
    @FXML private Label playerFourMoney;
    @FXML private Label playerFourTag;
    @FXML private Label playerOneMoney;
    @FXML private Label playerOneTag;
    @FXML private Label playerThreeMoney;
    @FXML private Label playerThreeTag;
    @FXML private Label playerTwoMoney;
    @FXML private Label playerTwoTag;
    @FXML private Label winnerTag;

    @FXML
    void exitGameClicked(ActionEvent event) {
        Node node = (Node) event.getSource();
        Window exitStage = node.getScene().getWindow();
        exitStage.hide();
    }

    public void setAcquire(Acquire acquire) {
        playerOneMoney.setText(Integer.toString(acquire.getPlayers().get(0).getMoney()));
        playerTwoMoney.setText(Integer.toString(acquire.getPlayers().get(1).getMoney()));
        playerThreeMoney.setText(Integer.toString(acquire.getPlayers().get(2).getMoney()));
        playerFourMoney.setText(Integer.toString(acquire.getPlayers().get(3).getMoney()));

        Player winner = acquire.getPlayers().get(0).compareTo(acquire.getPlayers().get(1));
        winner = winner.compareTo(acquire.getPlayers().get(2));
        winner = winner.compareTo(acquire.getPlayers().get(3));
        winnerTag.setText(winner.getName() + " WINS!");
    }
}
