package Acquire;

import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import javafx.scene.input.DragEvent;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.LinkedList;

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

        var frame = new JFrame();
        var icon = new ImageIcon((Image) tiles.get(10));
        var label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

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
