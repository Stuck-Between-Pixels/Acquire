package Acquire;

import lombok.Getter;
import lombok.Setter;

import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * The player class for the game. This class holds data relevant to the player and provides ways to modify said data
 * safely and logically.
 * @author Ben Thomas
 */
public class Player {
    @Getter private final String name;
    @Getter @Setter private int money = 6_000;
    @Getter private final ArrayList<Tile> tiles = new ArrayList<>(6);
    @Getter private final ArrayList<Stock> stocks = new ArrayList<>();

    /**
     * Constructor for a new Player which accepts a name to give the player as identification
     * @param name of the new player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Adds the given tile to the player
     * @param tile to give the player
     * @throws BufferOverflowException if the player can not store anymore tiles
     */
    public void giveTile(Tile tile) {
        if (tiles.size() >= 6) throw new BufferOverflowException();
        tiles.add(tile);
    }

    /**
     * Adds the tiles in the given collection to the player's tile collection
     * @param tileCollection to add to the player's already owned collection of tiles
     * @throws BufferOverflowException if the player can not store all tiles in the given collection
     */
    public void giveTiles(Collection<Tile> tileCollection) {
        if (tiles.size() + tileCollection.size() > 6) throw new BufferOverflowException();
        tiles.addAll(tileCollection);
    }

    /**
     * Removes the given tile from the player
     * @param tile object to remove from the player
     * @return a boolean representing if the given tile was found and removed or not
     */
    public boolean removeTile(Tile tile) {
        return tiles.remove(tile);
    }

    /**
     * Removes a tile by tile position from the player
     * @param position of the tile to remove
     * @throws IndexOutOfBoundsException if the player does not have a tile with the given position
     */
    public void removeTileByPosition(int position) {
        Tile remove = null;
        for (var tile : tiles) {
            if (tile.getPosition() == position) {
                remove = tile;
                break;
            }
        }
        if (remove == null) throw new IndexOutOfBoundsException();
        tiles.remove(remove);
    }

    /**
     * Adds the given stock to the player's stocks
     * @param stock to add to the player's stocks
     */
    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    /**
     * Removes the given stock from the player's stocks
     * @param stock to remove from the player's stocks
     * @return a boolean representing if the given stock was found and removed or not
     */
    public boolean removeStock(Stock stock) {
        return stocks.remove(stock);
    }

    /**
     * Removes a stock by the stock's corporation from the player's stocks
     * @param corporation of the stock to be removed from the player's stocks
     * @throws IndexOutOfBoundsException if the player does not have a stock with the given corporation
     */
    public void removeStockByCorp(Corporation corporation) {
        Stock remove = null;
        for (var stock : stocks) {
            if (stock.getCorp() == corporation) {
                remove = stock;
                break;
            }
        }
        if (remove == null) throw new IndexOutOfBoundsException();
        stocks.remove(remove);
    }
}
