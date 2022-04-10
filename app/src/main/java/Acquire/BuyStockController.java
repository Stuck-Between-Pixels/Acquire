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
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.*;

import java.net.URL;
import java.util.ResourceBundle;

public class BuyStockController implements Initializable {
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label continentalCost;
    @FXML
    private Label continentalShares;
    @FXML
    private Label sacksonCost;
    @FXML
    private Label sacksonShares;
    @FXML
    private Label festivalCost;
    @FXML
    private Label festivalShares;
    @FXML
    private Label imperialCost;
    @FXML
    private Label imperialShares;
    @FXML
    private Label towerCost;
    @FXML
    private Label towerShares;
    @FXML
    private Label americanCost;
    @FXML
    private Label americanShares;
    @FXML
    private Label worldwideCost;
    @FXML
    private Label worldwideShares;
    @FXML
    private Spinner<Integer> continentalSpinner;
    @FXML
    private Spinner<Integer> sacksonSpinner;
    @FXML
    private Spinner<Integer> festivalSpinner;
    @FXML
    private Spinner<Integer> imperialSpinner;
    @FXML
    private Spinner<Integer> towerSpinner;
    @FXML
    private Spinner<Integer> americanSpinner;
    @FXML
    private Spinner<Integer> worldwideSpinner;
    @FXML
    private Label moneyAvailable;
    @FXML
    private Label costOfShares;
    @FXML
    private Label moneyAfter;

    @FXML
    void okButtonClicked() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    void cancelButtonClicked() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
