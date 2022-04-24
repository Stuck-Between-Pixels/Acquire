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

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class AcquireController {
    @FXML public Text playerOneName;
    @FXML public Text playerTwoName;
    @FXML public Text playerThreeName;
    @FXML public Text playerFourName;
    @FXML public Text playerOneMoney;
    @FXML public Text playerTwoMoney;
    @FXML public Text playerThreeMoney;
    @FXML public Text playerFourMoney;
    @FXML public Polygon playerTriangle;
    @FXML public Button endTurnButton;

    private Acquire acquire;
    private Boolean gameEnded = false;

    public void editFonts() {
        Font thePrada20 = Font.loadFont("\\Acquire\\app\\src\\main\\resources\\ThePrada-K72gD.ttf", 20);
        playerOneName.setFont(thePrada20);
    }

    @FXML
    public static JFXButton TileOne;

    @FXML
    public static ImageView TileOneImg;

    @FXML
    public static void listOfImages() {
        String path = "\\Acquire\\app\\src\\main\\resources\\images\\Tiles\\";
        int tileSpot = 12;
        int number = 1;
        String letter = "A";
        BufferedImage img = null;

        LinkedList tiles = new LinkedList();


        try {
            img = ImageIO.read(new File(path + Integer.parseInt(String.valueOf(number)) + letter + ".png"));
            tiles.add(img);
        } catch (IOException e) {
            e.printStackTrace();
        }


        TilePile.addTiles(tiles);

    }


    @FXML
    public void NewTile(ActionEvent event) {
        String path = "\\Acquire\\app\\src\\main\\resources\\images\\Tiles\\3.png";

        TilePile[] tilePile = (TilePile[]) new TilePileFactory().createList();
        Iterator<Tile> tile = tilePile[0].iterator();

        //TileOneImg.setImage(new Image(path));

    }



    public static void imageTest() {

        TilePile[] tilePile = (TilePile[]) new TilePileFactory().createList();
        Iterator<Tile> tile = tilePile[0].iterator();
        BufferedImage tile1 = tile.next().getTileImage();
        String path = "\\Acquire\\app\\src\\main\\resources\\images\\Tiles\\3.png";

        JFrame frame = new JFrame();
        //ImageIcon icon = new ImageIcon(tile1);
        ImageIcon icon = new ImageIcon(path);
        frame.add(new JLabel(icon));
        frame.pack();
        frame.setVisible(true);
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

    @FXML
    public void TileOneClicked() {

    }

    private void loadResultsScreen(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("GameOver.FXML"));

        Scene scene = new Scene(loader.load());
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
}
