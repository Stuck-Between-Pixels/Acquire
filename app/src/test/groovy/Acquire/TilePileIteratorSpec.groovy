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

class TilePileIteratorSpec extends Specification {
    def "Iterator has all elements from the original object"() {
        given:
        def tiles = new LinkedList<Tile>()
        for (i in start..<end) {
            tiles.add(new Tile(i))
        }

        when:
        def iter = new TilePileIterator(tiles)

        then:
        for (i in start..<end) {
            iter.next().position == i
        }

        where:
        start << [1, 20, 50, 200]
        end << [22, 40, 107, 201]
    }

    def "Iterator has next"() {
        given:
        def tiles = new LinkedList<Tile>()

        when:
        tiles.add(new Tile(1))
        def iter = new TilePileIterator(tiles)

        then:
        iter.hasNext()
        iter.next()
        !iter.hasNext()
    }

    def "Next throws no such element exception"() {
        given:
        def tiles = new LinkedList<Tile>()

        when:
        tiles.add(new Tile(1))
        def iter = new TilePileIterator(tiles)
        iter.next()
        iter.next()
        !iter.hasNext()

        then:
        final NoSuchElementException = thrown(NoSuchElementException)
    }

    def "Remove throws illegal state exception"() {
        given:
        def tiles = new LinkedList<Tile>()

        when:
        tiles.add(new Tile(1))
        def iter = new TilePileIterator(tiles)
        iter.remove()

        then:
        final IllegalStateException = thrown(IllegalStateException)
    }

    def "Remove removes from original collection"() {
        given:
        def tiles = new LinkedList<Tile>()

        when:
        tiles.add(new Tile(1))
        def iter = new TilePileIterator(tiles)

        then:
        tiles.size() == 1
        iter.next()
        iter.remove()
        tiles.size() == 0
    }
}
