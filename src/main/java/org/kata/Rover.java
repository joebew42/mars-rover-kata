package org.kata;

import java.util.Objects;

import static org.kata.Rover.Direction.*;

public class Rover {
    private final Point point;
    private final Direction direction;

    public Rover(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public void execute(char command) {
        if (direction == NORTH) {
            point.increaseY();
        }

        if (direction == SOUTH) {
            point.decreaseY();
        }

        if (direction == EAST) {
            point.increaseX();
        }

        if (direction == WEST) {
            point.decreaseX();
        }
    }

    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(point, rover.point) &&
                direction == rover.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, direction);
    }

    @Override
    public String toString() {
        return "Rover{point=" + point + ", direction=" + direction + '}';
    }
}
