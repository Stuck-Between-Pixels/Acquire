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
