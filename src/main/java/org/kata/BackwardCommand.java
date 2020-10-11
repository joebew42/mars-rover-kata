package org.kata;

import static org.kata.Position.*;

public class BackwardCommand implements Command {
    @Override
    public void apply(Rover rover) {
        if (rover.isFacingNorth()) {
            rover.move(DOWN);
        }
        if (rover.isFacingSouth()) {
            rover.move(UP);
        }
        if (rover.isFacingEast()) {
            rover.move(LEFT);
        }
        if (rover.isFacingWest()) {
            rover.move(RIGHT);
        }
    }
}
