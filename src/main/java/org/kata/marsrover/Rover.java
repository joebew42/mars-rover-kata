package org.kata.marsrover;

import java.util.Objects;

public class Rover {
    private final Commands commands;
    private final Obstacles obstacles;

    private Position position;
    private Direction direction;

    public Rover(Position position, Direction direction) {
        this(position, direction, new Obstacles());
    }

    public Rover(Position position, Direction direction, Obstacles obstacles) {
        this(position, direction, obstacles, new Commands());
    }

    public Rover(Position position, Direction direction, Obstacles obstacles, Commands commands) {
        this.position = position;
        this.direction = direction;
        this.obstacles = obstacles;
        this.commands = commands;
    }

    public void execute(char[] arrayOfCommands) {
        for (char command : arrayOfCommands) {
            execute(command);
        }
    }

    private void execute(char commandCharacter) {
        commands.findBy(commandCharacter).apply(this);
    }

    public void rotateLeft() {
        direction = facingDirection().rotateLeft();
    }

    public void rotateRight() {
        direction = facingDirection().rotateRight();
    }

    public void move(Position step) {
        Position newPosition = position.add(step);
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
