package Acquire;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Contains a collection of tiles that can be drawn from using an iterator.
 * @author Ben Thomas
 */
public class TilePile {
    private final LinkedList<Tile> tiles = new LinkedList<>();

    /**
     * Adds the given collection of {@link Tile tiles} to the TilePile
     * @param newTiles to add to the tile pile
     */
    public void addTiles(Collection<Tile> newTiles) {
        tiles.addAll(newTiles);
    }

    /**
     * Gets the TilePile's iterator
     * @return the TilePile's iterator
     */
    public TilePileIterator iterator() {
        return new TilePileIterator(tiles);
    }

    /**
     * Retries the number of tiles the tile pile is holding
     * @return number of tiles in the tile pile
     */
    public int size() {
        return tiles.size();
    }
}
