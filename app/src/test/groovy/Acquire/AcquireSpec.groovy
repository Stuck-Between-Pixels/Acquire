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

class AcquireSpec extends Specification {

    private Acquire acquire;

    void setup() {
        String player1 = "Jim"
        String player2 = "Jimmy"
        String player3 = "Jimothy"
        String player4 = "jimmmmm"
        acquire = new Acquire(player1, player2, player3, player4)
    }

    def "Player constructor sets up game correctly"() {
        given:
        String player1 = "Jim"
        String player2 = "Jimmy"
        String player3 = "Jimothy"
        String player4 = "jimmmmm"
        when: "instantiate Acquire with player names, give one player a tile"
        acquire = new Acquire(player1, player2, player3, player4)
        acquire.placeTile(acquire.getPlayers().get(0).tileIterator().next())
        then: "Everything gets filled in as new game"
        acquire.tilesOnBoard().isEmpty()
        !acquire.getPlayers().isEmpty()
        acquire.getPlayers().get(0).numTiles == 5
    }

    def "Board constructor sets everything up correctly"() {
        given:
        ArrayList<Tile> tiles = new ArrayList<Tile>(Arrays.asList(new Tile(1), new Tile(2)))
        ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(new Player("jimbo").giveTile(tiles.get(0))))
        Board board = new Board(null, null, null, players, tiles, null)
        when: "Initialize Acquire with Board"
        acquire = new Acquire(board)
        then:
        acquire.tilesOnBoard().isEmpty()
        !acquire.getPlayers().isEmpty()
        acquire.getPlayers().get(0).numTiles == 1
    }

    def "get players returns list of players"() {
        expect:
        !acquire.getPlayers().isEmpty()
    }

    def "get tiles on board returns a list of tiles on the board"() {
        expect:
        !acquire.tilesOnBoard().isEmpty()
    }

    def "Placing a tile updates Board"() {
        given:
        Tile tile = new Tile(7)
        when: "A tile is placed on the board"
        acquire.placeTile(tile)
        then: "Tile appears in placed tiles"
        acquire.tilesOnBoard().contains(tile)
    }

    def "Placing a tile can create a corporation"() {
        given:
        Tile tile = new Tile(1)
        Tile tile2 = new Tile(13)
        when:
        acquire.placeTile(tile)
        acquire.placeTile(tile2)
        then:
        for (Corporation corp : acquire.getCorporations()){
            corp.getNumTiles() != 0
        }
    }

    def "Placing a tile can merge a corporation"() {
        given:
        Tile tile = new Tile(1)
        Tile tile2 = new Tile(13)
        Tile tile3 = new Tile(3)
        Tile tile4 = new Tile(15)
        Tile tile5 = new Tile(2)
        when:
        acquire.placeTile(tile)
        acquire.placeTile(tile2)
        acquire.placeTile(tile3)
        acquire.placeTile(tile4)
        acquire.placeTile(tile5)
        then:
        for (Corporation corp : acquire.getCorporations()){
            corp.getNumTiles() == 5
        }
    }

    def "Placing a tile between two safe corps throws exception"() {
        given:
        for (int i = 0 ; i <11 ; i++){
            acquire.placeTile(new Tile(i))
            acquire.placeTile(new Tile(i+26))
        }
        when: "Tile placed between two safe corporations"
        acquire.placeTile(new Tile(13))
        then: "Throws exception"
        thrown SafeCorporationException
    }

    def "Placing a tile between two same size corps causes one of them to win"() {
        given:
        for (int i = 0 ; i <5 ; i++){
            acquire.placeTile(new Tile(i))
            acquire.placeTile(new Tile(i+26))
        }
        when: "Tile placed between two same size corporations"
        acquire.placeTile(new Tile(13))
        then:
        for (Corporation corp : acquire.getCorporations()){
            corp.getNumTiles() > 4
        }
    }

    def "newGame creates a new game"() {
        given:
        Player player1 = new Player("me")
        Board board = new Board(null, null, null, new ArrayList<Player>(Arrays.asList(player1)), null, null)
        when:
        acquire.newGame("me", "you", "them", "us")
        then:
        !acquire.getPlayers().contains(player1)
    }

    def "Load game and save game work correctly"() {
        given:
        String player1 = "Jim"
        String player2 = "Jimmy"
        String player3 = "Jimothy"
        String player4 = "jimmmmm"
        saved = new Acquire(player1, player2, player3, player4)
        saved.saveGame(new File("SaveFiles/savedGame"))
        Acquire notSaved = new Acquire("me1", "you1", "them1", "us1")
        when: "load game"
        notSaved.loadGame(new File("SaveFiles/savedGame"))
        then:
        notSaved.getPlayers().contains(player1)
    }

    def "buyStock adds stocks to specified player"() {
        given:
        String player1 = "Jim"
        String player2 = "Jimmy"
        String player3 = "Jimothy"
        String player4 = "jimmmmm"
        acquire = new Acquire(player1, player2, player3, player4)
        Stock stock = new Stock(new Corporation("wakanda"))
        when:
        acquire.buyStock(stock, player1)
        then:
        player1.stockIterator().next().is(stock)
    }

    def "endGame returns boolean of whether game can end or not"() {
        when:
        int i = 0
        while(i < 41){
            acquire.placeTile(new Tile(i))
        }
        then:
        acquire.endGame()
    }

    def "endTurn checks that players have played a tile and drawn a tile"() {
        given:
        String player1 = "Jim"
        String player2 = "Jimmy"
        String player3 = "Jimothy"
        String player4 = "jimmmmm"
        acquire = new Acquire(player1, player2, player3, player4)
        when:
        acquire.endTurn()
        then:
        thrown TurnNotOverException
    }
}
