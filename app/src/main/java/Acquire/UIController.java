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

import javafx.scene.*;
import javafx.stage.*;
import javafx.application.*;

/**
 * A controller class to start and update the user interface
 *
 * @author Zackary Beck
 */
public class UIController extends Application {

    private Acquire currentGame;
    private MainGame gameScreen;
    private SaveScreen saveScreen;
    private LoadScreen loadScreen;
    private StartMenu startMenu;
    private SellStock sellStockScreen;
    private BuyStock buyStockScreen;
    private Stage stage;

    /**
     * UI controller constructor
     *
     * @param currentGame  The current game to be displayed and updated
     */
    public UIController(Acquire currentGame) {
        this.currentGame = currentGame;
        gameScreen = new MainGame();
        saveScreen = new SaveScreen(stage);
        loadScreen = new LoadScreen(stage);
        startMenu = new StartMenu();
        sellStockScreen = new SellStock();
        buyStockScreen = new BuyStock();
    }

    /**
     * The start method for the application. Displays the starting menu and all buttons associated with it
     *
     * @param stage  The window where all UI elements will be displayed
     */
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("Acquire");
        stage.setScene(startMenu);
    }

    /**
     * A method to update the scene currently on the stage. For example, when the user presses the start button from the
     * menu, update is called to change the scene to the main game scene.
     *
     * @param newScene  The new scene that will be updated to
     */
    public void update(Scene newScene) {
        stage.setScene(newScene);
    }

    /**
     * Main method to launch the application
     *
     * @param args  User-given command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
