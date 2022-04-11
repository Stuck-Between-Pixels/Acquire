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
    private Originator save;
    private final int TOTAL_STOCK_NUM = 175;

    @Getter private ArrayList<Player> players;
    @Getter private final Corporation[] corps = {new Corporation("American"), new Corporation("Continental"),
            new Corporation("Festival"), new Corporation("Imperial"), new Corporation("Sackson"),
            new Corporation("Tower"), new Corporation("Worldwide")};
    @Getter final private ArrayList<Stock> stocks = new ArrayList<>(TOTAL_STOCK_NUM);

    public Acquire(String player1, String player2, String player3, String player4) {


        StocksFactory stocksFactory = new StocksFactory();
        for (Corporation corp : corps){
            Stock[] newStocks = (Stock[]) stocksFactory.createList(corp);
            stocks.addAll(Arrays.stream(newStocks).toList());
        }

        players = new ArrayList<>(Arrays.asList(new Player(player1), new Player(player2), new Player(player3), new Player(player4)));

        //this.board = new Board();
        this.save = new Originator();
    }

    public Acquire(Board board) {
        this.board = board;
    }

    public ArrayList<Tile> tilesOnBoard(){
        return null;
    }

    public void placeTile(Tile tile){
        //TODO add exception if tile cant be placed due to safe
    }

    public Corporation[] getCorporations(){
        return null;
    }

    public void newGame(String player1, String player2, String player3, String player4){

    }

    public void loadGame(File file){

    }

    public void saveGame(File file){

    }

    public void buyStock(Stock stock, Player player){

    }

    public boolean endGame(){
        return false;
    }

    public void endTurn(){

    }

    public void giveTile(Player player){
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
