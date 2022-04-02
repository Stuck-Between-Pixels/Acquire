package Acquire;

/**
 * Abstract factory class which defines constants for factories and provides a method for extended factories to
 * implement. Factories are used to protect the creation logic of their subsequent objects.
 * @see TilePileFactory
 * @see StocksFactory
 * @see PlayerListFactory
 * @author Ben Thomas
 */
public abstract class AbstractFactory {
    protected final int NUM_STOCKS_PER_CORP = 25;
    protected final int NUM_OF_TILES = 108;
    protected final int DEFAULT_NUM_PLAYERS = 4;

    /**
     * Creates an array of objects and returns the array to the user.
     * @return an array of objects created by the factory
     */
    public abstract Object[] createList();
}
