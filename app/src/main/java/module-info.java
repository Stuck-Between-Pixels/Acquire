/**
 *
 */
module Acquire {
    requires javafx.fxml;
    requires javafx.controls;

    requires org.controlsfx.controls;
    requires lombok;

    opens Acquire to javafx.fxml;
    exports Acquire;
}