package org.kata;

import java.util.Objects;

import static org.kata.Rover.Direction.*;

public class Rover {
    private final Command backwardCommand = new BackwardCommand();
    private final Command forwardCommand = new ForwardCommand();

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

    public void execute(char commandCharacter) {
        commandFrom(commandCharacter).apply(this);
    }

    public void moveWest() {
        position.decreaseX();
    }

    public void moveEast() {
        position.increaseX();
    }

    public void moveSouth() {
        position.decreaseY();
    }

    public void moveNorth() {
        position.increaseY();
    }

    public boolean isFacingNorth() {
        return NORTH.equals(direction);
    }

    public boolean isFacingSouth() {
        return SOUTH.equals(direction);
    }

    public boolean isFacingEast() {
        return EAST.equals(direction);
    }

    public boolean isFacingWest() {
        return WEST.equals(direction);
    }

    private Command commandFrom(char commandCharacter) {
        if (isBackwardCommand(commandCharacter)) {
            return backwardCommand;
        }

        if (isForwardCommand(commandCharacter)) {
            return forwardCommand;
        }
        return null;
    }

    private boolean isForwardCommand(char command) {
        return 'f' == command;
    }

    private boolean isBackwardCommand(char command) {
        return 'b' == command;
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
