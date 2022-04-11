package Acquire;

import javafx.scene.Parent;
import javafx.scene.Scene;
import lombok.Getter;

public class Acquire extends Scene {
    @Getter private Board board;

    public Acquire(Parent root) {super(root);}
}
