package edu.project2;

public record Coordinate(int x, int y) {public enum Direction {
    UP, DOWN, RIGHT, LEFT
}

    Direction relation(Coordinate other) {
        Direction res = null;
        if (this.x() < other.x()) {
            res = Coordinate.Direction.RIGHT;
        }

        if (this.x() > other.x()) {
            res = Coordinate.Direction.LEFT;
        }

        if (this.y() > other.y()) {
            res = Coordinate.Direction.UP;
        }

        if (this.y() < other.y()) {
            res = Coordinate.Direction.DOWN;
        }

        return res;
    }
}
