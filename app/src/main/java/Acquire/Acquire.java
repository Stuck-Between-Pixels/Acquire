package Acquire;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import lombok.Getter;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Acquire extends Scene {
    @Getter private Board board;

    public Acquire(Parent root) {super(root);}

    public static void Start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("Acquire.FXML"));

        Scene scene = new Scene(loader.load());
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("New Game - Acquire");
        stage.setScene(scene);
        stage.show();
    }
}
