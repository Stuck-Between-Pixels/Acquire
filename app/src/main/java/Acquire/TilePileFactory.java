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
