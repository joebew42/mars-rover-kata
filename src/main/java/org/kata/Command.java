package org.kata;

public interface Command {
    Boolean canApply(Character commandAsCharacter);

    void apply(Rover rover);
}
