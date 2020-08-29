package org.kata;

import java.util.Objects;

public class Rover {
    private Point point;

    public Rover(Point point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(point, rover.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
