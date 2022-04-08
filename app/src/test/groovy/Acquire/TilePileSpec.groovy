package Acquire

import spock.lang.Specification

class TilePileSpec extends Specification {
    def "Add tiles"() {
        given:
        def tilePile = new TilePile()
        def tiles = new ArrayList(108)

        when:
        for (i in 0..<108) {
            tiles.add(new Tile(i))
        }
        tilePile.addTiles(tiles)
        def iter = tilePile.iterator()

        then:
        for (i in 0..<108) {
            iter.next().position == i
        }
        tilePile.size() == 108
    }
}
