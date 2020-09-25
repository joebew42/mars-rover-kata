package org.kata;

public class ForwardCommand implements Command {
    @Override
    public void apply(Rover rover) {
        if (rover.isFacingNorth()) {
            rover.moveNorth();
        }
        if (rover.isFacingSouth()) {
            rover.moveSouth();
        }
        if (rover.isFacingEast()) {
            rover.moveEast();
        }
        if (rover.isFacingWest()) {
            rover.moveWest();
        }
    }
}
