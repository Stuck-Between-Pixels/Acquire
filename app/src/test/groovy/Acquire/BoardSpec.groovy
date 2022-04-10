package Acquire

import spock.lang.Specification

/**
 * Unit testing for the Board class. Implemented using Spock.
 *
 * @author Grant Madson
 *
 */

class BoardSpec extends Specification {

    private Board board = new Board(null, null, null, null, null, null)


    /**
     * Tests that when a tile is placed whether or not it appears in the array of placed tiles in the board.
     *
     * This is only testing that the tile is actually placed. Logic for placing a tile should be taken care of
     * outside of in the controller, not the model.
     */
    def "Place tile actually places tile"() {
        setup:
        Tile tile = new Tile()

        when: "A tile is placed"
        board.placeTile(tile)

        then: "Check if the tile is indeed placed"
        board.getTilesPlaced().contains(tile)

    }

    /**
     * Tests whether or not getState returns an object with the same innards.
     */
    def "GetState returns this object"() {
        setup:

        Stock[] stocks = [new Stock(), new Stock(), new Stock()]
        Tile[] tileList = [new Tile(), new Tile(), new Tile()]
        TilePileIterator tiles = new TilePileIterator(tileList)
        final Corporation[] corporations = [new Corporation(), new Corporation(), new Corporation(), new Corporation(), new Corporation(), new Corporation(), new Corporation()]
        final ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(new Player(), new Player(), new Player(), new Player()))
        final ArrayList<Tile> tilesPlaced = new ArrayList<Tile>(Arrays.asList(new Tile(), new Tile()))
        Player currentTurn = players[0]

        board = new Board(tiles, stocks, corporations, players, tilesPlaced, currentTurn)

        when: "getState is called"

        Board board2 = board.getState()

        then: "check that all data is the same"
        board.tilesPlaced == board2.tilesPlaced
        board.stocks == board2.stocks
        board.tile == board2.tile
        board.corporations == board2.corporations
        board.players == board2.players
        board.currentTurn == board2.currentTurn

    }

    /**
     * Checks to make sure that getTile gives a tile from the available tiles.
     * Does not test for randomness as that would take too long.
     */
    def "GetTile returns a valid tile"() {
        setup:
        Tile tile1 = new Tile()
        Tile tile2 = new Tile()
        Tile tile3 = new Tile()
        Tile tile4 = new Tile()

        Tile[] tiles = [tile1, tile2, tile3, tile4]

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
        Stock stock1 = new Stock()
        Stock stock2 = new Stock()
        Stock stock3 = new Stock()
        Stock stock4 = new Stock()

        Stock[] stocks = [stock1, stock2, stock3, stock4]

        Board board = new Board(null, stocks, null, null, null, null)

        when: "get stocks"
        Stock[] returnedStocks = board.getStocks()

        then: "returns the correct stocks"
        returnedStocks == stocks
    }

    /**
     * Makes sure that Board stores corporations and not another data type.
     * Kinda redundant, but I already wrote it.
     */
    def "Get corporations returns correct type"() {
        expect:
        board.getCorporations().is(Corporation[])
    }

    /**
     * makes sure that getCorporations returns the list of corporations held by the board.
     */
    def "Get corporations returns the corporations"(){
        setup:
        Corporation corp1 = new Corporation()
        Corporation corp2 = new Corporation()
        Corporation corp3 = new Corporation()
        Corporation corp4 = new Corporation()
        Corporation corp5 = new Corporation()
        Corporation corp6 = new Corporation()
        Corporation corp7 = new Corporation()
        Corporation corp8 = new Corporation()
        Corporation[] list = [corp1, corp2, corp3, corp4, corp5, corp6, corp7, corp8]
        board = new Board(null, null, list, null, null, null)

        when: "get corporations"
        Corporation[] corps = board.getCorporations()

        then: "returns the correct list of corporations"
        corps == list
    }

    /**
     * makes sure that a Player array is returned.
     */
    def "Get players returns right type"() {
        expect:
        board.getPlayers().is(Player[])
    }

    /**
     * Makes sure that getPlayers returns the players held by the board.
     */
    def "get players returns the right players"(){
        setup:
        Player player1 = new Player()
        Player player2 = new Player()
        Player player3 = new Player()
        Player player4 = new Player()

        ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(player1, player2, player3, player4))

        Board board = new Board(null, null, null, players, null, null)

        when: "Get the players"
        ArrayList<Player> returned = board.getPlayers()

        then: "players returned should be the same as players set"
        returned == players
    }

    /**
     * Makes sure that getTilesPlaced returns a Tile array.
     */
    def "returns the right type for tiles on board"() {
        expect:
        board.getTilesPlaced().is(Tile[])
    }

    /**
     * Makes sure that getTiles returns the Tile objects that the board has placed on it.
     */
    def "returns the tiles that are on the board"(){
        setup:
        Tile tile1 = new Tile()
        Tile tile2 = new Tile()
        Tile tile3 = new Tile()
        Tile tile4 = new Tile()

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
        Player player1 = new Player()
        Player player2 = new Player()
        Player player3 = new Player()
        Player player4 = new Player()

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
        Player player = new Player()
        Player player2 = new Player()
        Board tempBoard = new Board(null, null, null, null, null, player2)

        when: "set current turn to player"
        tempBoard.setCurrentTurn(player)

        then: "Current turn is set to player"
        tempBoard.getCurrentTurn() == player
    }

    /**
     * makes sure that the player who is getting the turn set to them actually exists.
     */
    def "only valid players can get the turn set to them"(){
        setup:
        Player player1 = new Player()
        Player player2 = new Player()
        Player player3 = new Player()
        Player player4 = new Player()
        Player player5 = new Player()

        ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(player1, player2, player3, player4))

        Board board = new Board(null, null, null, players, null, player1)

        when: "set the current player"
        board.setCurrentTurn(player5)

        then: "check that exception is thrown"
        thrown PlayerDoesntExistException
    }


}
