package Acquire;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class TilePileIterator implements Iterator<Tile> {
    private final LinkedList<Tile> tiles;

    public TilePileIterator(Collection<Tile> tiles) {
        this.tiles = new LinkedList<>(tiles);
    }

    @Override
    public boolean hasNext() {
        return !tiles.isEmpty();
    }

    @Override
    public Tile next() {
        if (tiles.isEmpty()) {
            throw new EmptyStackException();
        }
        return tiles.removeFirst();
    }
}
