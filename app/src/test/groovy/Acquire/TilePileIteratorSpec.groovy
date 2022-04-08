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
