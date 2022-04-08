package Acquire

import spock.lang.Specification

class CorporationSpec extends Specification {
    def "Corporation has name"() {
        given:
        def corp = new Corporation(name)

        expect:
        corp.getName() == name

        where:
        name << ["Corp 1", "010101", "A name", "", "-*(%^)#@_"]
    }

    def "Add tiles to corporation"() {
        given:
        def corp = new Corporation("name")
        def tiles = new Tile[10]

        when:
        for (i in 0..<10) {
            tiles[i] = new Tile(i)
        }
        corp.addTiles(tiles)
        def iter = corp.iterator()

        then:
        for (i in 0..<10) {
            iter.next() == tiles[i]
        }
        corp.getNumTiles() == 10
    }

    def "Set safe"() {
        given:
        def corp1 = new Corporation("name1")
        def corp2 = new Corporation("name2")

        when:
        corp2.setSafe(true)

        then:
        !corp1.isSafe()
        corp2.isSafe()
    }
}
