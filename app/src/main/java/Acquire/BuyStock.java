package Acquire;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class BuyStock extends Scene {
    public BuyStock(Parent root) {super(root);}

    public static void Start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("BuyStock.fxml"));

        Scene scene = new Scene(loader.load(), 500, 700);
        stage.initStyle(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Buy Stock");
        stage.setScene(scene);
        stage.showAndWait();
    }
}
