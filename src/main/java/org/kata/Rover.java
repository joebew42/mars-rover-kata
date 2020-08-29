package org.kata;

import java.util.Objects;

public class Rover {
    private Point point;
    private Direction direction;

    public Rover(Point point) {
        this.point = point;
    }

    public Rover(Direction direction) {
        this.direction = direction;
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

    public enum Direction {
        North,
        South;
    }
}
