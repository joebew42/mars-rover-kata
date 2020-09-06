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

    private final Position position;
    private final Direction direction;

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void execute(char command) {
        if (isBackwardCommand(command)) {
            if (isFacingNorth()) {
                moveSouth();
            }
        }

        if (isForwardCommand(command)) {
            if (isFacingNorth()) {
                moveNorth();
            }

            if (isFacingSouth()) {
                moveSouth();
            }

            if (isFacingEast()) {
                moveEast();
            }

            if (isFacingWest()) {
                moveWest();
            }
        }
    }

    private boolean isForwardCommand(char command) {
        return 'f' == command;
    }

    private boolean isBackwardCommand(char command) {
        return 'b' == command;
    }

    private void moveWest() {
        position.decreaseX();
    }

    private void moveEast() {
        position.increaseX();
    }

    private void moveSouth() {
        position.decreaseY();
    }

    private void moveNorth() {
        position.increaseY();
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
        return Objects.equals(position, rover.position) &&
                direction == rover.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {
        return "Rover{position=" + position + ", direction=" + direction + '}';
    }
}
