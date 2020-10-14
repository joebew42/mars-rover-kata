package org.kata.marsrover;

public interface Command {
    Boolean canApply(Character commandAsCharacter);

    void apply(Rover rover);
}
