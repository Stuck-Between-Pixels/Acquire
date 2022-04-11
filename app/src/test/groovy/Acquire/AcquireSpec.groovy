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

    }

    def "Placing a tile can create a corporation"() {
        given:

        when:
        // TODO implement stimulus
        then:
        // TODO implement assertions
    }

    def "Placing a tile can merge a corporation"() {
        given:

        when:
        // TODO implement stimulus
        then:
        // TODO implement assertions
    }

    def "Placing a tile between two safe corps throws exception"() {
        given:

        when:
        // TODO implement stimulus
        then:
        // TODO implement assertions
    }

    def "Placing a tile between two same size corps causes a player decision"() {
        given:

        when:
        // TODO implement stimulus
        then:
        // TODO implement assertions
    }

    def "make corporation makes the seven corporations"() {
        given:

        when:
        // TODO implement stimulus
        then:
        // TODO implement assertions
    }

    def "make corporation initializes stock for each corp for Board"() {
        given:

        when:
        // TODO implement stimulus
        then:
        // TODO implement assertions
    }

    def "newGame creates a new game"() {
        given:

        when:
        // TODO implement stimulus
        then:
        // TODO implement assertions
    }

    def "Load game loads correctly"() {
        given:

        when:
        // TODO implement stimulus
        then:
        // TODO implement assertions
    }

    def "saveGame correctly saves the game"() {
        given:

        when:
        // TODO implement stimulus
        then:
        // TODO implement assertions
    }

    def "buyStock adds stocks to specified player"() {
        given:

        when:
        // TODO implement stimulus
        then:
        // TODO implement assertions
    }

    def "endGame returns boolean of whether game can end or not"() {
        given:

        when:
        // TODO implement stimulus
        then:
        // TODO implement assertions
    }

    def "endTurn checks that players have played a tile and drawn a tile, if possible"() {
        given:

        when:
        // TODO implement stimulus
        then:
        // TODO implement assertions
    }
}
