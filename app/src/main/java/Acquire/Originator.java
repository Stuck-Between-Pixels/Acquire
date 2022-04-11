package Acquire;

import java.io.File;

public class Originator {
    private Board game;

    public Originator(Board game) {
        this.game = game;
    }

    public void gameSave(File file){

    }

    public Board gameRestore(File file){
        return null;
    }
}
