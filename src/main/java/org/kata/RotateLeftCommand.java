package org.kata;

public class RotateLeftCommand implements Command {
    @Override
    public void apply(Rover rover) {
        rover.rotateLeft();
    }
}
