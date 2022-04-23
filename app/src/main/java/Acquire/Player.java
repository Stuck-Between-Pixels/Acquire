/**
 * MIT License
 *
 * Copyright (c) 2022 [Stuck-Between-Pixels](https://github.com/Stuck-Between-Pixels/Acquire)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package Acquire;

import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;

import java.nio.BufferOverflowException;
import java.util.*;

/**
 * The player class for the game. This class holds data relevant to the player and provides ways to modify said data
 * safely and logically.
 * @author Ben Thomas
 */
public class Player {
    @Getter private final String name;
    @Getter @Setter private int money = 6_000;
    private final ArrayList<Tile> tiles = new ArrayList<>(6);
    private final ArrayList<Stock> stocks = new ArrayList<>();

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
    public void giveTiles(@NonNull Collection<Tile> tileCollection) {
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
     * @throws NoSuchElementException if the player does not have a tile with the given position
     */
    public void removeTileByPosition(int position) {
        Tile remove = null;
        for (var tile : tiles) {
            if (tile.getPosition() == position) {
                remove = tile;
                break;
            }
        }
        if (remove == null) throw new NoSuchElementException();
        tiles.remove(remove);
    }

    /**
     * Retries the number of tiles the player has
     * @return the number of tiles the player has
     */
    public int getNumTiles() {
        return tiles.size();
    }

    /**
     * Creates an iterator for the player's tiles
     * @return iterator of the player's tiles
     */
    public Iterator<Tile> tileIterator() {
        return tiles.iterator();
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
     * Removes a stock by the stock's corporation's name from the player's stocks
     * @param corporation of the stock to be removed from the player's stocks
     * @throws NoSuchElementException if the player does not have a stock with the given corporation
     */
    public void removeStockByCorp(Corporation corporation) {
        Stock remove = null;
        for (var stock : stocks) {
            if (Objects.equals(stock.getCorp().getName(), corporation.getName())) {
                remove = stock;
                break;
            }
        }
        if (remove == null) throw new NoSuchElementException();
        stocks.remove(remove);
    }

    /**
     * Retries the number of stocks the player has
     * @return the number of stocks the player has
     */
    public int getNumStock() {
        return stocks.size();
    }

    /**
     * Retries the number of stocks the player has from a specific corporation by the passed corporation's name
     * @param corp to search for
     * @return number of stocks
     */
    public int getNumStockFromCorp(Corporation corp) {
        Iterator<Stock> iter = stocks.iterator();
        int amount = 0;
        while (iter.hasNext()) {
            if (Objects.equals(iter.next().getCorp().getName(), corp.getName())) {
                amount++;
            }
        }
        return amount;
    }

    /**
     * Creates an iterator for the player's stocks
     * @return iterator of the player's stocks
     */
    public Iterator<Stock> stockIterator() {
        return stocks.iterator();
    }
}
