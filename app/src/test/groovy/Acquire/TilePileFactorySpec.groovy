package Acquire

import spock.lang.Specification

class TilePileFactorySpec extends Specification {
    def "TilePile creation size"() {
        given:
        def factory = new TilePileFactory()
        def pileArray = factory.createList()
        def pile = pileArray[0]

        when:
        def size = pile.size()

        then:
        size == 108
    }
}