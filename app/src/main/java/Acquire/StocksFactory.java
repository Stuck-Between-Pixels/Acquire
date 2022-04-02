package Acquire;

/**
 * Extends {@link AbstractFactory} as an implementation of a factory which creates an array of {@link Stock stocks}.
 * @see AbstractFactory
 * @see TilePileFactory
 * @see PlayerListFactory
 * @author Ben Thomas
 */
public class StocksFactory extends AbstractFactory {
    /**
     * Creates an array of {@link Stock stocks} for a single corporation and returns the array to the user.
     * @return an array of {@link Stock stocks} created by the factory
     */
    @Override
    public Object[] createList() {
        Stock[] stocks = new Stock[NUM_STOCKS_PER_CORP];
        for (int i=0; i<NUM_STOCKS_PER_CORP; i++) {
            Corporation corporation = new Corporation("NewCorporation");
            stocks[i] = new Stock(corporation);
        }
        return stocks;
    }

    /**
     * Creates an array of {@link Stock stocks} for the specified corporation and returns the array to the user.
     * @param corporation the corporation the factory will create an array of stocks for
     * @return an array of {@link Stock stocks} for the specified corporation created by the factory
     */
    public Object[] createList(Corporation corporation) {
        Stock[] stocks = new Stock[NUM_STOCKS_PER_CORP];
        for (int i=0; i<NUM_STOCKS_PER_CORP; i++) {
            stocks[i] = new Stock(corporation);
        }
        return stocks;
    }
}
