package Acquire;

import javafx.stage.*;

import java.io.*;

/**
 * A user interface class that opens a file explorer for the user to choose a file to save game to
 *
 * @author Zackary Beck
 */
public class SaveScreen {
    private Stage stage;

    /**
     * A constructor for the save screen interface
     *
     * @param stage  The main application's stage to which the file chooser will be displayed
     */
    public SaveScreen(Stage stage) {
        this.stage = stage;
    }

    /**
     * Creates and opens the file explorer for the user to select a file from or to create a new file
     *
     * @return  The file selected or created by the user
     */
    public File openFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));

        return fileChooser.showSaveDialog(stage);
    }
}
