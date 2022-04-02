package Acquire;

import lombok.Getter;
import lombok.Setter;

public class Stock {
    @Getter private final Corporation corp;
    @Getter @Setter private int price;

    public Stock(Corporation corp) {
        this.corp = corp;
    }
}
