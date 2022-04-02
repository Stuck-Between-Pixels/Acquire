package Acquire;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.LinkedList;

public class Corporation {
    @Getter private final String name;
    @Getter @Setter private boolean safe = false;
    private final LinkedList<Tile> tiles = new LinkedList<>();

    public Corporation(String name) {
        this.name = name;
    }

    public int getNumTiles() {
        return tiles.size();
    }

    public void addTiles(Tile[] tiles) {
        this.tiles.addAll(Arrays.asList(tiles));
    }
}
