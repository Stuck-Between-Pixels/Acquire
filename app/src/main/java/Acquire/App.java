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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;

/**
 * A controller class to start and update the user interface
 *
 * @author Zackary Beck
 */
public class App extends Application {


    private Acquire currentGame;
    //private MainGame gameScreen;
    private SaveScreen saveScreen;
    private LoadScreen loadScreen;
    private StartMenuClass startMenuClass;
    private SellStock sellStockScreen;
    private BuyStock buyStockScreen;
    private Stage stage = new Stage();


    /**
     * The start method for the application. Displays the starting menu and all buttons associated with it
     *
     * @param stage  The window where all UI elements will be displayed
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("Acquire.fxml"));

        Scene scene = new Scene(loader.load());
        stage.setResizable(true);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Acquire");
        stage.setScene(scene);
        stage.show();
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
        launch();
    }
}
