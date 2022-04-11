/*
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
package Acquire

import spock.lang.Specification

/**
 * Unit testing for the Board class. Implemented using Spock.
 *
 * @author Grant Madson
 *
 */

class BoardSpec extends Specification {

    Corporation corp = new Corporation("WAP")
    Corporation corp2 = new Corporation("WAP2")
    Stock[] stocks = [new Stock(corp), new Stock(corp), new Stock(corp)]
    ArrayList<Tile> tileList = new ArrayList<Tile>(Arrays.asList(new Tile(1), new Tile(2), new Tile(3)))
    TilePileIterator tiles = new TilePileIterator(tileList)
    final Corporation[] corporations = [corp, corp2]
    final ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(new Player("Jim"), new Player("Jimmy"), new Player("Jimthony"), new Player("Jimtholomew")))
    final ArrayList<Tile> tilesPlaced = new ArrayList<Tile>(Arrays.asList(new Tile(4), new Tile(5)))
    Player currentTurn = players.get(0)

    Board board = new Board(tiles, stocks, corporations, players, tilesPlaced, currentTurn)

    /**
     * Tests that when a tile is placed whether or not it appears in the array of placed tiles in the board.
     *
     * This is only testing that the tile is actually placed. Logic for placing a tile should be taken care of
     * outside of in the controller, not the model.
     */
    def "Place tile actually places tile"() {
        setup:
        Tile tile = new Tile(1)

        when: "A tile is placed"
        board.placeTile(tile)

        then: "Check if the tile is indeed placed"
        board.getTilesPlaced().contains(tile)

    }

    /**
     * Tests whether or not getState returns an object with the same innards.
     */
    def "GetState returns this object"() {

        when: "getState is called"

        Board board2 = board.getState()

        then: "check that all data is the same"
        board.tilesPlaced.is(board2.tilesPlaced)
        board.stocks.is(board2.stocks)
        board.corporations.is(board2.corporations)
        board.players.is(board2.players)
        board.currentTurn.is(board2.currentTurn)
        //There is no way to see if they have the same
        //tilePileIterator with the access rights that are given.
    }

    /**
     * Checks to make sure that getTile gives a tile from the available tiles.
     * Does not test for randomness as that would take too long.
     */
    def "GetTile returns a valid tile"() {
        setup:
        Tile tile1 = new Tile(1)
        Tile tile2 = new Tile(2)
        Tile tile3 = new Tile(3)
        Tile tile4 = new Tile(4)

        ArrayList<Tile> tiles = new ArrayList<Tile>(Arrays.asList(tile1, tile2, tile3, tile4))

        Board board = new Board(new TilePileIterator(tiles), null, null, null, null, null)

        when: "get a random tile"
        Tile randomTile = board.getTile()

        then:
        tiles.contains(randomTile)
    }

    /**
     * Checks whether or not getStocks returns the available stocks.
     */
    def "GetStocks returns the available stocks"() {
        setup:
        Stock stock1 = new Stock(corp)
        Stock stock2 = new Stock(corp)
        Stock stock3 = new Stock(corp)
        Stock stock4 = new Stock(corp)

        Stock[] stocks = [stock1, stock2, stock3, stock4]

        Board board = new Board(null, stocks, null, null, null, null)

        when: "get stocks"
        Stock[] returnedStocks = board.getStocks()

        then: "returns the correct stocks"
        returnedStocks == stocks
    }



    /**
     * makes sure that getCorporations returns the list of corporations held by the board.
     */
    def "Get corporations returns the corporations"(){
        setup:
        Corporation corp1 = new Corporation("1")
        Corporation corp2 = new Corporation("2")
        Corporation corp3 = new Corporation("3")
        Corporation corp4 = new Corporation("4")
        Corporation corp5 = new Corporation("5")
        Corporation corp6 = new Corporation("6")
        Corporation corp7 = new Corporation("7")
        Corporation corp8 = new Corporation("8")
        Corporation[] list = [corp1, corp2, corp3, corp4, corp5, corp6, corp7, corp8]
        board = new Board(null, null, list, null, null, null)

        when: "get corporations"
        Corporation[] corps = board.getCorporations()

        then: "returns the correct list of corporations"
        corps.is(list)
    }


    /**
     * Makes sure that getPlayers returns the players held by the board.
     */
    def "get players returns the right players"(){
        setup:
        Player player1 = new Player("a")
        Player player2 = new Player("b")
        Player player3 = new Player("c")
        Player player4 = new Player("d")

        ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(player1, player2, player3, player4))

        Board board = new Board(null, null, null, players, null, null)

        when: "Get the players"
        ArrayList<Player> returned = board.getPlayers()

        then: "players returned should be the same as players set"
        returned == players
    }


    /**
     * Makes sure that getTiles returns the Tile objects that the board has placed on it.
     */
    def "returns the tiles that are on the board"(){
        setup:
        Tile tile1 = new Tile(1)
        Tile tile2 = new Tile(2)
        Tile tile3 = new Tile(3)
        Tile tile4 = new Tile(4)

        ArrayList<Tile> tiles = new ArrayList<Tile>(Arrays.asList(tile1, tile2, tile3, tile4))

        Board board = new Board(null, null, null, null, tiles, null)

        when: "get tiles that have been placed"
        ArrayList<Tile> returnedTiles = board.getTilesPlaced()

        then: "returns the correct tiles"
        returnedTiles == tiles

    }

    /**
     * Makes sure that the correct turn is given by the board object.
     */
    def "GetCurrentTurn returns correct turn"() {
        setup:
        Player player1 = new Player("a")
        Player player2 = new Player("b")
        Player player3 = new Player("c")
        Player player4 = new Player("d")

        ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(player1, player2, player3, player4))

        Board board = new Board(null, null, null, players, null, player1)

        when: "get the current player"
        Player currentPlayer = board.getCurrentTurn()

        then: "check if it's the current player"
        currentPlayer == player1
    }

    /**
     * Makes sure that set turn sets the turn to the player that is passed into the function.
     */
    def "Set current turn actually sets the turn"() {
        setup:
        Player player = new Player("a")
        Player player2 = new Player("b")
        ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(player, player2))
        Board tempBoard = new Board(null, null, null, players, null, player2)

        when: "set current turn to player"
        tempBoard.setCurrentTurn(player)

        then: "Current turn is set to player"
        tempBoard.getCurrentTurn().is(player)
    }

    /**
     * makes sure that the player who is getting the turn set to them actually exists.
     */
    def "only valid players can get the turn set to them"(){
        setup:
        Player player1 = new Player("a")
        Player player2 = new Player("b")
        Player player3 = new Player("c")
        Player player4 = new Player("d")
        Player player5 = new Player("e")

        ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(player1, player2, player3, player4))

        Board board = new Board(null, null, null, players, null, player1)

        when: "set the current player"
        board.setCurrentTurn(player5)

        then: "check that exception is thrown"
        thrown PlayerDoesntExistException
    }


}
