package Acquire

import spock.lang.Specification

class StocksFactorySpec extends Specification {
    def "Default create list creates correct amount of stocks"() {
        given:
        def factory = new StocksFactory()

        when:
        def stocks = factory.createList()

        then:
        stocks.length == 25
    }

    def "Create list creates stocks with specific corporation"() {
        given:
        def factory = new StocksFactory()
        def corp = new Corporation("name")

        when:
        Stock[] stocks = factory.createList(corp) as Stock[]

        then:
        for (i in 0..<25) {
            stocks[i].getCorp() == corp
        }
    }
}
