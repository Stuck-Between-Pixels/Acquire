package Acquire

import spock.lang.Specification

class OriginatorSpec extends Specification {

    File file = new File("SaveFiles/saveGame")
    File file2 = new File("SaveFiles/saveGame2")

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
        Originator origin = new Originator(board1)
        Originator origin2 = new Originator(board2)
        when:
        origin.gameSave(file)
        origin2.gameSave(file2)
        Board board3 = origin.gameRestore(file)
        Board board4 = origin2.gameRestore(file2)
        then:
        board1.getPlayers().pop().getName() == board3.getPlayers().pop().getName()
        board2.getPlayers().pop().getName() == board4.getPlayers().pop().getName()
    }
}
