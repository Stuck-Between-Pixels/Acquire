package Acquire;

import lombok.NonNull;

import java.util.*;

/**
 * An implementation of an iterator for iterating through a collection of tiles. This class is meant to be used
 * within a {@link TilePile} implementation.
 * @author Ben Thomas
 */
public class TilePileIterator implements Iterator<Tile> {
    private final LinkedList<Tile> tiles;
    private final Collection<Tile> tilePile;
    private Tile current = null;

    /**
     * Constructs a new TilePileIterator object with a collection of tiles
     * @param tiles which the iterator will iterate through
     */
    public TilePileIterator(@NonNull Collection<Tile> tiles) {
        this.tiles = new LinkedList<>(tiles);
        this.tilePile = tiles;
    }

    /** {@inheritDoc} */
    @Override
    public boolean hasNext() {
        return !tiles.isEmpty();
    }

    /** {@inheritDoc} */
    @Override
    public Tile next() {
        if (tiles.isEmpty()) {
            throw new NoSuchElementException();
        }
        current = tiles.removeFirst();
        return current;
    }

    /** {@inheritDoc} */
    @Override
    public void remove() {
        if (current == null) throw new IllegalStateException();
        tilePile.remove(current);
    }
}
