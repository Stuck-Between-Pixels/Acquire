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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The controller part of our MVC implementation.
 * This object implements the main control of the app.
 *
 * @author Grant Madson
 */
public class Acquire {
    private Board board;
    private Originator save = new Originator();

    @Getter private final Corporation[] corps = {new Corporation("American"), new Corporation("Continental"),
            new Corporation("Festival"), new Corporation("Imperial"), new Corporation("Sackson"),
            new Corporation("Tower"), new Corporation("Worldwide")};

    public Acquire(String player1, String player2, String player3, String player4) {

        ArrayList<Player> players = new ArrayList<>(Arrays.asList(new Player(player1),
                new Player(player2), new Player(player3), new Player(player4)));

        TilePileFactory tilePileFactory = new TilePileFactory();
        TilePile[] tilePile = (TilePile[]) tilePileFactory.createList();
        ArrayList<Tile> tilesPlaced = new ArrayList<>();
        board = new Board(tilePile[0].iterator(),
                corps,
                players,
                tilesPlaced,
                players.get(0));
    }

    public Acquire(Board board) {
        this.board = board;
    }

    public ArrayList<Player> getPlayers(){
        return null;
    }

    public ArrayList<Tile> tilesOnBoard(){
        return board.getTilesPlaced();
    }

    public void placeTile(Tile tile){
        //TODO add exception if tile cant be placed due to safe
    }

    public Corporation[] getCorporations(){
        return board.getCorporations();
    }

    public void newGame(String player1, String player2, String player3, String player4){

    }

    public void loadGame(File file) throws IOException {
        board = save.gameRestore(file);
    }

    public void saveGame(File file){

    }

    public void buyStock(Stock stock, Player player){
        if (player.getMoney() - stock.getCorp().getStockPrice() <= 0) return;
        player.setMoney(player.getMoney() - stock.getCorp().getStockPrice());
        player.addStock(stock);
    }

    public boolean endGame(){
        int count = 0;
        for (var corp : board.getCorporations()) {
            if (corp.getNumTiles() < 41) return true;
            if (corp.isSafe()) {
                count++;
            }
        }
        return count == board.getCorporations().length;
    }

    public void endTurn(){
        board.nextTurn();
    }

    public void giveTile(Player player){
        board.getCurrentTurn().giveTile(board.getTile());
    }

    public Player getTurn(){
        return board.getCurrentTurn();
    }

    private boolean isTouchingCorp(){
        return false;
    }

    private Corporation[] corpsBeingTouched(Tile tile){
        return null;
    }

    private void merge(Corporation[] corps){

    }
}
