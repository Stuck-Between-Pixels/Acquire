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

import java.nio.BufferOverflowException

class PlayerSpec extends Specification {
    def "Player name set"() {
        given:
        def player = new Player(name)

        expect:
        player.getName() == name

        where:
        name << ["Player 1", "010101", "A name", "", "-*(%^)#@_"]
    }

    def "Player has starting money"() {
        given:
        def player = new Player("name")

        expect:
        player.getMoney() == 6000
    }

    def "Give player new tile"() {
        given:
        def player = new Player("name")
        def tile = new Tile(5)

        when:
        player.giveTile(tile)

        then:
        player.tileIterator().next() == tile
        player.numTiles == 1
    }

    def "Too many tiles throws exception for adding single tile"() {
        given:
        def player = new Player("name")

        when:
        for (i in 0..<7) {
            player.giveTile(new Tile(1))
        }

        then:
        final BufferOverflowException = thrown(BufferOverflowException)
    }

    def "Too many tiles throws exception for adding multiple tiles"() {
        given:
        def player = new Player("name")
        def tiles = new LinkedList()

        when:
        for (i in 0..<7) {
            tiles.add(new Tile(5))
        }
        player.giveTiles(tiles)

        then:
        final BufferOverflowException = thrown(BufferOverflowException)
    }

    def "Remove tile by tile reference"() {
        given:
        def player = new Player("name")
        def tile = new Tile(20)

        when:
        player.giveTile(tile)

        then:
        player.removeTile(tile)
    }

    def "Remove tile by tile position"() {
        given:
        def player = new Player("name")
        def tile = new Tile(pos)

        when:
        player.giveTile(tile)
        player.removeTileByPosition(pos)

        then:
        final NoSuchElementException = notThrown(NoSuchElementException)

        where:
        pos << [0, 20, 47, 105, 13]
    }

    def "Remove tile by tile position throws error for when no tile found"() {
        given:
        def player = new Player("name")
        def tile = new Tile(0)

        when:
        player.giveTile(tile)
        player.removeTileByPosition(pos)

        then:
        final NoSuchElementException = thrown(NoSuchElementException)

        where:
        pos << [1, 20, 47, 105, 13]
    }

    def "Add stock"() {
        given:
        def player = new Player("name")
        def stock = new Stock(new Corporation("name"))

        when:
        player.addStock(stock)

        then:
        player.stockIterator().next() == stock
        player.getNumStock() == 1
    }

    def "Remove stock by stock reference"() {
        given:
        def player = new Player("name")
        def stock = new Stock(new Corporation("name"))

        when:
        player.addStock(stock)

        then:
        player.removeStock(stock)
    }

    def "Remove stock by corporation"() {
        given:
        def player = new Player("name")
        def corp = new Corporation("name")
        def stock = new Stock(corp)

        when:
        player.addStock(stock)
        player.removeStockByCorp(corp)

        then:
        final NoSuchElementException = notThrown(NoSuchElementException)
    }

    def "Remove stock by corporation throws error when no stock with corporation"() {
        given:
        def player = new Player("name")
        def corp = new Corporation("name")
        def stock = new Stock(corp)

        when:
        player.addStock(stock)
        player.removeStockByCorp(new Corporation("name"))

        then:
        final NoSuchElementException = thrown(NoSuchElementException)
    }
}
