package org.kata;

public class ForwardCommand {
    void apply(Rover rover) {
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
