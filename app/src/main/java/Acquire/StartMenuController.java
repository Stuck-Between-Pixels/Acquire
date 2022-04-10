package Acquire;


import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;
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
    void buyStockButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("buystock.fxml"));
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent, 500, 375);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }


    public void ExitButton(MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        Window exitStage = node.getScene().getWindow();
        exitStage.hide();
    }
}
