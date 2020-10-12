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
    private Direction direction;
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
        if (commandCharacter == 'l') {
            rotateLeft();
        }

        if (commandCharacter != 'l') {
            commands.from(commandCharacter).apply(this);
        }
    }

    private void rotateLeft() {
        switch (direction) {
            case NORTH:
                direction = facingWest();
                break;
            case WEST:
                direction = facingSouth();
                break;
            case SOUTH:
                direction = facingEast();
                break;
            case EAST:
                direction = facingNorth();
                break;
        }
    }

    public void move(Position to) {
        Position newPosition = position.move(to);
        checkForObstaclesAt(newPosition);
        position = newPosition;
    }

    public Direction facingDirection() {
        return direction;
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
