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
