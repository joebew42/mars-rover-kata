package org.kata;

import java.util.Objects;

import static org.kata.Rover.Direction.*;

public class Rover {

    private final Commands commands = new Commands();

    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST;

        public static Direction facingNorth() {
            return NORTH;
        }

        public static Direction facingSouth() {
            return SOUTH;
        }

        public static Direction facingEast() {
            return EAST;
        }

        public static Direction facingWest() {
            return WEST;

        }
    }

    private Position position;

    private final Direction direction;
    private final Obstacles obstacles;

    public Rover(Position position, Direction direction) {
        this(position, direction, new Obstacles());
    }

    public Rover(Position position, Direction direction, Obstacles obstacles) {
        this.position = position;
        this.direction = direction;
        this.obstacles = obstacles;
    }

    public void execute(char commandCharacter) {
        commands.from(commandCharacter).apply(this);
    }

    public void moveWest() {
        assignPosition(position.decreaseX());
    }

    public void moveEast() {
        assignPosition(position.increaseX());
    }

    public void moveSouth() {
        assignPosition(position.decreaseY());
    }

    public void moveNorth() {
        assignPosition(position.increaseY());
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

    private void assignPosition(Position position) {
        checkForObstaclesAt(position);
        this.position = position;
    }

    private void checkForObstaclesAt(Position position) {
        if (obstacles.at(position)) {
            throw new UnableToMoveException("Obstacle encountered at: " + position);
        }
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
