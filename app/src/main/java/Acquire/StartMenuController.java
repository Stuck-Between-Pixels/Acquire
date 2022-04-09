package Acquire;

import javafx.fxml.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class StartMenuController {
    @FXML
    public Button ExitButton;

    @FXML
    public Button StartGameButton;

    @FXML
    public void NewOrLoadGame(MouseEvent mouseEvent) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("NewOrLoadGame button has been pressed");
        a.show();
    }

    @FXML
    public void exitGame(MouseEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("ExitGame button has been pressed");
        a.show();
    }

    public void ExitGame(MouseEvent mouseEvent) {
    }
}
