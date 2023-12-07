package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionManager;
import edu.hw2.Task3.DefaultConnectionManager;
import edu.hw2.Task3.FaultyConnection;
import edu.hw2.Task3.FaultyConnectionManager;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConnectionTest {
    @Test
    @DisplayName("DefaultConnectionManager --> Connection interface implementation")
    void check_DefaultConnectionManager_getConnection() {

        ConnectionManager connectionManager = new DefaultConnectionManager();
        Connection connection = connectionManager.getConnection();
        assertThat(connection).isInstanceOf(Connection.class);
    }

    @Test
    @DisplayName("FaultyConnectionManager --> FaultyConnection")
    void check_FaultyConnectionManager_getConnection() {

        ConnectionManager connectionManager = new FaultyConnectionManager();
        Connection connection = connectionManager.getConnection();
        assertThat(connection).isInstanceOf(FaultyConnection.class);
    }

    @ParameterizedTest(name = "Test {index} default connection manager must return faulty connection with probability {0}")
    @ValueSource(doubles = {0.1, 0.2, 0.5, 0.7, 0.9, 1})
    public void check_defaultConnectionManager(double chance) {
        DefaultConnectionManager defaultConnectionManager = new DefaultConnectionManager(chance);
        Connection connection;
        do {
            connection = defaultConnectionManager.getConnection();
        }
        while (!(connection instanceof FaultyConnection));
    }

}
