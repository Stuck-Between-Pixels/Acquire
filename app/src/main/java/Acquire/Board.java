package Acquire;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Board {
    private final TilePileIterator tiles;
    @Getter @Setter private Stock[] stocks;
    @Getter private final Corporation[] corporations;
    @Getter private final ArrayList<Player> players;
    @Getter @Setter private ArrayList<Tile> tilesPlaced;
    @Getter private Player currentTurn;

    public Board(TilePileIterator tiles, Stock[] stocks, Corporation[] corporations, ArrayList<Player> players, ArrayList<Tile> tilesPlaced, Player currentTurn) {
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

    public void setCurrentTurn(Player currentTurn) throws PlayerDoesntExistException {
        if(players.contains(currentTurn)) {
            this.currentTurn = currentTurn;
        }else{
            throw new PlayerDoesntExistException("Player doesn't exist.");
        }
    }
}
