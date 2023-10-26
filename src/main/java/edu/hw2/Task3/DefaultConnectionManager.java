package edu.hw2.Task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private final Random rand = new Random();

    @Override
    public Connection getConnection() {
        if (rand.nextBoolean()) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
