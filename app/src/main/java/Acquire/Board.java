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

import java.util.*;

/**
 * The Board class. This is the model part of the MVC pattern. This object stores all the core
 * data of the game.
 *
 * @author Grant Madson
 */
public class Board {
    private final TilePileIterator tiles;
    @Getter private final Corporation[] corporations;
    @Getter private final ArrayList<Player> players;
    private Iterator<Player> playerSequence;
    @Getter private final ArrayList<Tile> tilesPlaced;
    @Getter private Player currentTurn;

    /**
     *The constructor for the board object.
     *
     * @param tiles This is a TilePileIterator containing the tiles that have yet to be distributed.
     * @param corporations This is a list of the games corporations.
     * @param players These are the games current players.
     * @param tilesPlaced This is an arrayList of the tiles that have already been placed.
     * @param currentTurn This is the player whose turn it currently is.
     */
    public Board(TilePileIterator tiles, Corporation[] corporations, ArrayList<Player> players, ArrayList<Tile> tilesPlaced, Player currentTurn) {
        this.tiles = tiles;
        this.corporations = corporations;
        this.players = players;
        this.tilesPlaced = tilesPlaced;
        this.currentTurn = currentTurn;
        this.playerSequence = players.iterator();
    }

    /**
     * Places a tile onto the board. Does this utilizing an ArrayList.
     * @see Tile
     * @param tile This is the tile to be placed.
     */
    public void placeTile(Tile tile){
        tilesPlaced.add(tile);
    }

    /**
     * Returns and removes a tile from the tile pile.
     *
     * @see TilePileFactory
     * @see TilePileIterator
     * @see TilePile
     * @see Tile
     * @return A random tile from the tile pile (note, not randomized here, randomized by TilePileFactory)
     * @throws NoSuchElementException if there are no longer any tiles left in the pile
     */
    public Tile getTile() throws NoSuchElementException {
        return tiles.next();
    }

    /**
     * Returns the state of the board. Used to save the game.
     *
     * @return a copy of the Board (note: local variables are passed along. Only Board is not passed.)
     */
    public Board getState(){
        return new Board(this.tiles, this.corporations, this.players, this.tilesPlaced, this.currentTurn);
    }

    /**
     * Used to set the games current turn to a player in the players list.
     *
     * @param currentTurn the player whose turn it is being set to
     * @throws PlayerDoesntExistException thrown when a player is chosen who isn't on the player list. How did you do that?
     */
    public void setCurrentTurn(Player currentTurn) throws PlayerDoesntExistException {
        if(players.contains(currentTurn)) {
            this.currentTurn = currentTurn;
        }else{
            throw new PlayerDoesntExistException("Player doesn't exist.");
        }
    }

    /**
     * Advances the player turn to the next player in line.
     *
     */
    public void nextTurn() {
        if (!playerSequence.hasNext()) {
            playerSequence = players.iterator();
        }
        currentTurn = playerSequence.next();
    }
}
