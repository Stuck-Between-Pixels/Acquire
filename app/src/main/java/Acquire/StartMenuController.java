package Acquire;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class StartMenuController {
    // ----------- StartMenu.fxml control -----------
    @FXML
    public static Button StartGameButton;

    @FXML
    public void StartGame() throws IOException {
        NewOrLoadGameController.NewGame();
    }

    @FXML
    public void ExitButton(MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        Window exitStage = node.getScene().getWindow();
        exitStage.hide();
    }
}
