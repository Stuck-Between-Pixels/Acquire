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

import javafx.scene.image.Image;
import lombok.Getter;

import java.awt.image.BufferedImage;

/**
 * Tile class which represents a game tile. This class holds information about a tile's position.
 * @author Ben Thomas
 */
public class Tile {
    @Getter private final int position;

    @Getter BufferedImage tileImage;

    /**
     * Constructs a Tile object with the given position. The tile's position will act as an identifier.
     * @param position to give the tile as an identifier
     */
    public Tile(int position, BufferedImage tileImage) {
        this.position = position;
        this.tileImage = tileImage;
    }
}
