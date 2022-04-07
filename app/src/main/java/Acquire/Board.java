package Acquire;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Board {
    private final TilePileIterator tiles;
    @Getter @Setter private Stock[] stocks;
    @Getter private final Corporation[] corporations;
    @Getter private final Player[] players;
    @Getter @Setter private Tile[] tilesPlaced;
    @Getter @Setter private Player currentTurn;

    private static Logger logger = LoggerFactory.getLogger(Board.class);

    public Board(TilePileIterator tiles, Stock[] stocks, Corporation[] corporations, Player[] players, Tile[] tilesPlaced, Player currentTurn) {
        this.tiles = tiles;
        this.stocks = stocks;
        this.corporations = corporations;
        this.players = players;
        this.tilesPlaced = tilesPlaced;
        this.currentTurn = currentTurn;
    }

    public void placeTile(Tile tile){

    }

    public Tile getTile(){
        return null;
    }

    public Board getState(){
        return new Board(this.tiles, this.stocks, this.corporations, this.players, this.tilesPlaced, this.currentTurn);
    }



}
