package Acquire;

import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import javafx.scene.input.DragEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class AcquireController {
    @FXML
    public JFXButton ContinentalStockButton;

    @FXML
    public JFXButton SacksonStockButton;

    @FXML
    public JFXButton ImperialStockButton;

    @FXML
    public JFXButton FestivalStockButton;

    @FXML
    public JFXButton TowerStockButton;

    @FXML
    public JFXButton AmericanStockButton;

    @FXML
    public JFXButton WordlwideStockButton;

    @FXML
    public JFXButton ContinentalBuilding;

    @FXML
    public JFXButton SacksonBuilding;

    @FXML
    public JFXButton ImperialBuilding;

    @FXML
    public JFXButton FestivalBuilding;

    @FXML
    public JFXButton TowerBuilding;

    @FXML
    public JFXButton AmericanBuilding;

    @FXML
    public JFXButton WorldwideBuilding;

    @FXML
    public synchronized void ContinentalStockDrag(DragEvent event) {

    }


    public void tilePile() {
        String path = "../../resources/images/Tiles/"; //File name goes here
        String letter = "A";
        Integer number = 1;

        String string = letter + number;
        int result = 0;
        switch(string.charAt(1)){

            case 'A' -> {
                result = 0;
            }

            case 'B' -> {
                result = 13;
            }

            case 'C' -> {
                result = 13*2;
            }

            case 'D' -> {
                result = 13*3;
            }

            case 'E' -> {
                result = 13*4;
            }

            case 'F' -> {
                result = 13*5;
            }

            case 'G' -> {
                result = 13*6;
            }

            case 'H' -> {
                result = 13*7;
            }

            case 'I' -> {
                result = 13*8;
            }

        }
        result = result + Integer.parseInt(String.valueOf(string.charAt(0)));
    }

    @FXML
    public void buyStockButton() throws IOException {
        BuyStock.Start(new Stage());
    }

    @FXML
    public void hyperLinkClicked() throws URISyntaxException {
        try {
            Desktop.getDesktop().browse(new URI("https://www.ultraboardgames.com/acquire/game-rules.php"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
