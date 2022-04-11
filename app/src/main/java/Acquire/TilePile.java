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

import java.util.Collection;
import java.util.LinkedList;

/**
 * Contains a collection of tiles that can be drawn from using an iterator.
 * @author Ben Thomas
 */
public class TilePile {
    private static final LinkedList<Tile> tiles = new LinkedList<>();

    /**
     * Adds the given collection of {@link Tile tiles} to the TilePile
     * @param newTiles to add to the tile pile
     */
    public static void addTiles(Collection<Tile> newTiles) {
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
     * Returns the number of tiles the tile pile is holding
     * @return number of tiles in the tile pile
     */
    public int size() {
        return tiles.size();
    }
}
