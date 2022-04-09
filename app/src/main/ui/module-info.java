/**
 *
 */
module Acquire.ui.main {
    requires javafx.fxml;
    requires javafx.controls;

    opens ui to javafx.fxml;
    exports Acquire.ui;
}