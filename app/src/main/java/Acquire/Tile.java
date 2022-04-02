package Acquire;

import lombok.Getter;

public class Tile {
    @Getter private final int position;

    public Tile(int pos) {
        this.position = pos;
    }
}
