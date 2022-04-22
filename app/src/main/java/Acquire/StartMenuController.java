package Acquire;


import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class StartMenuController {
    // ----------- StartMenu.fxml control -----------
    @FXML
    public void StartGame(MouseEvent mouseEvent) throws IOException {
        NewOrLoadGameClass.Start(new Stage());
    }


    public void ExitButton(MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        Window exitStage = node.getScene().getWindow();
        exitStage.hide();
    }
}
