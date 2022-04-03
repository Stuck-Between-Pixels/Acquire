package Acquire;

import lombok.Getter;
import lombok.Setter;

/**
 * Holds stock information
 * @author Ben Thomas
 */
public class Stock {
    @Getter private final Corporation corp;
    @Getter @Setter private int price = 0;

    /**
     * Constructs a Stock with the given {@link Corporation} as its corporation
     * @param corporation the stock is a part of
     */
    public Stock(Corporation corporation) {
        this.corp = corporation;
    }
}
