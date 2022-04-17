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

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Holds information about a corporation and gives methods to modify the corporation's fields.
 * @author Ben Thomas
 */
public class Corporation {
    @Getter private final String name;
    @Getter @Setter private boolean safe = false;
    private final LinkedList<Tile> tiles = new LinkedList<>();
    private final LinkedList<Stock> stocks = new LinkedList<>();
    @Getter @Setter private int stockPrice = 0;

    /**
     * Constructs a Corporation object with the given name as an identifier
     * @param name to give the corporation
     */
    public Corporation(String name) {
        this.name = name;

        StocksFactory factory = new StocksFactory();
        Stock[] stockList = (Stock[]) factory.createList(this);
        stocks.addAll(Arrays.stream(stockList).toList());
    }

    public Stock takeStock() {
        if (stocks.size() == 0) throw new NoSuchElementException("No stocks left in corporation");
        return stocks.remove();
    }

    public boolean hasStock() {
        return stocks.size() != 0;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
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
