package org.kata.marsrover;

import java.util.List;
import java.util.Objects;

public class Rover {
    private final Obstacles obstacles;
    private final List<Command> commands;

    private Position position;
    private Direction direction;

    public Rover(Position position, Direction direction) {
        this(position, direction, new Obstacles(), DefaultCommands.all);
    }

    public Rover(Position position, Direction direction, Obstacles obstacles, List<Command> commands) {
        this.position = position;
        this.direction = direction;
        this.obstacles = obstacles;
        this.commands = commands;
    }

    public void execute(char commandCharacter) {
        findCommandBy(commandCharacter).apply(this);
    }

    public void execute(char[] arrayOfCommands) {
        for (char command : arrayOfCommands) {
            execute(command);
        }
    }

    public void rotateLeft() {
        direction = facingDirection().rotateLeft();
    }

    public void move(Position step) {
        Position newPosition = position.add(step);
        checkForObstaclesAt(newPosition);
        position = newPosition;
    }

    public Direction facingDirection() {
        return direction;
    }

    private Command findCommandBy(char commandCharacter) {
        return commands.stream()
                .filter(command -> command.canApply(commandCharacter))
                .findFirst()
                .orElseGet(null);
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
