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

class OriginatorSpec extends Specification {

    File file = new File("SaveFiles")
    File file2 = new File("SaveFiles2")

    def cleanup() {
        file.delete()
        file2.delete()
    }

    def "test gameSave and gameRestore work"() {
        given:
        Player player = new Player("WangoDango")
        Player player2 = new Player("WangoDango2")
        Board board1 = new Board(null, null, null, new ArrayList<Player>(Arrays.asList(player)), null, player)
        Board board2 = new Board(null, null, null, new ArrayList<Player>(Arrays.asList(player2)), null, player2)
        Originator origin = new Originator()
        when:
        origin.gameSave(file, board1)
        origin.gameSave(file2, board2)
        Board board3 = origin.gameRestore(file)
        Board board4 = origin.gameRestore(file2)
        then:
        board1.getPlayers().pop().getName() == board3.getPlayers().pop().getName()
        board2.getPlayers().pop().getName() == board4.getPlayers().pop().getName()
    }
}
