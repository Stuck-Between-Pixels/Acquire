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
