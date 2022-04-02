package Acquire;

import lombok.NonNull;

/**
 * Extends {@link AbstractFactory} as an implementation of a factory which creates an array of {@link Player players}.
 * @see AbstractFactory
 * @see TilePileFactory
 * @see StocksFactory
 * @author Ben Thomas
 */
public class PlayerListFactory extends AbstractFactory {
    /**
     * Creates an array of {@link Player players} and returns the array to the user.
     * @return an array of {@link Player players} created by the factory
     */
    @Override
    public Object[] createList() {
        Player[] players = new Player[DEFAULT_NUM_PLAYERS];
        for (int i=0; i<DEFAULT_NUM_PLAYERS; i++) {
            players[i] = new Player("Player " + (i+1));
        }
        return players;
    }

    /**
     * Creates an array of {@link Player players} with user specified names and returns the array to the user.
     * @param playerNames an array of player names to use when initializing new players. The size of this array
     *                    will determine the number of players returned by the method.
     * @return an array of {@link Player players} created by the factory. This array will contain the same number
     * of objects as the playerNames parameter.
     */
    public Object[] createList(@NonNull String[] playerNames) {
        Player[] players = new Player[playerNames.length];
        for (int i=0; i< playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
        }
        return players;
    }
}
