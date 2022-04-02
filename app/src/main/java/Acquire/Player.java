package Acquire;

import lombok.Getter;
import lombok.Setter;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * The player class for the game. This class holds data relevant to the player and provides ways to modify said data
 * safely and logically.
 * @author Ben Thomas
 */
public class Player {
    @Getter private final String name;
    @Getter @Setter private int money = 6_000;
    @Getter private final ArrayList<Tile> tiles = new ArrayList<>(6);
    @Getter private final ArrayList<Stock> stocks = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void giveTiles(Tile tile) {
        if (tiles.size() >= 6) throw new BufferOverflowException();
        tiles.add(tile);
    }

    public void giveTiles(Collection<Tile> tileCollection) {
        if (tiles.size() + tileCollection.size() > 6) throw new BufferOverflowException();
        tiles.addAll(tileCollection);
    }

    public void removeTile(Tile tile) {
        if (tiles.size() == 0) throw new BufferUnderflowException();
        tiles.remove(tile);
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public void removeStock(Corporation corporation) {
        Stock remove = null;
        for (var stock : stocks) {
            if (stock.getCorp() == corporation) {
                remove = stock;
                break;
            }
        }
        if (remove != null) stocks.remove(remove);
    }
}
