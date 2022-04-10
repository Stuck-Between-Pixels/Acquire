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

    def "Set stock price"() {
        given:
        def corp = new Corporation("name")
        def stock = new Stock(corp)

        when:
        stock.setPrice(price)

        then:
        stock.getPrice() == price

        where:
        price << [5000, 0, 47, 10000, 500, 107]
    }
}
