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

/**
 * Extends {@link AbstractFactory} as an implementation of a factory which creates an array of {@link Player players}.
 * @see AbstractFactory
 * @see TilePileFactory
 * @see StocksFactory
 * @author Ben Thomas
 */
public class PlayerListFactory extends AbstractFactory {
    /**
     * Creates an array of {@link Player players} and returns the array to the user.
     * @return an array of {@link Player players} created by the factory
     */
    @Override
    public Object[] createList() {
        Player[] players = new Player[DEFAULT_NUM_PLAYERS];
        for (int i=0; i<DEFAULT_NUM_PLAYERS; i++) {
            players[i] = new Player("Player " + (i+1));
        }
        return players;
    }

    /**
     * Creates an array of {@link Player players} with user specified names and returns the array to the user.
     * @param playerNames an array of player names to use when initializing new players. The size of this array
     *                    will determine the number of players returned by the method.
     * @return an array of {@link Player players} created by the factory. This array will contain the same number
     * of objects as the playerNames parameter.
     */
    public Object[] createList(@NonNull String[] playerNames) {
        Player[] players = new Player[playerNames.length];
        for (int i=0; i< playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
        }
        return players;
    }
}
