module Acquire {
    requires javafx.fxml;
    requires javafx.controls;

    requires org.controlsfx.controls;
    requires lombok;
    requires com.jfoenix;

    opens Acquire to javafx.fxml;
    exports Acquire;
}