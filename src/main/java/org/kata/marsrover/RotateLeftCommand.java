package org.kata.marsrover;

public class RotateLeftCommand implements Command {
    @Override
    public Boolean canApply(Character commandAsCharacter) {
        return 'l' == commandAsCharacter;
    }

    @Override
    public void apply(Rover rover) {
        rover.rotateLeft();
    }
}
