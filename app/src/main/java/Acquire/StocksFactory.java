/**
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
