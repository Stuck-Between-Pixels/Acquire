/**
 * MIT License
 *
 * Copyright (c) 2022 [Stuck-Between-Pixels](https://github.com/Stuck-Between-Pixels/Acquire)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package Acquire;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class AcquireController implements Initializable {
    @FXML public Text playerOneName;
    @FXML public Text playerTwoName;
    @FXML public Text playerThreeName;
    @FXML public Text playerFourName;
    @FXML public Text playerOneMoney;
    @FXML public Text playerTwoMoney;
    @FXML public Text playerThreeMoney;
    @FXML public Text playerFourMoney;
    @FXML public Polygon playerTriangle;
    @FXML public Button EndTurnButton;

    private Acquire acquire;
    private Boolean gameEnded = false;



    /**
     * Not Working?
    public static void editFonts() {
    public void editFonts() {
        Font thePrada20 = Font.loadFont("\\Acquire\\app\\src\\main\\resources\\ThePrada-K72gD.ttf", 20);
        playerOneName.setFont(thePrada20);
    }
     */

    @FXML
    public JFXButton TileOne;

    @FXML
    public static ImageView TileOneImg;

    @FXML
    public void NewTile(ActionEvent event) {
        String path = "\\Acquire\\app\\src\\main\\resources\\images\\Tiles\\3.png";

        TilePile[] tilePile = (TilePile[]) new TilePileFactory().createList();
        Iterator<Tile> tile = tilePile[0].iterator();

        //TileOneImg.setImage(new Image(path));

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


    @FXML
    public void boardGridPane(MouseEvent mouseEvent) {
    }

    private void loadResultsScreen(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("GameOver.FXML"));

        Parent root = loader.load();
        GameOverController controller = loader.<GameOverController>getController();
        controller.setAcquire(acquire);
        Scene scene = new Scene(root);
        stage.setResizable(true);
        stage.setTitle("Acquire - Game Results");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void endTurnClicked(Event event) throws IOException {
        acquire.endTurn();

        if (gameEnded) {
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            loadResultsScreen(stage);
            return;
        }

        if (acquire.currentPlayer() == acquire.getPlayers().get(3)) {
            playerTriangle.setTranslateY(0);
        }
        else {
            playerTriangle.setTranslateY(playerTriangle.getTranslateY() + 55);
        }
    }

    @FXML
    public void endGameClicked() {
        if (!acquire.endGame()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Can Not End Game");
            alert.setHeaderText(null);
            alert.setContentText("The conditions to end the game have not been met.");

            alert.showAndWait();
            return;
        }
        //else

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Ending");
        alert.setHeaderText(null);
        alert.setContentText("Game will end after this turn.");
        alert.showAndWait();
        gameEnded = true;
    }

    public void setAcquire(Acquire acquire) {
        this.acquire = acquire;
        playerOneName.setText(acquire.getPlayers().get(0).getName());
        playerTwoName.setText(acquire.getPlayers().get(1).getName());
        playerThreeName.setText(acquire.getPlayers().get(2).getName());
        playerFourName.setText(acquire.getPlayers().get(3).getName());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
