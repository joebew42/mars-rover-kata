package org.kata;

import static org.kata.Position.*;

public class ForwardCommand implements Command {
    @Override
    public void apply(Rover rover) {
        if (rover.isFacingNorth()) {
            rover.move(UP);
        }
        if (rover.isFacingSouth()) {
            rover.move(DOWN);
        }
        if (rover.isFacingEast()) {
            rover.move(RIGHT);
        }
        if (rover.isFacingWest()) {
            rover.move(LEFT);
        }
    }
}
