package org.kata;

import java.util.Objects;

import static org.kata.Rover.Direction.*;

public class Rover {
    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST;
    }

    private final Point point;
    private final Direction direction;

    public Rover(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public void execute(char command) {
        if (isFacingNorth()) {
            point.increaseY();
        }

        if (isFacingSouth()) {
            point.decreaseY();
        }

        if (isFacingEast()) {
            point.increaseX();
        }

        if (isFacingWest()) {
            point.decreaseX();
        }
    }

    private boolean isFacingNorth() {
        return NORTH.equals(direction);
    }

    private boolean isFacingSouth() {
        return SOUTH.equals(direction);
    }

    private boolean isFacingEast() {
        return EAST.equals(direction);
    }

    private boolean isFacingWest() {
        return WEST.equals(direction);
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
