package Acquire

import spock.lang.Specification

class StockSpec extends Specification {

    def "Stock has corporation"() {
        given:
        def corp = new Corporation("name")
        def stock = new Stock(corp)

        expect:
        stock.getCorp() == corp
    }
}
