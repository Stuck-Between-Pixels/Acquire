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

import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< Updated upstream

public class AcquireClass extends Scene {
    public AcquireClass(Parent root) { super(root); }
=======
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AcquireClass extends Scene {
    public AcquireClass(Parent root) { super(root); }

    public static void Start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("Acquire.FXML"));
        Scene scene = new Scene(loader.load());

        loader = loader.load(Objects.requireNonNull(AcquireClass.class.getResource("Acquire.FXML"))).openStream();
        AcquireController controller = (AcquireController) loader.getController();

        Acquire game = (Acquire) stage.getUserData();

        controller.setPlayers(game.getPlayers().get(0).getName(), game.getPlayers().get(1).getName(), game.getPlayers().get(2).getName(), game.getPlayers().get(3).getName(),
                String.valueOf(game.getPlayers().get(0).getMoney()),String.valueOf(game.getPlayers().get(1).getMoney()),String.valueOf(game.getPlayers().get(2).getMoney()),String.valueOf(game.getPlayers().get(3).getMoney()));


        stage.setTitle("New Game - Acquire");
        stage.setScene(scene);
        stage.show();
    }
>>>>>>> Stashed changes
}
