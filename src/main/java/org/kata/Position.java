package org.kata;

import java.util.Objects;

public class Position {
    public static final Position UP = new Position(0, 1);
    public static final Position DOWN = new Position(0, -1);
    public static final Position RIGHT = new Position(1, 0);
    public static final Position LEFT = new Position(-1, 0);

    public static Position at(int x, int y) {
        return new Position(x, y);
    }

    private final int x;
    private final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position add(Position position) {
        return new Position(x + position.x, y + position.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{x=" + x + ", y=" + y + '}';
    }
}
