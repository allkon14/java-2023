package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CoordinateTest {
    @DisplayName("Coordinate вправо")
    @Test
    void coordRight() {
        assertThat(new Coordinate(1, 0).relation(new Coordinate(2, 0)))
            .isEqualTo(Coordinate.Direction.RIGHT);
    }

    @DisplayName("Coord влево")
    @Test
    void coordLeft() {
        assertThat(new Coordinate(2, 0).relation(new Coordinate(1, 0)))
            .isEqualTo(Coordinate.Direction.LEFT);
    }

    @DisplayName("Coord вниз")
    @Test
    void coordDown() {
        assertThat(new Coordinate(0, 1).relation(new Coordinate(0, 2)))
            .isEqualTo(Coordinate.Direction.DOWN);
    }

    @DisplayName("Coord вверх")
    @Test
    void coordUp() {
        assertThat(new Coordinate(0, 2).relation(new Coordinate(0, 1)))
            .isEqualTo(Coordinate.Direction.UP);
    }
}
