package Acquire;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewOrLoadGameController {
    Acquire game;
    Stage stage;

    // ---------- NewOrLoadGame.fxml control ----------
<<<<<<< Updated upstream
    public static void NewGame() throws IOException {
        //Acquire.Start(new Stage());
    }




    public void LoadGame(MouseEvent mouseEvent) {

=======
    @FXML
    public void NewGame(Event event) throws IOException {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        TextInputDialog dialog = new TextInputDialog();
        String[] playerNames = new String[4];
        for(var ref = new Object() {
            int i = 1;
        }; ref.i < 5; ref.i++){
            dialog.setTitle("Enter player " + ref.i + " name.");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent( string -> { playerNames[ref.i -1] = string; });
        }
        game = (Acquire) stage.getUserData();
        game.newGame(playerNames[0], playerNames[1], playerNames[2], playerNames[3]);
        AcquireClass.Start(stage);
    }

    @FXML
    public void LoadGame() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        game = (Acquire) stage.getUserData();
        try {
            game.loadGame(file);
        } catch (IOException e) {
            LoggerFactory.getLogger(Acquire.class).error("Bad file");
            LoggerFactory.getLogger(Acquire.class).debug(String.valueOf(e));
        }
        AcquireClass.Start(stage);
>>>>>>> Stashed changes
    }
}
