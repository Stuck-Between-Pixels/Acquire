package Acquire;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class NewOrLoadGameController {
    // ---------- NewOrLoadGame.fxml control ----------
    @FXML
    public void NewGame(Event event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        AcquireClass.Start(stage);
    }

    @FXML
    public void LoadGame() {

    }
}
