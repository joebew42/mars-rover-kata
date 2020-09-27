package org.kata;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

    public static Position at(int x, int y) {
        return new Position(x, y);
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position increaseY() {
        return new Position(x, y + 1);
    }

    public Position decreaseY() {
        return new Position(x, y - 1);
    }

    public Position increaseX() {
        return new Position(x + 1, y);
    }

    public Position decreaseX() {
        return new Position(x - 1, y);
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
