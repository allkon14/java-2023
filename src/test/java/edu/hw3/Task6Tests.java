package edu.hw3;

import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockMarket;
import edu.hw3.Task6.StockMarketImpl;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Tests {
    @Test
    void test1() {
        StockMarket stockMarket = new StockMarketImpl();
        stockMarket.add(new Stock("ParProg", 30));
        stockMarket.add(new Stock("LinAl", 2000));
        stockMarket.add(new Stock("Matan", 3000));

        Stock stock = stockMarket.mostValuableStock();

        assertThat(stock).isEqualTo(new Stock("Matan", 3000));
    }

    @Test
    void test2() {
        StockMarket stockMarket = new StockMarketImpl();
        Stock stock1 = new Stock("KG", 1000);
        Stock stock2 = new Stock("Pravo", 500);
        stockMarket.add(stock1);
        stockMarket.add(stock2);

        stockMarket.remove(stock2);
        Stock stock = stockMarket.mostValuableStock();

        assertThat(stock).isEqualTo(stock1);
    }
}

