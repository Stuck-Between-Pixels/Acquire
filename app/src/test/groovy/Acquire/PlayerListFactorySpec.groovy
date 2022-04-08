package Acquire

import spock.lang.Specification

class PlayerListFactorySpec extends Specification {
    def "Default create list creates 4 players"() {
        given:
        def factory = new PlayerListFactory()

        when:
        def players = factory.createList()

        then:
        players.length == 4
    }

    def "Create list creates players with specific names"() {
        given:
        def factory = new PlayerListFactory()
        String[] names = [n1, n2, n3, n4]

        when:
        Player[] players = factory.createList(names) as Player[]

        then:
        for (i in 0..<names.length) {
            players[i].getName() == names[i]
        }

        where:
        n1 << ["Name", "player", "65847654", "#%^&!@#", "something I guess"]
        n2 << ["something I guess", "Name", "65847654", "#%^&!@#", "player"]
        n3 << ["65847654", "something I guess", "Name", "player", "#%^&!@#"]
        n4 << ["Name", "65847654", "#%^&!@#", "something I guess", "player"]
    }
}
