package org.kata.marsrover;

public class RotateRightCommand implements Command {
    @Override
    public Boolean canApply(Character commandAsCharacter) {
        return 'r' == commandAsCharacter;
    }

    @Override
    public void apply(Rover rover) {
        rover.rotateRight();
    }
}
