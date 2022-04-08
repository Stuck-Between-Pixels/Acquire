package Acquire

import spock.lang.Specification

class TileSpec extends Specification {
    def "Position identifier set"() {
        given:
        def tile = new Tile(pos)

        expect:
        tile.getPosition() == pos

        where:
        pos << [0, 1, 2, 500, -4, -7, 20000]
    }
}
