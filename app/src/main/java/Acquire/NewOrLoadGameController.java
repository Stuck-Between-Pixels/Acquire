package Acquire;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class NewOrLoadGameController {
    // ---------- NewOrLoadGame.fxml control ----------
    public static void NewGame() throws IOException {
        Acquire.Start(new Stage());
    }


    public void LoadGame(MouseEvent mouseEvent) {

    }
}
