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

import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;

public class AcquireController {
    @FXML
    public static Text playerOneName;

    @FXML
    public static Text playerTwoName;

    @FXML
    public static Text playerThreeName;

    @FXML
    public static Text playerFourName;

    @FXML
    public static Text playerOneMoney;

    @FXML
    public static Text playerTwoMoney;

    @FXML
    public static Text playerThreeMoney;

    @FXML
    public static Text playerFourMoney;

    public static void editFonts() {
        Font thePrada20 = Font.loadFont("\\Acquire\\app\\src\\main\\resources\\ThePrada-K72gD.ttf", 20);
        playerOneName.setFont(thePrada20);
    }

    @FXML
    public synchronized void ContinentalStockDrag(DragEvent event) {

    }




    @FXML
    public void moveTile() {

    }


    private int board_width = 12;
    private int board_length = 9;
    private int totalPositions = 108;
    private int[][]  tilePositions = new int[board_width][board_length];


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


    @FXML
    public void boardGridPane(MouseEvent mouseEvent) {
    }
}
