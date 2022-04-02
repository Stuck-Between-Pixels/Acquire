package Acquire;

import lombok.Getter;

import java.util.Collection;
import java.util.LinkedList;

public class TilePile {
    @Getter private final LinkedList<Tile> tiles = new LinkedList<>();

    public void addTiles(Collection<Tile> newTiles) {
        tiles.addAll(newTiles);
    }

    public TilePileIterator iterator() {
        return new TilePileIterator(tiles);
    }
}
