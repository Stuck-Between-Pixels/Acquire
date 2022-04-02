package Acquire;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Extends {@link AbstractFactory} as an implementation of a factory which creates a {@link TilePile}.
 * @see AbstractFactory
 * @see PlayerListFactory
 * @see StocksFactory
 * @author Ben Thomas
 */
public class TilePileFactory extends AbstractFactory {
    /**
     * Creates an array containing a {@link TilePile tile pile} initialized with shuffled tiles and returns
     * the array to the user.
     * @return an array containing a {@link TilePile tile pile} created by the factory
     */
    @Override
    public Object[] createList() {
        ArrayList<Tile> tiles = new ArrayList<>(NUM_OF_TILES);
        for (int i=0; i<NUM_OF_TILES; i++) {
            tiles.add(new Tile(i));
        }
        Collections.shuffle(tiles);
        TilePile pile = new TilePile();
        pile.addTiles(tiles);
        return new TilePile[]{pile};
    }
}
