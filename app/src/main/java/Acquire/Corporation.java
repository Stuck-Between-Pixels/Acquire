package Acquire;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Holds information about a corporation and gives methods to modify the corporation's fields.
 * @author Ben Thomas
 */
public class Corporation {
    @Getter private final String name;
    @Getter @Setter private boolean safe = false;
    private final LinkedList<Tile> tiles = new LinkedList<>();

    /**
     * Constructs a Corporation object with the given name as an identifier
     * @param name to give the corporation
     */
    public Corporation(String name) {
        this.name = name;
    }

    /**
     * Gets and returns the number of tiles owned by the corporation
     * @return the number of tiles owned by the corporation
     */
    public int getNumTiles() {
        return tiles.size();
    }

    /**
     * Creates an iterator of the corporation's stocks
     * @return iterator of the corporation's stocks
     */
    public Iterator<Tile> iterator() {
        return tiles.iterator();
    }

    /**
     * Adds an array of tiles to the corporation
     * @param tiles to add to the corporation
     */
    public void addTiles(Tile[] tiles) {
        this.tiles.addAll(Arrays.asList(tiles));
    }
}
