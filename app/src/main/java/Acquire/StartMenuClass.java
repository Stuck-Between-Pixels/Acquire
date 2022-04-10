package Acquire;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class StartMenuClass extends Scene {
    public StartMenuClass(Parent root) {
        super(root);
    }

    public static void Start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("StartMenu.FXML"));

        Scene scene = new Scene(loader.load());
        stage.setResizable(true);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Acquire");
        stage.setScene(scene);
        stage.show();
    }
}
