package edu.hw3.Task6;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class Stock implements Comparable<Stock> {
    private int price;
    private String name;

    public Stock(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stock stock = (Stock) o;
        return Objects.equals(price, stock.price) && Objects.equals(name, stock.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    @Override public String toString() {
        return "Stock{" + "price=" + price + ", name='" + name + '\'' + '}';
    }

    @Override
    public int compareTo(@NotNull Stock o) {
        return 0;
    }
}
