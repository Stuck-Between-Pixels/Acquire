package Acquire;

import lombok.Getter;

/**
 * Tile class which represents a game tile. This class holds information about a tile's position.
 * @author Ben Thomas
 */
public class Tile {
    @Getter private final int position;

    /**
     * Constructs a Tile object with the given position. The tile's position will act as an identifier.
     * @param position to give the tile as an identifier
     */
    public Tile(int position) {
        this.position = position;
    }
}
