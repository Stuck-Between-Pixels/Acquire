package Acquire;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.stage.*;

import java.io.IOException;

public class StartMenuController {

    @FXML
    public Button StartGame;

    @FXML
    public void NewOrLoadGame(MouseEvent mouseEvent) {
        
    }

    @FXML
    void buyStockButtonClicked(ActionEvent event) throws IOException {
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
