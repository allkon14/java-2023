package edu.hw2.Task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private final Random rand = new Random();
    protected final double defaultConnection = 1.0;
    protected final double statusConnection;

    public DefaultConnectionManager() {
        this.statusConnection = this.defaultConnection;
    }

    public DefaultConnectionManager(double chance) {
        this.statusConnection = chance;
    }

    @Override
    public Connection getConnection() {
        if (rand.nextBoolean()) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
