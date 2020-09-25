package org.kata;

public class BackwardCommand {
    void apply(Rover rover) {
        if (rover.isFacingNorth()) {
            rover.moveSouth();
        }
        if (rover.isFacingSouth()) {
            rover.moveNorth();
        }
        if (rover.isFacingEast()) {
            rover.moveWest();
        }
        if (rover.isFacingWest()) {
            rover.moveEast();
        }
    }
}
