package Acquire;

import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;
import java.io.IOException;

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



    @FXML
    public void buyStockButton(MouseEvent mouseEvent) throws IOException {
        BuyStockController.buyStockButtonClicked(mouseEvent);
    }
}
