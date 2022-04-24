package Acquire;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class NewOrLoadGameClass extends Scene {
    public NewOrLoadGameClass(Parent root) {super(root);}

    public static void Start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("NewOrLoadGame.FXML"));

        Scene scene = new Scene(loader.load());
        stage.setResizable(true);
        stage.setTitle("Acquire - New Game");
        stage.setScene(scene);
        stage.show();
    }
}
