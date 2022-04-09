package Acquire;

import javafx.stage.*;

import java.io.*;

/**
 * A user interface class that opens a file explorer for the user to choose a file to load game from
 *
 * @author Zackary Beck
 */
public class LoadScreen {
    private Stage stage;

    /**
     * A constructor for the loading screen interface
     *
     * @param stage  The main application's stage to which the file chooser will be displayed
     */
    public LoadScreen(Stage stage) {
        this.stage = stage;
    }

    /**
     * Creates and opens the file explorer for the user to select a file from
     *
     * @return  The file selected by the user
     */
    public File openFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON File", "*.json"));

        return fileChooser.showOpenDialog(stage);
    }
}
